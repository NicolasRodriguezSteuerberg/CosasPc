/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin7_3;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin7_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String n=JOptionPane.showInputDialog("teclee o numero");
        float numero=Float.parseFloat(n);
        if(numero>1){
            JOptionPane.showMessageDialog(null, "O teu número é positivo");
        }
        else if(numero<0){
            JOptionPane.showMessageDialog(null, "O teu número é negativo");
        }
        else{
            JOptionPane.showMessageDialog(null, "O teu número é 0");
        }
        
    }
    
}
