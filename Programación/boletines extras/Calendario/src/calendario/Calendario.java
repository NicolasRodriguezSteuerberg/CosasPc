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
        
        Calendario2 cumple = new Calendario2(29,10,2000);
        cumple.mostrar();
        Calendario2 cumple2 = new Calendario2(18,6,1965);
      
        cumple2.mostrar();
      
        
        Calendario2 fechaMal = new Calendario2(34,10,200);
        fechaMal.mostrar();
        
        
    }
    
}
