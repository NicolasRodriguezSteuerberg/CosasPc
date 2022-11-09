/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplobucles;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Bucles {
    //escribe un programa que sume 5 numeros enteiros
    public static int pedirEnteiro(){

        int numero=Integer.parseInt(JOptionPane.showInputDialog("Teclee o teu número")) ;
        return numero;
    }
    
    public void mWhile(){
        int i=0;
        float suma=0;
        while(i<5){
            int num=pedirEnteiro();
            suma=suma+num;
            i++;
        }
        JOptionPane.showMessageDialog(null, "A tua suma é "+suma);
    }
    public void mDoWhile(){
        int i=0;
        float suma=0;
        do{
            int num=pedirEnteiro();
            suma=suma+num;
            i++;
        }
        while(i<5);
        JOptionPane.showMessageDialog(null, "A tua suma é "+suma);
    }
    public void mFor(){
        int suma=0;
        for(int i=0; i<5; i++){
            int num=pedirEnteiro();
            suma=suma+num;
        }
        JOptionPane.showMessageDialog(null, "A tua suma é "+suma);
    }
}
