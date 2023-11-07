package pasaxeirovosdelimitado;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Pasaxeirovosdelimitado {

    public static void main(String[] args) throws SQLException, IOException {
        Metodos obx = new Metodos();
        Connection con = obx.conexion();
        
        String ruta = "/media/sf_Compartida/pasaxeirosvosdelimitado/reservas.txt";
        
        obx.lerReservas(con, ruta);
    }
    
}
