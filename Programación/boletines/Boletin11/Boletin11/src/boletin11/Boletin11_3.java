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
        do{
            b=Float.parseFloat(JOptionPane.showInputDialog("Teclee unha base positiva"));
        }
        while(b<=0);

        do{
            h=Float.parseFloat(JOptionPane.showInputDialog("Teclee unha altura positiva"));
        }
        while(h<=0);
        JOptionPane.showMessageDialog(null, "A area do rectangulo es "+(h*b));
    }
}
