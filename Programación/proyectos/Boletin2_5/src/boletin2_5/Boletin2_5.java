/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin2_5;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin2_5 {

    /**
     * @param args the command line arguments
     */
    public static final int conv=1852;//conversion millas a metros
    public static void main(String[] args) {
        // TODO code application logic here
        int millas, metros;
        Scanner obxScanner = new Scanner(System.in);
        System.out.println("Teclee os millas a convertir");
        millas=obxScanner.nextInt();
        metros=millas*conv;
        System.out.println("A conversion é de "+metros+" metros");
        
        
    }
    
}
