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
        if(nombre.equals("Tortuga")){
            miTablero.setThreadTortuga(this);
        } else{
            miTablero.setThreadLiebre(this);
        }
        
        
        while((terminado=miTablero.terminado)==false){
            try {
                if(nombre.equals("Tortuga")){
                    miTablero.movimientoTortuga();
                } else{
                    miTablero.movimientoLiebre();
                }
                
                Thread.sleep(500l);
                if(!(terminado=miTablero.terminado)){
                    miTablero.comprobación();
                }
                
                System.out.println();
                Thread.sleep(500l);
                
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
