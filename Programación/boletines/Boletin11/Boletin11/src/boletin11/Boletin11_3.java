/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin11;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin11_3 {
    public void calcArea(){
        float b, h;
        b=Float.parseFloat(JOptionPane.showInputDialog("Teclee a base"));
        h=Float.parseFloat(JOptionPane.showInputDialog("Teclee a altura"));
        if (b<=0){
            do{
                JOptionPane.showMessageDialog(null, "A base ten que ser maior de 0");
                b=Float.parseFloat(JOptionPane.showInputDialog("Teclee a base"));
            }
            while(b<=0);
        }
        else{
            if(h<=0){
                do{
                JOptionPane.showMessageDialog(null, "A altura ten que ser maior de 0");
                h=Float.parseFloat(JOptionPane.showInputDialog("Teclee a altura"));
                }
                while(h<=0);
            }
        }
        JOptionPane.showMessageDialog(null, "A area do rectangulo es "+(h*b));
    }
}
