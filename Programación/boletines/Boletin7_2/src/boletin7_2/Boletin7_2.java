/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin7_2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin7_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner obxS=new Scanner(System.in);
        System.out.println("Teclee o primer número");
        float n1=obxS.nextFloat();
        System.out.println("Teclee o segundo número");
        float n2=obxS.nextFloat();
        if(n1>=n2){
            JOptionPane.showMessageDialog(null, "A resta é "+(n1-n2));
            
        }
        else{
            JOptionPane.showMessageDialog(null, "A suma é "+(n1+n2));
        }
    }
    
}
