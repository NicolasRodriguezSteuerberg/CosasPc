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
    
}
