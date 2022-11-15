/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin12;

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
}
