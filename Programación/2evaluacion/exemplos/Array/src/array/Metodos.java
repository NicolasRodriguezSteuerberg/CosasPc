package array;
import com.nicosteuerberg.datos.PedirDatos;
//para añadir nuestra libreria tenemos que tener el jar de la libreria-->clean and build
//para añadirla click derecho na libreria do proxecto-->add JAR-->buscas a libreria a añadir-->dist-->añadir jar

public class Metodos {
    
    /*public void crearArrayFloat(int numeroElemento, String nome){
        float [] nome = new float [];
    }*/
    
    public float[] crearArrayFloat(){
        float [] temperaturas = new float[5];
        //cando tengamos 5 asteriscos significa que é un metodo/función que só estaba para ver si se producía ben,
        //ao terminar o programa tense que borrar todos os comentarios con 5 asteriscos
        //***** System.out.println("temperaturas.lenght);
        for(int i=0; i<temperaturas.length;i++){
            temperaturas [i] = PedirDatos.getFloat("Teclee a temperatura");
        }
        return temperaturas;
    }
    
    public void amosarArray(float [] temperaturas){ //en temperaturas le puedo llamar como quiera
        for (int i=0; i<temperaturas.length;i++){
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
}


