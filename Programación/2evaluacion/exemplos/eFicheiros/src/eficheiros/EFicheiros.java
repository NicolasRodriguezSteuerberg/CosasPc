/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eficheiros;

import java.io.File;
import lectura.LerFicheiros;

/**
 *
 * @author dam1
 */
public class EFicheiros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        File f = new File("ficheroNumeros.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerPalabras(f,",");
        //obx.lerLiñas(f);
        
        //ArrayList
        File n = new File("numeros2.txt");
        LerFicheiros obx = new LerFicheiros();
        obx.lerNumero(n);
        
        
        //arrayList teniendo fichero con comas
        File n = new File("numeros3.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerNumeroDelimitadores(n);
        */
        /*
        File al = new File("alumnos.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerObxecto(al);
*/
        File n = new File("/home/dam1/Documentos/ficherosProg/probaNumeros.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerPalabras(n, " ");
    }
    
}
