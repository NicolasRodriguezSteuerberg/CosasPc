/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productstream;

import java.util.ArrayList;

/**
 *
 * @author postgres
 */
public class ProductStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ruta = "/media/sf_Compartida/ProductStream/productos.txt";
        
        //Creo los objetos de Product y los guardo en una arrayList
        ArrayList <Product> lista = new ArrayList();
        lista.add(new Product("cod1", "parafusos", 3.0));
        lista.add(new Product("cod2", "cravos", 4.0));
        lista.add(new Product("cod3", "tachas", 6.0));
        lista.add(new Product("cod4", "grapas", 2.0));
        
        //Llamo al metodo escritura y lectura
        Metodos obxM = new Metodos();
        obxM.escritura(ruta, lista);
        obxM.lectura(ruta);
    }
    
}
