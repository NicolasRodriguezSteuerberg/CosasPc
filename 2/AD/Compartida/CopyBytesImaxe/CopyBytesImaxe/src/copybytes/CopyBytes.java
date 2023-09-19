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
        
        //obx.leerEscribir(JOptionPane.showInputDialog("Teclee a dirección do ficheiro que queres copiar"), JOptionPane.showInputDialog("Teclee a direccion do ficheiro a crear/pegar"), Boolean.parseBoolean(JOptionPane.showInputDialog("Si quieres sobreescribir ponga true\nSi no quieres sobreescribir ponga false")));
        // a) Pesa lo mismo
        // b) no se añade otra foto pero pesa el doble
        obx.leerEscribirBuffer(JOptionPane.showInputDialog("Teclee a dirección do ficheiro que queres copiar"), JOptionPane.showInputDialog("Teclee a direccion do ficheiro a crear/pegar"), Boolean.parseBoolean(JOptionPane.showInputDialog("Si quieres sobreescribir ponga true\nSi no quieres sobreescribir ponga false")));
        
        // c) Si, es mucho más rápido
    }
    
}
