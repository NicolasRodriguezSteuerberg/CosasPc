/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aleatoriedad;

/**
 *
 * @author postgres
 */
public class Aleatoriedad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        String path = "/media/sf_Compartida/Aleatorio/texto.txt";
        String[] codes = {"p1", "p2", "p3"};
        String[] descricion ={"parafusos", "cravos", "tachas"};
        int[] prices = {3,4,5};
        
        obx.escrituraLectura(codes, descricion, prices, path, 2);
    }
    
}
