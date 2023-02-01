package earraylist;
import com.nicosteuerberg.datos.PedirDatos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class ListaEnteiros {
    
    ArrayList<Integer> listaEnteiros = new ArrayList();
    
    public ArrayList<Integer> crear(){
        listaEnteiros.add(2);
        listaEnteiros.add(3);
        listaEnteiros.add(4);
        listaEnteiros.add(5);
        return listaEnteiros;
    }
    
    public void ver(){
        System.out.println(listaEnteiros);//2 manera de observar a lista (por toString)        
    }
    
    public void añadir(ArrayList<Integer> listaEnteiros, int posicion){
        int num = PedirDatos.getInt("Teclee o elemento a añadir");
        listaEnteiros.add((posicion-1), num);
    }
    
    public void borrar(ArrayList<Integer> listaEnteiros, int posicion){
        listaEnteiros.remove((posicion-1));
    }
    
    public void buscarElemento(ArrayList<Integer> listaEnteiros, int elemento){
       if(listaEnteiros.contains(elemento) == true){
           JOptionPane.showMessageDialog(null, "O numero está na colección");
       }
       else{
           JOptionPane.showConfirmDialog(null, "No existe o numero na colección");
       }
    }
    
    public void añadirVarios(ArrayList<Integer> listaEnteiros, int cant){
        for (int i = 0; i < cant; i++) {
            listaEnteiros.add(PedirDatos.getInt("Teclee o número a añadir"));            
        }
    }
    
    public void borrarNumero(ArrayList<Integer> listaEnteiros, int numero){
        /*int atopar = 0;
        for(int i = 0; i < listaEnteiros.size(); i++){
            if(listaEnteiros.get(i) == numero){
                listaEnteiros.remove(i);
                atopar = 1;
            }
        }
        
        if(atopar == 1){
            JOptionPane.showMessageDialog(null, "Elemento borrado");
        }
        else if (atopar == 0){
            JOptionPane.showMessageDialog(null, "Elemento no encontrado");
        }*/
        /*
        listaEnteiros.remove(Integer.valueOf(numero));
        */
        Iterator it = listaEnteiros.iterator();
        int atopar = 0;
        while(it.hasNext()){
            if((int) it.next() == numero){
                it.remove();
                atopar = 1;
            }
        }
        if(atopar == 1){
            JOptionPane.showMessageDialog(null, "Elemento borrado");
        }
        else{
            JOptionPane.showMessageDialog(null, "Elemento no encontrado");
        }
    }
    
    public void ordenar(){
        Collections.sort(listaEnteiros);
    }
    public void ordenarMaiorMenor(){
        Collections.sort(listaEnteiros, Collections.reverseOrder());
    }
}
