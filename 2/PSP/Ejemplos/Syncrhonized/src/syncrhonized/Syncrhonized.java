package syncrhonized;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Syncrhonized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Contador cont = new Contador();	
	ContadorHilo hilo1 = new ContadorHilo("Hilo1",cont);
	ContadorHilo hilo2 = new ContadorHilo("Hilo2",cont);
	ContadorHilo hilo3 = new ContadorHilo("Hilo3",cont);
        ContadorHilo hilo4 = new ContadorHilo("Hilo4",cont);
 
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();


    }
    
}
