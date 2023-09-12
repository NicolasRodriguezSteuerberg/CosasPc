/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.boletin8_7;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Clase {
    final static float PI=3.14f;
    public void calcSup(int opcion){      
        switch(opcion){
            case 1:
                float lado=Float.parseFloat(JOptionPane.showInputDialog("Teclee o lado")); 
                float sup=(float) Math.pow(lado, 2);
                JOptionPane.showMessageDialog(null, "A superficie do cadrado é "+sup);
                break;
            case 2:
                float b=Float.parseFloat(JOptionPane.showInputDialog("Teclee a base"));
                float h=Float.parseFloat(JOptionPane.showInputDialog("Teclee a altura"));
                float supT=b*h/2;
                JOptionPane.showMessageDialog(null, "A superficie do triangulo é "+supT);
                break;
            case 3:
                float r=Float.parseFloat(JOptionPane.showInputDialog("Teclee o radio")); 
                float supR=PI*(float)Math.pow(r, 2);
                JOptionPane.showMessageDialog(null, "A superficie do circulo é "+supR);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción incorrecta");
        }
    }
}
