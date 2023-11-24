package supermarket;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadClientes extends Thread{
    String name;
    int pago;
    Supermercado miSuper;
    int cajaAUsar;
    
    public ThreadClientes(int name, Supermercado miSuper){
        this.name = "Cliente " + name;
        this.miSuper = miSuper;
    }
    
    public void run(){
        try {
            System.out.println("Ha entrado el " + name + ", está cogiendo los productos a comprar");
            Thread.sleep((long)(Math.random()*10000));
            cajaAUsar = (int)(Math.random()*(miSuper.nCajas));
            pago = (int) (Math.random()*(100));
            miSuper.usarCaja(name, cajaAUsar, pago);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
