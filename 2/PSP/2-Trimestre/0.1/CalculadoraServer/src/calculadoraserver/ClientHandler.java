package calculadoraserver;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientHandler extends Thread{
    private Socket clientSocket;
    
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }
    
    public void run(){
        Metodos obx = new Metodos();
        
        try {
            obx.initializeStreams(clientSocket);
            boolean continuation = true;
        
            while(continuation){
                obx.sendPosibilityOperations();
                obx.getOperando();
                obx.getNumbers();
                obx.sendCalculation();
                continuation = obx.getContinuation();
            }
            
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
