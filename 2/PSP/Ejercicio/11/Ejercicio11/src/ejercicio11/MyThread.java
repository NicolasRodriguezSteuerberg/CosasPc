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
            try {
                if(nombre.equals("Tortuga")){
                    miTablero.movimientoTortuga();
                } else{
                    miTablero.movimientoLiebre();
                }
                terminado = miTablero.comprobación();

                System.out.println();
                Thread.sleep(1000l);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
