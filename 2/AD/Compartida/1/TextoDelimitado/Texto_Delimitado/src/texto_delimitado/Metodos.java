package texto_delimitado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
    public void escritura(String[] cod, String[] desc, int[] prezo, String ruta){
        PrintWriter esc = null;
        try {
            esc = new PrintWriter(new BufferedWriter(new FileWriter(ruta)));
            for (int i = 0; i < cod.length; i++) {
                esc.println(cod[i] + "\t" + desc[i] + "\t" + prezo[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error escritura");
        } catch (IOException ex) {
            System.out.println("Error escritura");
        } finally{
            esc.close();
        }
    }
    
    public void lectura(String ruta){
        BufferedReader lec = null;
        
        try {
            lec = new BufferedReader(new FileReader(ruta));
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            nf.setCurrency(Currency.getInstance(Locale.ITALY));
            String lectura = null;
            while((lectura=lec.readLine())!= null){
              String  lecturas[]=lectura.split("\t");
                System.out.println("Codigo: " + lecturas[0]);
                System.out.println("Descricion: " + lecturas[1]);
                System.out.println("Prezo: " + nf.format(Integer.parseInt(lecturas[2])) + "\n");
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error lectura");
        } catch (IOException ex) {
            System.out.println("Error lectura");
        }finally{
            try {
                lec.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar esc");
            }
        }
        
    }
}
