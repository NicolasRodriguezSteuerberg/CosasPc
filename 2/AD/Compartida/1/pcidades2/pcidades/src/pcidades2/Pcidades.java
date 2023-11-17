package pcidades2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;


public class Pcidades {

    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException {
        Metodos obxM = new Metodos();
        String rutaEsc = "/media/sf_Compartida/1/pcidades2/listaz2";
        String rutaLec = "/media/sf_Compartida/1/pcidades2/zonas.txt";
        
        Connection con = obxM.conexion();
        obxM.leerDelimitado(con, rutaLec, rutaEsc);
        
        System.out.println("\n\n\n");
        obxM.leeSerializado(rutaEsc);
    }
    
}
