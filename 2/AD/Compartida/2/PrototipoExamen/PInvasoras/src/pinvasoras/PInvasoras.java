package pinvasoras;

import java.sql.SQLException;


public class PInvasoras {

    public static void main(String[] args) throws SQLException {
        Metodos obx = new Metodos();
        String mongoDB = "test";
        obx.connection(mongoDB);
        
        obx.seeZonas();
        
        System.out.println();
        
        obx.seeEncontradas();
        
        System.out.println();
        
        obx.seeZonas();
    }
    
}
