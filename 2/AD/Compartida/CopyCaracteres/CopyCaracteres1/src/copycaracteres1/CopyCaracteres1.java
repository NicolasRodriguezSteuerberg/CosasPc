/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package copycaracteres1;

/**
 *
 * @author postgres
 */
public class CopyCaracteres1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        String ruta1 = "/media/sf_Compartida/CopyCaracteres/texto1.txt";
        String ruta2 = "/media/sf_Compartida/CopyCaracteres/texto2.txt";
        obx.leerEscribir(ruta1, ruta2);
    }
    
}
