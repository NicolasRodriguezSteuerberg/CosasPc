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
            float num=Float.parseFloat(JOptionPane.showInputDialog("Teclee o "+(i+1)+"º número"));
            if (num>0){
                cPos++;
            }
            else if(num<0){
                cNeg++;
            }
            else{
                c0++;
            }
        }
        System.out.println("Hai "+cPos+" numeros positivos\n"
                + "Hai "+c0+" numeros que son 0\n"
                        + "Hai "+cNeg+" numeros negativos");
    }
    
}
