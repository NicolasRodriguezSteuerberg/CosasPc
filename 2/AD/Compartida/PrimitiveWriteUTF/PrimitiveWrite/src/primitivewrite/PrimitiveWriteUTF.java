/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primitivewrite;

import javax.swing.JOptionPane;

/**
 *
 * @author postgres
 */
public class PrimitiveWriteUTF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obxM = new Metodos();
        String ruta = "/media/sf_Compartida/PrimitiveWriteUTF/texto3.txt";
        obxM.escribir(ruta);
        obxM.leer(ruta);
    }
    
}
