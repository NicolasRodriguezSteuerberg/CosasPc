package pfincas;

import java.sql.SQLException;


public class Pfincas {

    public static void main(String[] args) throws SQLException {
        Metodos obx = new Metodos();
        String rutaMongo = "test";
        obx.connection(rutaMongo);
        obx.getFincas();
        
        obx.close();
    }
    
}
