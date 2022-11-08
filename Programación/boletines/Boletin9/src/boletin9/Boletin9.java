/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin9;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner reposta=new Scanner(System.in);
    System.out.println ( "introduce un número " );
    int numero= reposta.nextInt();
    System . out . println ( "o numero = " + numero ) ;
        while(numero<10){
            System.out.println ( "introduce un número " );
            numero= reposta.nextInt();
            System . out . println ( "o numero = " + numero ) ;
        }
    }
    
}
