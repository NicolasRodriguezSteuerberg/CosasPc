/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacionhilos.nosincronizado;

/**
 *
 * @author dam2
 */
public class Letra {
    String vocales = "aeiouAEIOU";
    boolean isFinal = false;
    int numero = 0;
    String cadena;
    
    public Letra(String cadena){
        this.cadena = cadena;
    }
    
    public synchronized boolean cuenta(String nombre){
        boolean vocal = false;
        int numeroLetra = numero;
        if(numeroLetra<(cadena.length() - 1)){
            while(vocal == false){
                for(int i = numeroLetra; i < cadena.length(); i++){
                    vocal = vocales.contains(String.valueOf(cadena.charAt(i)));
                    if(vocal==true){
                        numeroLetra = i;
                        numero = numeroLetra + 1;
                        System.out.println(nombre + " ha leido la letra: " + cadena.charAt(numeroLetra));
                        break;
                    }
                }
            }
        }
        if(numeroLetra == (cadena.length()-1)){
            isFinal=true;
        }
        return isFinal;
    }
}
