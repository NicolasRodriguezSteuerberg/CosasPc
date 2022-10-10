/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin2_4;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin2_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a, b, suma, resta, multiplicacion,division;
        Scanner obxScanner = new Scanner(System.in);
        System.out.println("Teclee o 1º numero");
        a = obxScanner.nextInt();
        System.out.println("Teclee o 2º numero");
        b = obxScanner.nextInt();
        suma=(a)+(b);
        System.out.println("A suma dos números é "+suma);
        resta=(a)-(b);
        System.out.println("A resta dos números é "+resta);
        multiplicacion=(a)*(b);
        System.out.println("A multiplicacion dos números é "+multiplicacion);
        division=(a)/(b);
        System.out.println("A division dos números é "+division);
        //System.out.println("A suma é "+suma+"\n "resta é "+resta+"\n a multiplicación é "+multiplicacion+"\n a division é "+division);
    }
    
}
