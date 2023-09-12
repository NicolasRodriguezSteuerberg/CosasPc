/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegoadivinar;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class JuegoAdivinar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdivinarMulti obx2=new AdivinarMulti();
        AdivinarSolo obxS=new AdivinarSolo();
        int sOd=Integer.parseInt(JOptionPane.showInputDialog("Escoge cuantos a jugar 1 o 2"));
        
        switch(sOd){
            case 1:
                obxS.dificultad();
                break;
            case 2:
                obx2.dificultad();
                break;
        }
    }
    
}
