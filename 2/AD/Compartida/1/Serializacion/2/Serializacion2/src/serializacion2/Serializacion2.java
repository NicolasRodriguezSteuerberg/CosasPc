/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializacion2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author postgres
 */
public class Serializacion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        String ruta = "/media/sf_Compartida/Serializacion/2/texto.txt";
        
        String[] cod = {"p1","p2","p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};
        
        Product []obxP = new Product[cod.length];//+ 1];
        
        for (int i = 0; i < obxP.length; i++) {
            obxP[i] = new Product(cod[i],desc[i],prezo[i]);
        }
        
        Metodos obxM = new Metodos();
        
        obxM.write(ruta, obxP);
        
        
        obxM.read(ruta);
        
    }
    
}
