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
    private ArrayList<T> dato;
    
    public Operacions(){
        this.dato = new ArrayList<>();
    }
    
       
    public <T> void engadir(T elemento, ArrayList<T> lista){
        lista.add(elemento);
    }
    
    public T elementoMinimo(ArrayList<T> aux){
        T min = null;
        for(T elemento: aux){
            if(min==null){
                min = elemento;
            }
            if(min > elemento){
                min = elemento;
            }
        }
        return min;   
    }
    
    public static <T> void elementoMaximo(ArrayList<T> aux){
        
    }


}
