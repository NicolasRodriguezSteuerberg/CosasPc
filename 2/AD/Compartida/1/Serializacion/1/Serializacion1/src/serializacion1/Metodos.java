package serializacion1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
    
    public void escribir(String ruta, MClase objeto){
        ObjectOutputStream esc = null;
        try {
            esc = new ObjectOutputStream(new FileOutputStream(ruta));
            
            esc.writeObject(objeto);            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error esc1");
        } catch (IOException ex) {
            System.out.println("Error esc2");
        } finally{
            try {
                esc.close();
            } catch (IOException ex) {
                System.out.println("Error close");
            }
        }
    }
    
    public MClase leer(String ruta, MClase objeto){
        ObjectInputStream lec = null;
        
        try {
            lec = new ObjectInputStream(new FileInputStream(ruta));
            
            objeto = (MClase) lec.readObject();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error lec 1");
        } catch (IOException ex) {
            System.out.println("Error lec 2");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error read objeto");
        } finally{
            try {
                lec.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar lec");
            }
        }
        
        return objeto;
    }
    
}
