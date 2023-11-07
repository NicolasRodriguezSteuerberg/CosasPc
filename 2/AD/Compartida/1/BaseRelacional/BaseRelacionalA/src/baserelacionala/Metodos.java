package baserelacionala;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
    
    public void insireProduto(Connection conn, String codigo, String descricion, int prezo, String data) throws SQLException, ParseException{
        
        System.out.println(data);
        
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
        java.util.Date d;
        d = format.parse(data);
        
        java.sql.Date dateSql = new java.sql.Date(d.getTime());
        
        System.out.println(dateSql);
        
        Statement obx = conn.createStatement();
        String insert = "insert into produtos values('"+codigo + "','" + descricion + "'," + prezo + ",'" + dateSql + "');";
        obx.executeUpdate(insert);
        
        System.out.println("Insert añadido");
        
        obx.close();
    }
    
    public void consultar(Connection conn) throws SQLException{
        Statement obxStatement = conn.createStatement();
        String busqueda = "select * from produtos";
        ResultSet obxRes = obxStatement.executeQuery(busqueda);
        
        String codigo,descricion;
        int prezo;
        Date data;
        
        while(obxRes.next()){
            codigo = obxRes.getString("codigo");
            descricion = obxRes.getString("descricion");
            prezo = obxRes.getInt("prezo");
            data = obxRes.getDate("datac");
            System.out.println(codigo + ", " + descricion + ", " + prezo + ", " + data);
        }
        
        obxStatement.close();
    }
    
    public void borrar(Connection conn, String codigo) throws SQLException{
        Statement obxStatement = conn.createStatement();
        
        String busqueda = "delete from produtos where codigo = '" + codigo + "';";
        int numero = obxStatement.executeUpdate(busqueda);
        
        if(numero == 0){
            System.out.println("Producto no encontrado");
        } else {
            System.out.println("Producto borrado");
        }
        
        obxStatement.close();
    }
    
    public void modificar(Connection conn, String codigoBorrar, int novoPrezo) throws SQLException{
        Statement obxStatement = conn.createStatement();
        String busqueda = "update produtos set prezo = " + novoPrezo + " where codigo = " + codigoBorrar + ";";
        int numero = obxStatement.executeUpdate(busqueda); 
        
        if(numero == 0){
            System.out.println("Producto no encontrado");
        } else{
            System.out.println("Producto modificado");
        }
        
    }
    
}
