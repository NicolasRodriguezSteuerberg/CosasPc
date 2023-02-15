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
    
    public <T> void elementoMinimo(ArrayList<T> aux){
        System.out.println("Elemento mínimo: " + Collections.min(aux, null));   
    }
    
    public <T> void elementoMaximo(ArrayList<T> aux){
        System.out.println("Elemento máximo: " + Collections.max(aux, null));
    }

    public <T> void buscarElemento(ArrayList<T> aux, T buscar){
        Iterator it = aux.iterator();
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
        }
        if(posicion  != -1){
            System.out.println("O numero: " + buscar + " aparece na posición " + posicion);
        }
        else{
            System.out.println("O numero: " + buscar + " no aparece " + posicion);
        }
    }
}
