package pruebamongo;


public class PruebaMongo {

    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        String db = "test";
        String collectionDatos = "datos";
        obx.conect(db);
        // obx.crearDato();
        obx.updatePuntuationEstudiante(1, 2, 42);
        obx.verEstudiantePuntuacionExamenesTest();
        obx.cerrarCliente();
    }
    
}
