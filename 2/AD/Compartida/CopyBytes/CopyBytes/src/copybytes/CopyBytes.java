package copybytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author postgres
 */
public class CopyBytes {

    
    public static void main(String[] args) {
        Metodos obx = new Metodos();
        byte bytes[];
        bytes = obx.lerFichero(JOptionPane.showInputDialog("Teclee a dirección do ficheiro"));
        //obx.escribirFicheiro(JOptionPane.showInputDialog("Teclee a direccion do ficheiro a crear/pegar"), bytes);
        obx.escribirFicheiroSenSobreescribir(JOptionPane.showInputDialog("Teclee a direccion do ficheiro a crear/pegar"), bytes);
        
        /*
        try {
            FileInputStream lectura = new FileInputStream(JOptionPane.showInputDialog("Teclee la ruta a copiar"));
            
            //FileOutputStream escritura = new FileOutputStream(JOptionPane.showInputDialog("Teclee la ruta a pegar"));
            FileOutputStream escritura = new FileOutputStream(JOptionPane.showInputDialog("Teclee la ruta a pegar"), true);
            
            int bytes2;
            
            while((bytes2 = lectura.read()) != -1){
                escritura.write(bytes2);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopyBytes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopyBytes.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
    }
    
}
