package pinmobiliaria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Pinmobiliaria {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Metodos obx = new Metodos();
        String rutaSer = "/media/1/pinmobiliaria/listap";
        String rutaDel = "/media/1/pinmobiliaria/listap.txt";
        
        Connection con = obx.conexion();
        
        obx.leerSerializado(con, rutaSer, rutaDel);
    }
    
}
