package calculadoracliente;

import java.io.IOException;


public class CalculadoraCliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        Metodos obx = new Metodos();
        obx.connect();
        boolean continuation = true;
        
        while (continuation){
            obx.sendOperation();
            continuation = obx.receiveCalculation();
            System.out.println(continuation);
        }
    }
    
}
