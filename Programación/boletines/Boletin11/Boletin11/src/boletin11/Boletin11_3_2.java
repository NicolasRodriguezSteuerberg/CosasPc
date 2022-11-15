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
public class Boletin11_3_2 {
    public float valor(){
        float valor=Float.parseFloat(JOptionPane.showInputDialog("Teclee valor positivo"));
        return valor;
    }
    public void calcArea(){
        float b, h;
        do{
            JOptionPane.showMessageDialog(null, "A continuación teclee a base");
            b=valor();
        }
        while(b<=0);
        do{
            JOptionPane.showMessageDialog(null, "A continuación teclee a altura");
            h=valor();
        }
        while(h<=0);
        JOptionPane.showMessageDialog(null, "A area do rectángulo é "+((b*h)/2));
    }
}
