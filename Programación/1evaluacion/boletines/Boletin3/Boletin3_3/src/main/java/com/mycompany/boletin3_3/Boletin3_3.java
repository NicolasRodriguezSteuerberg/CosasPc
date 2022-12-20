/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.boletin3_3;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin3_3 {

    public static void main(String[] args) {
        int b100, b20, b5, m1, ctotal;//billetes de 100, billetes de 20, billetes de 5, monedas de 1, cantidad total
        Scanner obxScanner=new Scanner(System.in);
        System.out.println("Teclee a cantidade de billetes de 100");
        b100=obxScanner.nextInt();
        System.out.println("Teclee a cantidade de billetes de 20");
        b20=obxScanner.nextInt();
        System.out.println("Teclee a cantidade de billetes de 5");
        b5=obxScanner.nextInt();
        System.out.println("Teclee a cantidade de monedas de 1");
        m1=obxScanner.nextInt();
        ctotal=b100*100+b20*20+b5*5+m1;
        System.out.println("A cantidade total de diñeiro que tes é de "+ctotal+" de euros");
    }
}
