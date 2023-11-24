package supermarket;

import java.util.ArrayList;


public class Supermercado {
    int nCajas;
    int valorCajaTotal = 0;
    boolean usandoseCajaTotal = false;
    boolean usandoseCaja[];
    ArrayList<ThreadClientes> listaClientes = new ArrayList();
    ArrayList<ThreadCola> listaCola = new ArrayList();
    
    public Supermercado(int nCajas){
        this.nCajas = nCajas;
        this.usandoseCaja = new boolean[nCajas];
        for (int i = 0; i < this.usandoseCaja.length; i++) {
            this.usandoseCaja[i] = false;
        }
    }
    
    public synchronized void ponerDinero(int nCaja, int dineroAIngresar) throws InterruptedException{
        while(usandoseCajaTotal){
            wait();
        }
        usandoseCajaTotal=true;
        System.out.println("\nLa persona de la caja: " + nCaja + " está ingresando este dinero: " + dineroAIngresar);
        Thread.sleep(1000l);
        valorCajaTotal += dineroAIngresar;
        System.out.println("La persona de la caja: " + nCaja + " ha ingresado el dinero, dinero total: " + valorCajaTotal + "\n");
        usandoseCaja[nCaja] = false;
        usandoseCajaTotal=false;
        notifyAll();
    }
    
    public synchronized void usarCaja(String name, int cajaAUsar, int pago) throws InterruptedException{
        while(usandoseCaja[cajaAUsar]){
            wait();
        }
        System.out.println("El " + name + " ha pasado a ser cobrado en la caja: " + cajaAUsar + "\t Le ha pagado " + pago + "€ por su compra");
        Thread.sleep(1000l);
        notifyAll();
        ponerDinero(cajaAUsar, pago);
    }
    
}
