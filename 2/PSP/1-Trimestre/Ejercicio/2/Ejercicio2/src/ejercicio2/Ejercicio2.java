/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            MyThread obx1 = new MyThread("1");
            MyThread obx2 = new MyThread("2");
            MyThread obx3 = new MyThread("3");
            MyThread obx4 = new MyThread("4");
            
            obx1.start();
            obx1.join(); //hasta que no termina esto, no se hace lo de abajo (todo lo de abajo)
            
            obx2.start();
            obx2.join();
            
            obx3.start();
            obx3.join();
            
            obx4.start();
            obx4.join();
            
            //hasta que no termina el 1 no empieza el segundo, hasta que no termina este, no empieza el 3...
            
            /*
            obx1.start();
            obx2.start();
            obx3.start();
            obx4.start();
            //Todos se hacen simultaneamente
            
            obx1.join();
            obx2.join();
            obx3.join();
            obx4.join();
            //Hasta que no termine el 1, el 2, el 3 y el 4 no se printea el fin
            //Podria ser que el 2 terminara antes que el 1, el 4 antes que el 2 y el 3 despues del 1
            */
            
            /*
            obx1.start();
            obx2.start();
            obx3.start();
            obx4.start();
            
            obx1.join();
            System.out.println("Termina hilo 1");
            
            obx2.join();
            System.out.println("Termina hilo 2");
            
            obx3.join();
            System.out.println("Termina hilo 3");
            
            obx4.join();
            System.out.println("Termina hilo 4");
            //Podria ser que saliese un sout y después una iteracion del hilo y que salga el termina hilo
            //Ejemplo:
            //Termina el hilo 1 -> hilo 2: 4 --> termina hilo 2...
            */
            
            System.out.println("FIN");//sale de último siempre por culpa del join
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}
