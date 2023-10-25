package exa15brevep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class Metodos {
    
    public Connection conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host+ porto + "/" + sid;
        
        Connection conn = DriverManager.getConnection(url,usuario,password);
        
        return conn;
    }
    
    public void lecturaSerializada(String ruta, String rutaEsc) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, XMLStreamException{
        Connection con = conexion();
        ObjectInputStream lec = null;
        Platos obx = null;
        
        // para escribir el xml
        FileWriter obxFile = new FileWriter(rutaEsc);
        XMLOutputFactory obxFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter obxWriter = obxFactory.createXMLStreamWriter(obxFile);
        
        // empezamos el xml
        obxWriter.writeStartDocument("1.0");
        obxWriter.writeStartElement("platos");

        lec = new ObjectInputStream(new FileInputStream(ruta));
        
        do{
            obx = (Platos) lec.readObject();
            if(obx != null){
                System.out.println(obx.getCodigop() + "\n" + obx.getNomep());
                obxWriter.writeStartElement("plato");
                    obxWriter.writeAttribute("codigop", obx.getCodigop());
                    obxWriter.writeStartElement("nomep");
                        obxWriter.writeCharacters(obx.getNomep());
                    obxWriter.writeEndElement();
                lecturaDatos(con,obx.getCodigop(), obxWriter);
                obxWriter.writeEndElement();
            }
            else{
                System.out.println("Objeto nulo");
            }
        }while(obx != null);
        obxWriter.writeEndElement();
        obxWriter.close();
        lec.close();
    }
    
    public void lecturaDatos(Connection con,String codp, XMLStreamWriter obxWriter) throws SQLException, XMLStreamException{
        int peso;
        int graxa;
        String codc;
        String select = "select codc,peso from composicion where codp=?";
        PreparedStatement ps = con.prepareStatement(select);
                
        ps.setString(1, codp);
        
        ResultSet rs = ps.executeQuery();
        int graxa_total = 0;
        while(rs.next()){
            peso = rs.getInt("peso");
            codc = rs.getString("codc");
            
            select = "select graxa from componentes where codc=?";
            ps = con.prepareStatement(select);
        
            ps.setString(1, codc);
        
            ResultSet rs2 = ps.executeQuery();
    
            rs2.next();
            graxa = rs2.getInt("graxa");
            graxa_total+=(peso/100*graxa);
            
        }
        System.out.println("graxatotal: " + graxa_total);
        obxWriter.writeStartElement("graxatotal");
            obxWriter.writeCharacters(String.valueOf(graxa_total));
        obxWriter.writeEndElement();
        
    }
}
