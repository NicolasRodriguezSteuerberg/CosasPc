package excepcions;


public class Excepcions {

    
    public static void main(String[] args) {
        //creamos obxeto tipo DividirExcepciones
        DividirExcepcions obx = new DividirExcepcions();
        //1 Opcion, da error
        //obx.dividir(6, 0);
        
        //2 Opcion, xa sen que de erro
        //obx.dividir3BloquesExcepcion(6, 0);
        
        //3 Opcion
        //obx.dividirTratandoExcepcion(6, 0);
        
        //4 Opcion, usando o try/catch pasandoo
        /*try{
            obx.dividirPropagandoExcepcion(6, 0);
        }catch(ArithmeticException e){
            System.out.println("non dividir entre 0 " + e.getMessage()); //"non dividir entre 0" sobra, xa que o vai repetir polo e.getMessage()
        }*/
        
        //5 Opcion coa nosa excepcion
        try{
            obx.dividirCaNosaExcepcion(8, 0);
        }catch(NosaExcepcion e){
            System.out.println(e.getMessage());
        }
        
        
        
        System.out.println("Fin de programa");
        
    }
    
}
