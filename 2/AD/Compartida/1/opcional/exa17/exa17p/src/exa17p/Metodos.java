package exa17p;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class Metodos {
    
    public Connection dbConection() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host+ porto + "/" + sid;
        
        Connection con = DriverManager.getConnection(url,usuario,password);
        
        return con;
    }
    
    public void closeConection(Connection con) throws SQLException{
        con.close();
    }
    
    public static final int CANTIDADE = 1;
    public static final int DATA = 2;
    public static final int PRECIO = 3;
    
    public void leerXML(String rutaXML, Connection con) throws FileNotFoundException, XMLStreamException, SQLException{
        FileInputStream obxFile = new FileInputStream(rutaXML);
        XMLInputFactory obxFactory = XMLInputFactory.newInstance();
        XMLStreamReader obxReader = obxFactory.createXMLStreamReader(obxFile);
        
        int numeroEvent;
        
        String element = null, texto = null;
        int etiquetaPadre = 0;
        
        Pedido obx = new Pedido();
        
        while(obxReader.hasNext()){
            obxReader.next();
            numeroEvent = obxReader.getEventType();
            
            switch(numeroEvent){
                case XMLStreamConstants.START_ELEMENT:
                    element = obxReader.getLocalName();
                    // guardo en una varible en que etiqueta estamos 
                    // para que cuando cojamos el texto sepamos donde estamos
                    switch(element){
                        case "Cantidade":
                            etiquetaPadre = CANTIDADE;
                            break;
                        case "Data":
                            etiquetaPadre = DATA;
                            break;
                        case "Pedido":
                            obx.setCodcli(obxReader.getAttributeValue(0));
                            obx.setCodpro(obxReader.getAttributeValue(1));
                            etiquetaPadre = 0;
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    break;
                case XMLStreamConstants.ATTRIBUTE:
                    break;
                case XMLStreamConstants.CHARACTERS:
                    texto = obxReader.getText();
                    // para saber que estamos leyendo exactamente
                    switch(etiquetaPadre){
                        case CANTIDADE:
                            obx.setCantidade(Integer.parseInt(texto));
                            etiquetaPadre = 0;
                            break;
                        case DATA:
                            obx.setData(texto);
                            System.out.println(obx.toString());
                            decreaseStock(con, new Pedido(obx.getCodcli(), obx.getCodpro(), obx.getCantidade(), obx.getData()));
                            etiquetaPadre = 0;
                            System.out.println("\n");
                            break;
                        default:
                            etiquetaPadre = 0;
                            break;
                    }
                    break;
            }
        }
    }
    
    public void decreaseStock(Connection con, Pedido obx) throws SQLException{
        String update = "update produtos SET stock = stock - ? where codigop = ?";
        PreparedStatement ps = con.prepareStatement(update);
        
        ps.setInt(1, obx.getCantidade());
        ps.setString(2, obx.getCodpro());
        
        int verificacion = ps.executeUpdate();
        if(verificacion == 0){
            System.out.println("Error: Produto (decreaseStock) no encontrado o modificacion no permitida");
        } else{
            System.out.println("Modificacion decreaseStock exitosa");
        }
        
        ps.close();
        increaseGastoCliente(con, obx);
    }
    
    public void increaseGastoCliente(Connection con, Pedido obx) throws SQLException{
        String update = "update clientes SET gasto = gasto + ? where codigoc = ?";
        PreparedStatement ps = con.prepareStatement(update);
        
        
        ps.setInt(1, getGasto(con, obx));
        ps.setString(2, obx.getCodcli());
        
        int verificacion = ps.executeUpdate();
        if(verificacion == 0){
            System.out.println("Error: Cliente (increaseGastoCliente) no encontrado o modificacion no permitida");
        } else{
            System.out.println("Modificacion (increaseGastoCliente) exitosa");
        }
        
        ps.close();
        addVenda(con, obx);
    }
    
    public int getGasto(Connection con, Pedido obx) throws SQLException{
        String select = "select prezo from produtos where codigop=?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, obx.getCodpro());
        
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        int gasto = rs.getInt("prezo") * obx.getCantidade();
        
        ps.close();
        return gasto;
    }
    
    public void addVenda(Connection con, Pedido obx) throws SQLException{
        String insert = "insert into vendas(codigoc, codigop, data, total) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insert);
        
        ps.setString(1, obx.getCodcli());
        ps.setString(2, obx.getCodpro());
        ps.setString(3, obx.getData());
        ps.setInt(4, getGasto(con, obx));
        
        ps.executeUpdate();
        
        System.out.println("Insert venda añadido");
    }
    
}
