/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin5;

/**
 *
 * @author dam1
 */
public class Boletin5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //apartado a y b
        Consumo obxCons1=new Consumo();
        obxCons1.setLitros(50f);
        obxCons1.setpGas(1.57f);
        
        //otros apartados
        Consumo obxCons2=new Consumo(200f, 12f, 60f, 1.57f);
        float l=obxCons2.getLitros();
        float km=obxCons2.getKm();
        float consumoMedio = obxCons2.consumoMedio(km,l);
        System.out.println("O consumo medio é de "+consumoMedio);
        
        obxCons2.setLitros(23f);
        float vMed=obxCons2.getvMed();
        System.out.println("A velocidade nedia é de "+ vMed);
    }
    
}
