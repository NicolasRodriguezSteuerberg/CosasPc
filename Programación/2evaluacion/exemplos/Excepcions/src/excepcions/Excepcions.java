package excepcions;


public class Excepcions {

    
    public static void main(String[] args) {
        //creamos obxeto tipo DividirExcepciones
        DividirExcepcions obx = new DividirExcepcions();
        //obx.dividir(6, 0);
        //obx.dividir3BloquesExcepcion(6, 0);
        //obx.dividirTratandoExcepcion(6, 0);
        try{
            obx.dividirPropagandoExcepcion(6, 0);
        }catch(ArithmeticException e){
            System.out.println("non dividir entre 0 " + e.getMessage());
        }
        System.out.println("Fin de programa");
        
    }
    
}
