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
        
        Contador cuenta = new Contador();
        
        MyThread hilo1 = new MyThread("primer");
        MyThread hilo2 = new MyThread("segundo");
        MyThread hilo3 = new MyThread("tercero");
        MyThread hilo4 = new MyThread("cuarto");
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

    }
    
}
