/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Dineros obxD = new Dineros();
            ThreadIngreso obxI = null;
            ThreadExtraccion obxE = null;
            for (int i = 0; i < 5; i++) {
                obxI = new ThreadIngreso(obxD, 33);
                obxI.start();
                obxI.join();
                obxI = new ThreadIngreso(obxD, 23);
                obxI.start();
                obxI.join();
                obxE = new ThreadExtraccion(obxD, 16);
                obxE.start();
                obxE.join();
            }
            obxI.join();
            obxE.join();
            System.out.println("Dinero total: " + obxD.getDinero() + "€");
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
