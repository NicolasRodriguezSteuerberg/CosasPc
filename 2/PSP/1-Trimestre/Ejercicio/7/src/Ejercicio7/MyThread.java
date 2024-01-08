package Ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread extends Thread{
    String nombre, cadena;
    Buzon buz;
    
    public MyThread(String nombre, String cadena, Buzon buz){
        this.nombre = nombre;
        this.cadena = cadena;
        this.buz = buz;
    }
    
    public void run(){
        if(nombre.equals("Enviar")){
            try {
                buz.escribir(cadena);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                buz.lectura(nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
