package lectura;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author NSteuerberg
 */
public class LerFicheiros {
    Scanner sc;
    
    //1º xeito de leelos
    public void lerPalabras(File ficheiro){
        try {
            sc = new Scanner(ficheiro);
            while(sc.hasNext()){
                String dato = sc.nextLine();
                System.out.println(dato);
            }
        }catch (FileNotFoundException ex) {
            System.out.println("erro 1 " + ex.getMessage());
        }
        finally{
            sc.close();
        }
    }
    
    
    //2º xeito
    
    //3º xeito
}
