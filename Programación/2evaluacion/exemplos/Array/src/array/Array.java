package array;


public class Array {


    public static void main(String[] args) {
        //Creo o obxecto metodos
        Metodos obx = new Metodos();
        float [] auxiliar; //para gardar o array de metodos tempos que crear un array
        auxiliar = obx.crearArrayFloat(); //igualamos o array co metodo da array
        obx.amosarArray(auxiliar);
        
        obx.amosarPorPosicion(auxiliar, 3);
        
        obx.amosarArrayForEach(auxiliar);
        
    }
    
}
