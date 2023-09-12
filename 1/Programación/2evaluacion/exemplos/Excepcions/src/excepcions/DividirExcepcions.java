package excepcions;


public class DividirExcepcions {
    //creo metodo dividir
    public void dividir(int numerador, int denominador){
        int resultado = numerador/denominador;
        System.out.println(numerador + "/" + denominador + " = " + resultado);
    }
    
    //creo metodo dividir tratando excepcions
    public void dividirTratandoExcepcion(int numerador, int denominador){
        try{
            int resultado = numerador/denominador;
            System.out.println(numerador + "/" + denominador + " = " + resultado);
        }
        
        catch(ArithmeticException ex){
            System.out.println("erro ao dividir " + ex.getMessage());
        }
        
        System.out.println("Remata o metodo");
    }
    
    public void dividir3BloquesExcepcion(int numerador, int denominador){
        try{
            int resultado = numerador/denominador;
            System.out.println(numerador + "/" + denominador + " = " + resultado);
        }
        
        catch(ArithmeticException ex){
            System.out.println("erro ao dividir " + ex.getMessage());
        }
        finally{
            System.out.println("ESTE BLOQUE EXECUTASE SEMPRE");
        }
        System.out.println("Remata o metodo");
    }
    
    public void dividirPropagandoExcepcion(int numerador, int denominador) throws ArithmeticException{
        if(denominador == 0){
            throw new ArithmeticException("OLLO NON DIVIDAS ENTRE 0");
        }
        else{
            int resultado = numerador/denominador;
            System.out.println(numerador + "/" + denominador + " = " + resultado);
        }
    }
    
    public void dividirCaNosaExcepcion(int numerador, int denominador) throws NosaExcepcion{
        if (denominador == 0){
            throw new NosaExcepcion("Non dividas entre 0 ****");
        }
        
        else{
            int resultado = numerador/denominador;
            System.out.println(numerador + "/" + denominador + " = " + resultado);
        }
    }
    
    
    
}
