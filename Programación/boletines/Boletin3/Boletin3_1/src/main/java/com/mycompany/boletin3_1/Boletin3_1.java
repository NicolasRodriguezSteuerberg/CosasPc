/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.boletin3_1;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin3_1 {

    public static void main(String[] args) {
       Scanner obxScanner=new Scanner(System.in);//instancia un obxecto de tipo scaner  
       double pt, pp, d;//pt=ptotal, pp=ppagado,d=descuento
       System.out.println("Introduzca o prezo total");
       pt=obxScanner.nextDouble();
       System.out.println("Introduzca o prezo pagado");
       pp=obxScanner.nextDouble();
       d=100-(pp/pt*100);
       System.out.println("O teu desconto foi de "+d+"%");
    }
}
