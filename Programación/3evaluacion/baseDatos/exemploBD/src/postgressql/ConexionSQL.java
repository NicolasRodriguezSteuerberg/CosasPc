package postgressql;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NSteuerberg
 */
public class ConexionSQL {
    Connection obxConectar = null;
    String url="jdbc:postgresql://local/exemploBD"; 
    //local -> ip de nuestro servidor
    //exemploBD -> el nombre de la base de datos
    String user=""; //usuario de la base de datos
    String password="";//su contraseña
    
    public String abrirConexion(){
        //returnamos un String para poder mandar un mensaje de si se pudo conectar o no en la UI
        try{
            Class.forName("org.postgresql.Driver");
            obxConectar = DriverManager.getConnection(url,user,password);
            return "Conexión realizada";
        }catch(Exception e){
            return "Conexion sin exito";
        }
    }
    
    public void cerrarConexion(){
        
    }
    
}
