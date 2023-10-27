package Ejercicio7;


public class Buzon {
    private String mensaje = null;
    
    public synchronized void escribir(String mensaje) throws InterruptedException{
        while(this.mensaje != null){
            wait();
        }
        this.mensaje = mensaje;
        notify();
    }
    
    public synchronized void lectura(String nombre) throws InterruptedException{
        while(this.mensaje == null){
            wait();
        }
        System.out.println(nombre + ": " + mensaje);
        mensaje = null;
        notify();
    }
    
}
