package ejercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread extends Thread{
    
    int firstCall, lastCall;
    Elevator elv;
    String persona;
    
    public MyThread(int firstCall, int lastCall, Elevator elv, String persona){
        this.firstCall = firstCall;
        this.lastCall = lastCall;
        this.elv = elv;
        this.persona = persona;
    }
    
    public void run(){
        try {
        elv.callElevator(firstCall, persona);
        Thread.sleep(100);
        elv.callElevator(lastCall, persona);
        System.out.println(persona + " ha acabado sus trayectos\n");
    } catch (InterruptedException ex) {
        Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
