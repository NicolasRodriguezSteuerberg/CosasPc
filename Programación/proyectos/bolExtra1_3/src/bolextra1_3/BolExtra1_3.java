/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolextra1_3;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class BolExtra1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       float a, b, c, x1, x2;
       Scanner oS=new Scanner(System.in);
       System.out.println("Ingrese a");
       a=oS.nextFloat();
       System.out.println("Ingrese b");
       b=oS.nextFloat();
       System.out.println("Ingrese c");
       c=oS.nextFloat();
       x1=(float) ((-b)+ Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
       x2=(float) ((-b)- Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
       
       
        System.out.println("1º resultado é "+x1+"\n"
                + "2º resultado é "+x2);
    }
    
}
