/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin15;

/**
 *
 * @author nicol
 */
public class Boletin15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pelicula obx1= new Pelicula("Pinocho","Disney","DVD","2h","Muñeco","niña");
        System.out.println(obx1.toString());
        
        Disco obx2= new Disco("Welcome to the Black Parade","MCR","CD","1h15m","Rock");
        System.out.println(obx2.toString());
        
    }
    
}
