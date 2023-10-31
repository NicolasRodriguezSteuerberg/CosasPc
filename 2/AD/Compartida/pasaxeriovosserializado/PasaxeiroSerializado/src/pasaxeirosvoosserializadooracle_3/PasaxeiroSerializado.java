package pasaxeirosvoosserializadooracle_3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PasaxeiroSerializado {


    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        Metodos obx = new Metodos();
        Connection con = obx.conexion();
        
        String ruta = "/media/sf_Compartida/pasaxeriovosserializado/reservas";
        
        obx.lecturaSerializada(ruta, con);
    }
    
}
