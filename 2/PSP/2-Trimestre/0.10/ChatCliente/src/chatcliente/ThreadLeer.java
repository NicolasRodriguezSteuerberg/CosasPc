package chatcliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ThreadLeer extends Thread{
    Metodos obx;
    
    public ThreadLeer(Metodos obx){
        this.obx = obx;
    }
    
    public void run(){
        try {
            obx.leerMensaje();
        } catch (IOException ex) {
            System.out.println("Aviso: " + ex);
        }
    }
}
