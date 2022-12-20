/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplobucles;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class BucleWhile {
    public void verNumero(){
        int num;
        num=Integer.parseInt(JOptionPane.showInputDialog("teclee número positivo"));
        while(num>=0){
            
           num=Integer.parseInt(JOptionPane.showInputDialog("teclee número positivo"));

        }
        System.out.println("saímos do bucle");
    }
    
}
