package prueba;



public class Prueba {

    
    public static void main(String[] args) {
        Metodos obx = new Metodos();
        obx.connection();
        // obx.removeAll();
        // obx.insert();
        obx.selectPoints();
        obx.selectPointForId(1030);
        obx.selectTotalPoints();
        obx.selectAvg();
        // obx.updatePointForId(1030);
        // obx.deleteForId(1025);
        // obx.massiveUpdate(10);
        obx.massiveDelete(1001);
    }
    
}
