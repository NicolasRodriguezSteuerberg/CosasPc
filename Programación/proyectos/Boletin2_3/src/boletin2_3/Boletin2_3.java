/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin2_3;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin2_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double euros, precioDolar,conversion; //declaracion variables
        Scanner obxScanner= new Scanner(System.in);//declaracion del objeto scanner
        System.out.println("Teclee os euros a cambiar");
        euros=obxScanner.nextDouble();//declaro euros a scanner
        System.out.println("teclee a tasa da conversion");
        precioDolar=obxScanner.nextDouble();
        conversion=euros*precioDolar;
        System.out.println("A conversión é de"+conversion+"$");
    }
    
}
