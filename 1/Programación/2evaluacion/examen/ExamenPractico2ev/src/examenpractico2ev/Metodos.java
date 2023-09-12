package examenpractico2ev;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolas Rodriguez Steuerberg
 */
public class Metodos {
    
    ArrayList<Libro> auxiliar = new ArrayList();
    Scanner sc = null;
    
    
    public ArrayList<Libro> lerFicheiro(File ficheiro, String delimitador){
        try {
            sc = new Scanner(ficheiro);
            String []aux = new String[2];
            while(sc.hasNextLine()){
                aux=sc.nextLine().split("\\s*" + delimitador + "\\s*");
                auxiliar.add(new Libro(aux[0],Integer.parseInt(aux[1])));
            }
        } catch (IOException ex) {
            
        }
        finally{
            sc.close();
        }
        return auxiliar;
    }
    
    public void visualizarLibros(ArrayList<Libro> listaLibros){
        for (Libro elemento: listaLibros){
                System.out.println(elemento);
            }
    }
}
