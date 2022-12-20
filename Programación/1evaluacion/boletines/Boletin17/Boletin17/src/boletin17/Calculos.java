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
    //decimalFormat (para poner solo 2 decimales)
    //atributo
    int nBolMax;
    
    public String Nombre(){
        String nome;
        nome = JOptionPane.showInputDialog("Teclee el nombre del alumno");
        return nome;
    }
    
    public float Notas(){
        float nota;

        nota = Float.parseFloat(JOptionPane.showInputDialog("Teclee a nota"));
        while (nota>10){
            JOptionPane.showMessageDialog(null, "La nota no puede ser mayor de 10");
            nota = Float.parseFloat(JOptionPane.showInputDialog("Teclee a nota")); 
        }
        return nota;
    }
    
    public float NBolMax(){
        nBolMax = Integer.parseInt(JOptionPane.showInputDialog("Teclee el número máximo de boletines que se pueden entregar"));
        return nBolMax;
    }
    
    public float NBolHechos(){
        float nBolH;
        nBolH = Float.parseFloat(JOptionPane.showInputDialog("Teclee el numero de boletines que ha entregado"));
        while (nBolH > nBolMax){
            JOptionPane.showMessageDialog(null, "Os boletines hechos no puede ser mayor a los boletines máximo "+ nBolMax);
            nBolH = Float.parseFloat(JOptionPane.showInputDialog("Teclee el numero de boletines que ha entregado"));
        }
        return nBolH;
        
    }
    
}
