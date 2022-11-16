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
public class AdivinarSolo {
    public void adivinarNumero(){
        int numAdiv, numEsc, numInt, i;
        numAdiv=(int) (Math.random()*50+1);  
        PedirDatos obx=new PedirDatos();
        numInt=obx.numIntentos();
        
        for (i=0; i<numInt; i++){
            numEsc=obx.numEsc();
            
            if (numAdiv+5>=numEsc && numAdiv+1<=numEsc || numAdiv-5<=numEsc && numAdiv-1>=numEsc){
                JOptionPane.showMessageDialog(null, "Estas moi preto");
            }
            
            else if(numAdiv-5>numEsc && numAdiv-10<numEsc ||numAdiv+5<numEsc && numAdiv+10>numEsc){
                JOptionPane.showMessageDialog(null, "Estas preto");
            }
            
            else if(numAdiv-10>=numEsc && numAdiv-20<=numEsc ||numAdiv+10<=numEsc && numAdiv+20>=numEsc){
                JOptionPane.showMessageDialog(null, "Estas lonxe");
            }
            
            else if (numAdiv+20<numEsc || numAdiv-20>numEsc){
                JOptionPane.showMessageDialog(null, "Estas moi lonxe");
            }
            
            else if (numAdiv==numEsc){
                JOptionPane.showMessageDialog(null, "Adivinaste el número era "+numAdiv);
                break;
            }
            JOptionPane.showMessageDialog(null, "Te quedan "+(numInt-(i+1))+" intentos");
        }
            if (i==numInt){
                JOptionPane.showMessageDialog(null, "Perdiste, el número era "+numAdiv);
            
            }
    }
}
