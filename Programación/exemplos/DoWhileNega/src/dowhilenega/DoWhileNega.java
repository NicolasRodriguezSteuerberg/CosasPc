/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dowhilenega;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class DoWhileNega {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float num;
        do{
            Scanner obx=new Scanner(System.in);
            System.out.println("Teclee un número");
            num=obx.nextFloat();
            JOptionPane.showMessageDialog(null, "O teu número é "+num);
        }
        while(num>0);
        JOptionPane.showMessageDialog(null, "O teu número é negativo");
    }
    
}
