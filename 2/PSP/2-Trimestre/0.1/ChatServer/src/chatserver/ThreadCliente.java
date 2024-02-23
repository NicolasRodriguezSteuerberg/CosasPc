package chatserver;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;

public class ThreadCliente extends Thread{
    Socket clienteSocket;
    
    public ThreadCliente(Socket clienteSocket){
         this.clienteSocket = clienteSocket;
    }
    
    public void run(){
        Metodos obx = new Metodos();
        try {
            obx.initializeStreams(clienteSocket);
            
            clienteSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
