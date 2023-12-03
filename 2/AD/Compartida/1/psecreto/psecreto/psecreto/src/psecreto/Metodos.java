package psecreto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Metodos {
    
    String cadena="";
    
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
    
    // leer la tabla referencia
    public void leer(Connection con, String rutaStream, String rutaBuf) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
        String select = "select * from referencia";
        PreparedStatement ps = con.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            leerClaveDelimitado((leerClave1(rs.getString("c1"), rutaStream)+leerClave2(rs.getString("c2"), con)),rutaBuf);
        }
        
        ps.close();
        
        System.out.println("\n\nCadena final: " + cadena);
        
    }
    
    // con la letra de la columna c1 coges el numero de la letra
    // del serializado de clave1
    public int leerClave1(String c1, String rutaStream) throws IOException, ClassNotFoundException{
        ObjectInputStream lecStream = new ObjectInputStream(new FileInputStream(rutaStream));
        Clave1 obxClave = null;
        do{
            obxClave = (Clave1) lecStream.readObject();
        }while(!obxClave.getCla1().equals(c1));
        int numero = obxClave.getNum1();
        lecStream.close();
        return numero;
    }
    // con la letra de la columna c2 coges el numero de la letra
    // lees el numero de clave2
    public int leerClave2(String c2, Connection con) throws SQLException{
        String select = "select num2 from clave2 where cla2 = ?";
        PreparedStatement ps = con.prepareStatement(select);
        
        ps.setString(1, c2);
        
        ResultSet rs = ps.executeQuery();
        
        rs.next();
        
        int numeroRef=rs.getInt("num2");
        System.out.println("NumeroClave2: " + numeroRef);
        ps.close();
        
        return numeroRef;
    }
    
    public void leerClaveDelimitado(int clave, String rutaBuf) throws IOException{
        BufferedReader lecBuf = new BufferedReader(new FileReader(rutaBuf));
        String lectura = null;
        int numBandera;
        while((lectura=lecBuf.readLine())!= null){
            numBandera = Integer.parseInt(lectura.split("_")[0]);
            if(numBandera == clave){
                System.out.println(lectura.split("_")[1]);
                System.out.println("cadena: " + (cadena += lectura.split("_")[1]));
                break;
            }
        }
        lecBuf.close();
    }
}
