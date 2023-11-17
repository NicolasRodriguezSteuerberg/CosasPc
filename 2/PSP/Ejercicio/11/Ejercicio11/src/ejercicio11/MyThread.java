package ejercicio11;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread extends Thread{
    String nombre;
    Tablero miTablero;

    public MyThread(String nombre, Tablero miTablero) {
        this.nombre = nombre;
        this.miTablero = miTablero;
    }
 
    public void run(){
        boolean terminado = false;
        while(terminado==false){
            if(nombre.equals("Tortuga")){
                miTablero.movimientoTortuga();
            } else{
                miTablero.movimientoLiebre();
            }
            miTablero.comprobación();
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
