package xenericos;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author NSteuerberg
 */
public class ColeccionsXenericas <T>{
    public <T> void engadir(T elemento, ArrayList<T> aux){
        aux.add(elemento);
    }
    
    public static <T> void amosar(ArrayList<T> aux){
        for(T elemento:aux){
            System.out.println(elemento);
        }
    }
    
    public <T> void ordenar(ArrayList<T> aux){
        aux.sort((Comparator<? super T>) Comparator.naturalOrder());
        for(T elemento:aux){
            System.out.println(elemento);
        }
    }

    
}
