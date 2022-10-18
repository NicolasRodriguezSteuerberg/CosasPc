/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin6_3;

/**
 *
 * @author dam1
 */
public class Boletin6_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo obxC=new Circulo();
        obxC.calcularArea();
        obxC.calcularLonxitude();
        obxC.verResultado();       
        
        Circulo obxC2=new Circulo(2.0);
        obxC2.setradio(2.0);
        obxC2.calcularArea();
        obxC2.calcularLonxitude();
        obxC2.verResultado();
        
        
        
        
    }
    
}
