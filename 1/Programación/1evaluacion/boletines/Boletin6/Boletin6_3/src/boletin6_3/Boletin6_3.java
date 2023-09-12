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
        obxC.setradio(15);
            double area=obxC.calcularArea();
            double lonx=obxC.calcularLonxitude();
      
        System.out.println("A área é "+area+"\n"
                + "A lonxitude é "+lonx);
        
        Circulo obxC2=new Circulo(2.0);
            
            double area2=obxC2.calcularArea();
            double lonx2=obxC2.calcularLonxitude();

        System.out.println("A área é "+area2+"\n"
                + "A lonxitude é "+lonx2);
        
        
        
        
    }
    
}
