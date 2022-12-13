/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin17;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Calculos {
    //atributo
    public void Notas(){
        float nota;
        nota = Float.parseFloat(JOptionPane.showInputDialog("Teclee a nota"));
    }
    
    public void NBolMax(){
        float nBolMax;
        nBolMax = Float.parseFloat(JOptionPane.showInputDialog("Teclee el número máximo de boletines que se pueden entregar"));
    }
    
    public void NBolHechos(){
        float nBolH;
        nBolH = Float.parseFloat(JOptionPane.showInputDialog("Teclee el numero de boletines que ha entregado"));
        
    }
    
}
