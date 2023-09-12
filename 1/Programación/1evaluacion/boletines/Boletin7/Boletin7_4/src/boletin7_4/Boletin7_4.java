/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin7_4;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin7_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nom1, nom2;
        float p1, p2, p;
        Scanner obx=new Scanner(System.in);
        System.out.println("Escriba o primeiro nome");
        nom1=obx.next();
        System.out.println("Escriba o primeiro peso");
        p1=obx.nextFloat();
        System.out.println("Escriba o segundo nome");
        nom2=obx.next();
        System.out.println("Escriba o segundo peso");
        p2=obx.nextFloat();
        
        if (p1>p2){
            System.out.println(nom1+" pesa máis que "+nom2);
            p=p1-p2;
        }
        else{
            System.out.println(nom2+" pesa máis que "+nom1);
            p=p2-p1;
        }
        System.out.println("A diferencia de peso é de "+p);
    }
    
}
