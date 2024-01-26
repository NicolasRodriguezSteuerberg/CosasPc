package calculadoraserver;

import java.io.IOException;


public class CalculadoraServer {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Metodos obx = new Metodos();
        obx.waitingConnection();
        
        boolean continuation = true;
        
        while(continuation){
            obx.getOperando();
            obx.getNumbers();
            obx.sendCalculation();
            continuation = obx.getContinuation();
        }
        
    }
    
}
