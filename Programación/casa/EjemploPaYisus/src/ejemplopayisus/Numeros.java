/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplopayisus;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Numeros {
    public void adivinarNumero(){
        int sOd,numAdiv, numEsc = 0, numInt, i;
        sOd=Integer.parseInt(JOptionPane.showInputDialog("Escoge cuantos a jugar 1 o 2"));
        if (sOd==1){
            numInt=Integer.parseInt(JOptionPane.showInputDialog("Escoge cuantos intentos para adivinar"));
            numAdiv=(int) (Math.random()*25+1);
            for (i=0; i<numInt; i++){
                numEsc=Integer.parseInt(JOptionPane.showInputDialog("Teclee un número"));
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
}
