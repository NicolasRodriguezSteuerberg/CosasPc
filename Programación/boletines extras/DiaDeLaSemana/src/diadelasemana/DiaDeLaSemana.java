/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package diadelasemana;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class DiaDeLaSemana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        numeroSemana obx = new numeroSemana();
        
        int num = Integer.parseInt(JOptionPane.showInputDialog("Teclee el número de la semana"));
        
        switch (num){
            case 1: obx.Lunes();
            break;
            
            case 2: obx.Martes();
            break;
            
            case 3: obx.Miercoles();
            break;
            
            case 4: obx.Jueves();
            break;
            
            case 5: obx.Viernes();
            break;
            
            case 6: obx.Lunes();
            break;
            
            case 7: obx.Domingo();
            break;
            
            default: obx.Default();
        }
                
    }
    
}
