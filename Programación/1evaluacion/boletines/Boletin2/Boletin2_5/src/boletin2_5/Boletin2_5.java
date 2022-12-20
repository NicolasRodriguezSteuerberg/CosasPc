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
    public static final int CONV=1852;//declaramos a constante conversion, de millas a metros(Siempre encima de la clase)
    public static void main(String[] args) {
        // TODO code application logic here
        float millas, metros;
        Scanner obxScanner = new Scanner(System.in);
        System.out.println("Teclee os millas a convertir");
        millas=obxScanner.nextFloat();//leo/meto al objeto scanner
        metros=millas*CONV;
        System.out.println("A conversion é de "+metros+" metros");
        
        
    }
    
}
