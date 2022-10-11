/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin4;

/**
 *
 * @author dam1
 */
public class Boletin4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro obxL = new Libro("El Quijote", "Miguel de Cervantes", 1605, (short)100);
        String tit=obxL.getTit();
        String aut=obxL.getAut();
        int an=obxL.getAn();
        short numP=obxL.getNumP();
        obxL.amosar(tit, aut, an, numP);
        
    }
    
}
