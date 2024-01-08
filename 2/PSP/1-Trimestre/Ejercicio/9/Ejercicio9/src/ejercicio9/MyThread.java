package ejercicio9;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread extends Thread{
    String name;

    public MyThread(String name) {
        this.name = name;
    }
    
    public void run(){
        long nRandom;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Iteracion nº" + i + ", soy " + name);
            nRandom = (long) (Math.random()*(1001-500)+500);
            try {
                Thread.sleep(nRandom);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("");
    }
    
}
