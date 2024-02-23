package pavions;

import java.sql.SQLException;


public class PAvions {

    
    public static void main(String[] args) throws SQLException {
        Metodos obx = new Metodos();
        String mongoBD = "test";
        obx.connection(mongoBD);
        obx.leerReservas();
        System.out.println("\n");
        obx.seeConfirmadas();
        
        obx.close();
    }
    
}
