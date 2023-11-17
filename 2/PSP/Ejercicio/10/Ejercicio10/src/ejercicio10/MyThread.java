package ejercicio10;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread extends Thread{
    
    int numCoche;
    Parking miParking;
    
    public MyThread(int numCoche, Parking miParking){
        this.numCoche = numCoche;
        this.miParking = miParking;
    }
    
    public void run(){
        try {
            miParking.entrada(numCoche);
            Thread.sleep((long) (Math.random()*(2000-500)+500));
            miParking.salida(numCoche);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
