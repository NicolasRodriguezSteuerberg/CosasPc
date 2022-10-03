/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolextra1_2;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class BolExtra1_2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        float f, a, b, c, x, y;
        Scanner oS=new Scanner(System.in);
        System.out.println("Na operacion Y=a*x²+b*x+c, ingrese a");
        a=oS.nextInt();
        System.out.println("Ingrese b");
        b=oS.nextInt();
        System.out.println("Ingrese c");
        c=oS.nextInt();
        System.out.println("Ingrese x");
        x=oS.nextInt();
        y=(float) (a*Math.pow(x, 2)+b*x+c);
        System.out.println("Y es igual a "+y);
                 
    }
    
}
