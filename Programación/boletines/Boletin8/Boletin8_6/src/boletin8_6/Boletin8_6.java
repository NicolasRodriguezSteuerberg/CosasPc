/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin8_6;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin8_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nom;
        float vent;
        Clase obx=new Clase();
        Scanner obxS=new Scanner(System.in);
        System.out.println("Teclee o nombre do artigo");
        nom=obxS.next();
        System.out.println("Teclee o número de ventas");
        vent=obxS.nextFloat();
        obx.ventas(nom, vent);
    }
    
}
