package pfungos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
        

public class Pfungos {

    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException {
        Metodos obx = new Metodos();
        Connection con = obx.conexion();
        String rutaSerializado = "/media/sf_Compartida/1/Pfungo/detectados";
        String rutaDelimitado = "/media/sf_Compartida/1/Pfungo/final";
        obx.leerDetectadosSerializado(con, rutaSerializado, rutaDelimitado);
    }
    
}
