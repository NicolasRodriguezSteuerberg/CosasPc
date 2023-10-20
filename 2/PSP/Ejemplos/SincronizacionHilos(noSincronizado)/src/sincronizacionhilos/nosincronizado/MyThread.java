/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacionhilos.nosincronizado;

/**
 *
 * @author dam2
 */
public class MyThread extends Thread{
    String cadena;
    int numeroLetra;
    String vocales = "aeiouAEIOU";
    boolean isFinal = false;
    
    public MyThread(String cadena, int numeroLetra){
        this.cadena = cadena;
        this.numeroLetra = numeroLetra;
    }
    
    public void run(){
        boolean vocal = false;
        while(vocal == false){
            for(int i = numeroLetra; i < cadena.length(); i++){
                vocal = (vocales.indexOf(cadena.charAt(i)) !=-1) ? true : false;
                if(vocal==true){
                    numeroLetra = i;
                    if(numeroLetra == (cadena.length()-1)){
                        isFinal = true;
                    }
                    break;
                }
                
            }
            
        }
    }
}
