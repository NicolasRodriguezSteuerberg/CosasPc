package copycaracteres1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
    public void leerEscribir(String pathLectura, String pathEscritura){
        FileWriter esc = null;
        FileReader lec = null;
        try{
            lec = new FileReader(pathLectura);
            esc = new FileWriter(pathEscritura);
            int i;
            while((i = lec.read())>-1){
                esc.write(i);
            }
            System.out.println("Escritura terminada");
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        } catch (IOException ex) {
            System.out.println("Error");
        }finally{
            try {
                esc.close();
                lec.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar");
            }
            
        }
    }
}
