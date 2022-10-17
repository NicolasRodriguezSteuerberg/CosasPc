/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin6_2;

/**
 *
 * @author dam1
 */
public class Boletin6_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Satelite obxSat=new Satelite();
        obxSat.verPosicion();
        
        Satelite obxSat2=new Satelite(25.64, 137.66, 321421.565);
        obxSat2.verPosicion();
    }
    
}
