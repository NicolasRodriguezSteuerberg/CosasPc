/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calendario;

/**
 *
 * @author marcosfa
 */
public class Calendario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Calendario2 obx1 = new Calendario2(31,10,2000);
        obx1.mostrar();
        
        Calendario2 fechaCorregida = new Calendario2 (32, 13, 2013);
        fechaCorregida.mostrar();
        
        Calendario2 fechaMal = new Calendario2 (-1, 13, 1903);
        fechaMal.mostrar();
        
    }
    
}
