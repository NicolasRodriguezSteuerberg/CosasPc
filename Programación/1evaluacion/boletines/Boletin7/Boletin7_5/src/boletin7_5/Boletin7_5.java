/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin7_5;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin7_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String n1, n2, n3;
        float num1, num2, num3;
        n1=JOptionPane.showInputDialog("Teclee o primer número");
        n2=JOptionPane.showInputDialog("Teclee o segundo número");
        n3=JOptionPane.showInputDialog("Teclee o terceiro número");
        num1=Float.parseFloat(n1);
        num2=Float.parseFloat(n2);
        num3=Float.parseFloat(n3);
        if (num1>num2){
            if(num1>num3){
                    System.out.println("O primer número ("+num1+") é o máis alto");
                    }
            else{
                System.out.println("O terceiro número ("+num3+") é o máis alto");
            }
        }
        else if(num2>num3){
            System.out.println("O segundo número ("+num2+") é máis alto");
        }
        else{
            System.out.println("O terceiro número ("+num3+") é o  máis alto");
        }
                    
    }
}
