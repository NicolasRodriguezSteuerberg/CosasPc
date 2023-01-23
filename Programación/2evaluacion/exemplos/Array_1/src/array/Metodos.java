package array;
import com.nicosteuerberg.datos.PedirDatos;
import java.util.Arrays;
import javax.swing.JOptionPane;
//para añadir nuestra libreria tenemos que tener el jar de la libreria-->clean and build
//para añadirla click derecho na libreria do proxecto-->add JAR-->buscas a libreria a añadir-->dist-->añadir jar

public class Metodos {
    
    /*public void crearArrayFloat(int numeroElemento, String nome){
        float [] nome = new float [];
    }*/
    
    static int tam = 0;
    
    public float[] crearArrayFloat(){
        tam = PedirDatos.getInt("Teclee o tamaño da array");
        float [] temperaturas = new float[tam];
        //cando tengamos 5 asteriscos significa que é un metodo/función que só estaba para ver si se producía ben,
        //ao terminar o programa tense que borrar todos os comentarios con 5 asteriscos
        //***** System.out.println("temperaturas.lenght);
        int i;
        for(i=0; i<temperaturas.length;i++){
            temperaturas [i] = PedirDatos.getFloat("Teclee a temperatura");
        }
        return temperaturas;
    }
    
    public void amosarArray(float [] temperaturas){ //en temperaturas le puedo llamar como quiera
        for (int i=0; i < tam ;i++){
            System.out.println("A " + (i+1) + "º temperatura é " + temperaturas[i]);
        }        
    }
    
    public void amosarPorPosicion(float [] temperaturas, int posicion){
        System.out.println("\nA " + posicion + "º temperatura é de = " + temperaturas[posicion-1]);
    }
    
    public void amosarArrayForEach(float [] temperaturas){
        for(Float elemento : temperaturas){
            System.out.println("****" + elemento);
        }
    }
    
    public void buscarArray(float[] temperaturas){
        int atopado = 0; //0 = no atopado
        int posicion = 0;
        float tempBuscar = PedirDatos.getFloat("Teclee a temperatura a buscar");
        for(int i=0; i < tam ; i++){
            if(tempBuscar==temperaturas[i]){
                atopado = 1;
                posicion = i+1;
            }
        }
        if(atopado == 1){
            JOptionPane.showMessageDialog(null, "Os " + tempBuscar + "ºC están na " + posicion + "º posicion");
        }else{
            JOptionPane.showMessageDialog(null, "Non se atopou esa temperatura");
        }
        
    }
    
    public void ordenarArray(float[] temperaturas){
        
        /*for(int i = 0; i < tam-1; i++){
            for(int j = i+1; j < tam; j++){
                if(temperaturas[i]>temperaturas[j]){
                    float aux = temperaturas[i];
                    temperaturas[i] = temperaturas[j];
                    temperaturas[j] = aux;
                }
            }
        }
        */
        System.out.println("temperaturas ordenadas\n");
        Arrays.sort(temperaturas);
        
    }
    
    public void borrarArray(float[] temperaturas){
        float elemBorrar = PedirDatos.getFloat("Tecle a temperatura a borrar");
        int atopado = 0;
        for (int i = 0; i < tam; i++){
            if(temperaturas[i] == elemBorrar){
                atopado = 1;
                for (int j = i; j < (temperaturas.length-1); j++){
                    temperaturas[j] = temperaturas[j+1];
                }
                tam--;
            }
        }
        
        if(atopado ==1){
            System.out.println("Temperatura borrada\n");
        }else{
            System.out.println("Temperatura no encontrada, por lo que no se pudo borrar\n");
        }
        
    }
    
    public void engadirArray (float []temperaturas){
        if(tam < temperaturas.length){
            temperaturas[tam] = PedirDatos.getFloat("Teclee a temperatura a engadir");
            tam++;
        }else{
            System.out.println("Non se pode engadir");
        }
    }
    
}


