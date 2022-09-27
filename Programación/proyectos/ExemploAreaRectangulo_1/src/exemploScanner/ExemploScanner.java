/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemploScanner;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class ExemploScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // proxecto que calcula o area dun rectangulo de base = 2 = b e altura = 5 = h
        float base, altura; //son variables locais, base=b, altura=h
        Scanner obxScanner = new Scanner (System.in);//instanciamos un obxecto de tipo scanner, con new
        System.out.println("Teclea a base");
        base=obxScanner.nextFloat();
        System.out.println("Teclea a altura");
        altura=obxScanner.nextFloat();
        float area =base*altura;
        System.out.println("o area é "+area);
                
    }
    
}
