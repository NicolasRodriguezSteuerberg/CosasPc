package earraylist;

import java.util.ArrayList;

/**
 *
 * @author NSteuerberg
 */
public class Metodos {
    
    ArrayList lista = new ArrayList();
    //podemos meter calquer tipo de dato
    public void crear(){
        lista.add(2);
        lista.add("aaa");
        lista.add(2.3);
        lista.add('b');
    }
    
    public void ver(){
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
}
