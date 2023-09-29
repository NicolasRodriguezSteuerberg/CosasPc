/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package texto_delimitado;

/**
 *
 * @author postgres
 */
public class Texto_Delimitado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3,4,5};
        
        String ruta1 = "/media/sf_Compartida/TextoDelimitado/texto1.txt";
        
        Metodos obx = new Metodos();
        obx.escritura(cod, desc, prezo, ruta1);
        obx.lectura(ruta1);
        
    }
    
}
