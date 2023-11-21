package pfungos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
        

public class Pfungos {

    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException {
        Metodos obx = new Metodos();
        Connection con = obx.conexion();
        String rutaSerializado = "";
        String rutaDelimitado = "";
        obx.leerDetectadosSerializado(con, rutaSerializado, rutaDelimitado);
    }
    
}
