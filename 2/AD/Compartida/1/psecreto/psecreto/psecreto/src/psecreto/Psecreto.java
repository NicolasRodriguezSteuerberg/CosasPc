package psecreto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Psecreto {

    public static void main(String[] args) throws SQLException, IOException, IOException, FileNotFoundException, FileNotFoundException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException {
        String rutaStream = "/media/sf_Compartida/1/psecreto/clave1";
        String rutaBuf = "/media/sf_Compartida/1/psecreto/clavesuma";
        
        Metodos obx = new Metodos();
        
        Connection con = obx.conexion();
        
        obx.leer(con, rutaStream, rutaBuf);
    }
    
}
