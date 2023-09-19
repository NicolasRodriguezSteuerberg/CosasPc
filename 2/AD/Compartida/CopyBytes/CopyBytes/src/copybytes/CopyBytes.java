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
        /*
        byte bytes[];
        bytes = obx.lerFichero(JOptionPane.showInputDialog("Teclee a dirección do ficheiro"));
        //obx.escribirFicheiro(JOptionPane.showInputDialog("Teclee a direccion do ficheiro a crear/pegar"), bytes);
        obx.escribirFicheiroSenSobreescribir(JOptionPane.showInputDialog("Teclee a direccion do ficheiro a crear/pegar"), bytes);
        */
        
        
        obx.leerEscribir(JOptionPane.showInputDialog("Teclee a dirección do ficheiro que queres copiar"), JOptionPane.showInputDialog("Teclee a direccion do ficheiro a crear/pegar"), Boolean.parseBoolean(JOptionPane.showInputDialog("Si quieres sobreescribir ponga true\nSi no quieres sobreescribir ponga false")));
        
    }
    
}
