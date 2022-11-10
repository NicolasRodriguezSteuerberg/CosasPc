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
public class Boletin11_1 {
    public void contN(){
        int c0=0, cPos=0, cNeg=0;
        for (int i=0; i<10; i++){
            float num=Float.parseFloat(JOptionPane.showInputDialog("Teclee un número"));
            if (num>0){
                cPos=cPos+1;
            }
            else if(num<0){
                cNeg=cNeg+1;
            }
            else{
                c0=c0+1;
            }
        }
        System.out.println("Hai "+cPos+" numeros positivos\n"
                + "Hai "+c0+" numeros que son 0\n"
                        + "Hai "+cNeg+" numeros negativos");
    }
    
}
