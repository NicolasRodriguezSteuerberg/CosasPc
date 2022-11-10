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
public class Boletin11_4 {
    public void calcAreaRec(){
        float num=Float.parseFloat(JOptionPane.showInputDialog("Teclee un numero"));
        do{
            for(int i=0;i<11;i++){
            float numC=num*i;
            System.out.println(num+" x "+i+" = "+numC);
            }
            num=Float.parseFloat(JOptionPane.showInputDialog("Teclee un numero"));
        }
        while(num!=0);
    }
}
