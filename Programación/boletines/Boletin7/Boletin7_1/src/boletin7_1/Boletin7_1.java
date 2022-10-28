/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin7_1;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin7_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String num=JOptionPane.showInputDialog("Teclee o número");
        float n=Float.parseFloat(num);
        if(n>=0){
            JOptionPane.showMessageDialog(null, "É positivo");
        }
                
        
    }
    
}
