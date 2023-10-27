/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sincronizacionhilos.nosincronizado;

/**
 *
 * @author dam2
 */
public class SincronizacionHilosNoSincronizado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena = "No quiero tener vocales";
        
        Letra let = new Letra(cadena);
        
        MyThread thread = new MyThread(let,"Hilo 1");
        MyThread thread2 = new MyThread(let,"Hilo 2");
        MyThread thread3 = new MyThread(let,"Hilo 3");
        MyThread thread4 = new MyThread(let,"Hilo 4");
        MyThread thread5 = new MyThread(let,"Hilo 5");
        
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
    
}
