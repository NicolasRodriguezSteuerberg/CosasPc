/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoadivinar;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class PedirDatos {
    public int numIntentos(){
        int intentos=Integer.parseInt(JOptionPane.showInputDialog("Escoge cuantos intentos para adivinar"));
        return intentos;
    }
    public int numEsc(){
        int num=Integer.parseInt(JOptionPane.showInputDialog("Teclee un número"));
        return num;
    }
    public void facil(){
        int numAdiv, numEsc, numInt, i;
        numAdiv=Integer.parseInt(JOptionPane.showInputDialog("Teclee o numero a adivinar"));
        numInt=numIntentos();
            
        for (i=0; i<numInt; i++){
            numEsc=numEsc();
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
    public void dificil(){
        int numAdiv, numEsc, numInt, i;
        numAdiv=(int) (Math.random()*50+1);  
        numInt=numIntentos();
        for (i=0; i<numInt; i++){
            numEsc=numEsc();
            
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
        }
            if (i==numInt){
                JOptionPane.showMessageDialog(null, "Perdiste, el número era "+numAdiv);
            
            }
    }
}
