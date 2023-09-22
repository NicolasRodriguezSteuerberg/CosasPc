/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primitivewrite;

/**
 *
 * @author postgres
 */
public class PrimitiveWriteChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obxM = new Metodos();
        String ruta = "/media/sf_Compartida/PrimitiveWriteUTF/texto3.txt";
        obxM.escribir(ruta);
        System.out.println("");
        obxM.leer(ruta);
    }
    
}
