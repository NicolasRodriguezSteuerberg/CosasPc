/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenpractico2ev;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author dam1
 */
public class ExamenPractico2ev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obxM = new Metodos();
        File ficheiro = new File("libros.txt");
        ArrayList<Libro> listaLibros = new ArrayList();
        
        listaLibros = obxM.lerFicheiro(ficheiro, ",");
        obxM.visualizarLibros(listaLibros);
    }
    
}
