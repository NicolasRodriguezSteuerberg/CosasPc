package earraylistobxetos;

import com.nicosteuerberg.datos.PedirDatos;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author NSteuerberg
 */
public class Metodos {
    
    public ArrayList<Xogador> engadir(ArrayList<Xogador> lista){
        int num = PedirDatos.getInt("Teclee a cantidad de xogadores a añadir");
        
        /*Podese deste xeito o da maneira que está despois desta*/
        for (int i = 0; i < num; i++) {
            Xogador obx = new Xogador(PedirDatos.getString("Teclee o nombre do " + (i+1) + "º  xogador"),PedirDatos.getInt("Teclee o dorsal do " + (i+1) + "º  xogador"));
            
            //para que non se repita o dorsal:
            for (int j = 0; j < lista.size(); j++) {
                while(lista.get(j).getDorsal() == obx.getDorsal()){
                    obx.setDorsal(PedirDatos.getInt(" O numero " + obx.getDorsal() + " está usado." + "\nTeclee un dorsal non usado"));
                    j = 0;
                }
            }
            
            lista.add(obx);
        }
        /*
        for (int i = 0; i < num; i++) {
            lista.add(new Xogador(PedirDatos.getString("Teclee o nombre do " + (i+1) + " xogador"),PedirDatos.getInt("Teclee o seu dorsal")));            
        }*/
        return lista;
    }
    
    public void amosarArray(ArrayList<Xogador> lista){
        //Hai 4 maneras para amosar unha array
        
        /*1º
        System.out.println(lista);
        */
        /*2º for each
        for (Xogador xo :lista){
            System.out.println(xo);
        }
        */
        /*3º for
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        */
        /*4º iterator*/
        Iterator it = lista.iterator();
        while(it.hasNext()){
            /*Podese facer de dous xeitos
            Xogador aux = (Xogador) it.next();
            System.out.println(aux);
            */
            System.out.println(it.next());
        }
        System.out.println("");
        

    }
    /*
    public void buscarElemento(ArrayList<Xogador> lista, int buscar){
        int auxiliar = 0;
            for (Xogador xo : lista){
                if(xo.getDorsal() == buscar){
                    JOptionPane.showMessageDialog(null,"O xogador co dorsal es " + buscar + " " + xo.getNome());
                    auxiliar = 1;
                }
            }
        
        if(auxiliar == 0){
            JOptionPane.showMessageDialog(null, "Dorsal no encontrado");
        }
    }
    */
    public int buscarElemento(ArrayList<Xogador> lista, int buscar){
        int atopado = 0;
            for (Xogador xo : lista){
                if(xo.getDorsal() == buscar){
                    JOptionPane.showMessageDialog(null,"O xogador co dorsal es " + buscar + " " + xo.getNome());
                    atopado = 1;
                }
            }
        
        if(atopado == 0){
            JOptionPane.showMessageDialog(null, "Dorsal no encontrado");
        }
        return atopado;
    }
    
    public void borrarArray(ArrayList<Xogador> lista, String nombre){
        /*for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).getNome().equalsIgnoreCase(nombre)){
                lista.remove(i);
            }
        }*/
        
        //é mellor usar o iterator
        int atopar = 0;
        Iterator it = lista.iterator();
        Xogador xo;
        while(it.hasNext()){
            xo = (Xogador) it.next();
            if(xo.getNome().equalsIgnoreCase(nombre)){
                it.remove();
                atopar =+1;
            }
        }
        if(atopar == 0){
            JOptionPane.showMessageDialog(null, "Jugador no encontrado");
        }
        else if(atopar == 1){
            JOptionPane.showMessageDialog(null, "Jugador borrado");
        }
        else{
            JOptionPane.showMessageDialog(null, "Jugadores borrados");
        }
    }
    
    public void borrarArray2(ArrayList<Xogador> lista){
        int num = buscarElemento(lista, PedirDatos.getInt("Teclee o dorsal a buscar"));
        
        if(num == 1){
            Iterator it = lista.iterator();
            Xogador xo;
            String nombre = PedirDatos.getString("Teclee o nombre do xogador a borrar");
            
            while(it.hasNext()){
                xo = (Xogador) it.next();
                if(xo.getNome().equalsIgnoreCase(nombre)){
                    it.remove();
                    
                }
            }
            
        }
       
    }
    
}
