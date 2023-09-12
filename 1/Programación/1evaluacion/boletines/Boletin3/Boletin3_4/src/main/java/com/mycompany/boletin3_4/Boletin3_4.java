/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.boletin3_4;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin3_4 {

    public static void main(String[] args) {
        int ctotal, c100, r100, c20, r20, c5, r5, c1;//cantidad total, cantidad de 100, cantidad de 20, de 5 y de 1, restos de las divisiones
        Scanner obxScanner=new Scanner (System.in);
        System.out.println("Teclee a túa cantidade a desglosar");
        ctotal=obxScanner.nextInt();
        c100=ctotal/100;
        r100=ctotal%100;
        c20=r100/20;
        r20=r100%20;
        c5=r20/5;
        r5=r20%5;
        c1=r5;
        System.out.println("Tu cantidad "+ctotal+
                " a desglosar é de \n"
                +c100+" billetes de 100"+"\n"
                +c20+" billetes de 20 \n"
                +c5+" billetes de 5 \n"
                +c1+" monedas de 1\n");
        
    }
}
