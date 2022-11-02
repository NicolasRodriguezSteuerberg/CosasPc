/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.boletin8_7;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Boletin8_7 {

    public static void main(String[] args) {
        int opcion=Integer.parseInt(JOptionPane.showInputDialog("Teclee a súa opción"));
        Clase obx=new Clase();
        obx.calcSup(opcion);
    }
}
