package calculadoracliente;

import java.io.IOException;


public class CalculadoraCliente {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Metodos obx = new Metodos();
        obx.connect();
        boolean continuation = true;
        
        while (continuation){
            obx.getOperationOptions();
            obx.sendOperaciones();
            continuation = obx.receiveCalculation();
        }
    }
    
}
