package calculadoraserver;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;


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
                obx.getOperation();
                obx.sendCalculation();
                continuation = obx.getContinuation();
                System.out.println(continuation);
            }
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ScriptException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
