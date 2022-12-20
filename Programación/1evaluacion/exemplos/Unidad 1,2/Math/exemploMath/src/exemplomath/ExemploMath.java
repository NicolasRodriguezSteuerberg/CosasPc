/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplomath;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class ExemploMath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //programa que calcula a lonxitude e o área dunha circunferencia
        
        Scanner obxScanner = new Scanner(System.in);
        System.out.println("Introduzca o radio da circunferencia");
        float radio=obxScanner.nextFloat();
        double lonx = 2*radio*Math.PI;
        /*tomamos a lonxitude como float
        float lon=(float) (2*Math.PI*radio);*/
        double area = Math.PI*Math.pow(radio, 2);
        System.out.println("A lonxitude é "+lonx +"\nA area é "+area);
        
        //programa que calcula a lonxitude e o área dunha circunferencia
        /*double area, lonx, radio; //definimos las variables
        Scanner obxScanner = new Scanner(System.in);
        System.out.println("Introduzca o radio da circunferencia");
        radio=obxScanner.nextDouble();
        lonx = 2*radio*Math.PI;
        area = Math.PI*Math.pow(radio, 2);
        System.out.println("A lonxitude é "+lonx +"\nA area é "+area);*/
        
    }
    
}
