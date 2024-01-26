package evino;


public class Evino {

    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        obx.conect("test");
        obx.getAnalisis();
        obx.cerrarCliente();
    }
    
}
