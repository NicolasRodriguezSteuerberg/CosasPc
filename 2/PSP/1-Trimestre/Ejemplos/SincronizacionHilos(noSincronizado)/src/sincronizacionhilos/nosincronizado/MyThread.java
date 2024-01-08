/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacionhilos.nosincronizado;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class MyThread extends Thread{
    Letra let;
    String nombre;
    boolean isFinal = false;
    
    public MyThread(Letra let, String nombre){
        this.let = let;
        this.nombre = nombre;
    }
    
    public void run(){
        while(!isFinal){
            isFinal = let.cuenta(nombre);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error sleep");
            }
        }
    }
}
