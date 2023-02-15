/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author dam1
 */
public class Operacions <T>{
        
    //metodos
    public <T> void engadir(T elemento, ArrayList<T> lista){
        lista.add(elemento);
    }
    
    public <T> void elementoMinimo(ArrayList<T> aux){
        System.out.println("\nElemento mínimo: " + Collections.min(aux, null));   
    }
    
    public <T> void elementoMaximo(ArrayList<T> aux){
        System.out.println("\nElemento máximo: " + Collections.max(aux, null));
    }

    public <T> void buscarElemento(ArrayList<T> aux, T buscar){
        /*Iterator it = aux.iterator();
        int posicion = -1;
        int contador = 0;
        for(T elemento: aux){
            if(posicion == -1){
                if(it.hasNext()){
                    contador++;
                    if(it.next()==buscar){
                        posicion = contador;
                    }
                }
            }
        }*/
        if(aux.indexOf(buscar)>=0){
            System.out.println("\nO numero: " + buscar + " aparace na posición: " + (aux.indexOf(buscar)+1));
        }        
        else{
            System.out.println("\nO numero: " + buscar + " no aparece: -1");
        }
    }
    
    public <T> void borrarPrimero(ArrayList<T> aux){
        T ele;
        if(aux.size()>=1){
            ele = aux.get(0);
            aux.remove(0);
            System.out.println("\nO elemento borrado é " + ele);
        }
        else{
            System.out.println("\nNon se pode borrar, no quedan elementos");
        }
        
    }
}
