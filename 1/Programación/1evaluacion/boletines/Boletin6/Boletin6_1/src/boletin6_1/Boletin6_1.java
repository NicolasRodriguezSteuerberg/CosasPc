/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin6_1;

/**
 *
 * @author dam1
 */
public class Boletin6_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coche obxC=new Coche();
        
        obxC.acelerar(50);
        float va=obxC.getacelerar();
        
        
        obxC.frenar(40);
        float va2=obxC.getfrenar();
        
        System.out.println("A aceleración puso a velocidade en "+va);
        System.out.println("A frenada puso a velocidade en "+va2);
        
    }
    
}
