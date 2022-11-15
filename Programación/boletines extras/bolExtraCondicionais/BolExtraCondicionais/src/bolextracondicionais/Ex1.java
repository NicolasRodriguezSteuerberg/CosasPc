/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolextracondicionais;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Ex1 {
    public void ex1(){
        int num;
        do{
            num=Integer.parseInt(JOptionPane.showInputDialog("Teclee un número comprendido entre el 0 y 99999"));
        }
        while (num<0 || num>=100000);
        
        if (num>0 && num<10){
            JOptionPane.showMessageDialog(null, num+" ten 1 cifra");
        }
        else if(num>=10 && num<100){
            JOptionPane.showMessageDialog(null, num+" ten 2 cifras");
        }
        else if (num>=100 && num<1000){
            JOptionPane.showMessageDialog(null, num+" ten 3 cifras");
        }
        else if (num>=1000 && num<10000){
            JOptionPane.showMessageDialog(null, num+" ten 4 cifras");
        }
        
        else if (num>=10000 && num<100000){
            JOptionPane.showMessageDialog(null, num+" ten 5 cifras");
        }
    }
}
