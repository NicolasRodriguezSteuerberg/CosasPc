/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin12;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Adivinar2 {
    
    public void adivinarNumero(){
        
        int numAdiv, numEsc, numInt, i;
        numAdiv=Integer.parseInt(JOptionPane.showInputDialog("Teclee o numero a adivinar"));
        PedirDatos obx=new PedirDatos();
        numInt=obx.numIntentos();
            
        for (i=0; i<numInt; i++){
            numEsc=obx.numEsc();
            if (numAdiv<numEsc){
                JOptionPane.showMessageDialog(null, "El numero es menor");
            }
            
            else if (numAdiv>numEsc){
                JOptionPane.showMessageDialog(null, "El numero es mayor");
            }
            else if(numAdiv==numEsc){
                JOptionPane.showMessageDialog(null, "Adivinaste el número era "+numAdiv);
                break;
            }
        }
        if (i==numInt){
            JOptionPane.showMessageDialog(null, "El número era "+numAdiv);
        }
    }
}

