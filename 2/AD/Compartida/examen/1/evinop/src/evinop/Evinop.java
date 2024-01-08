package evinop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Evinop {


    public static void main(String[] args) throws IOException, SQLException, FileNotFoundException, ClassNotFoundException {
        Metodos obx = new Metodos();
        String rutaTxt = "/media/sf_Compartida/examen/1/analisis.txt";
        String rutaSerializado = "/media/sf_Compartida/examen/1/xerado";
        Connection con = obx.conexion();
        obx.leerAnalisis(con, rutaTxt, rutaSerializado);
    }
    
}
