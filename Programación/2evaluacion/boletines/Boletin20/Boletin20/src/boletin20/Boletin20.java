/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin20;

/**
 *
 * @author dam1
 */
public class Boletin20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tigre obxT = new Tigre();
        obxT.camiñar();obxT.nadar();
        
        Gato obxG = new Gato();
        obxG.camiñar();obxG.nadar();
        
        Avestruz obxA = new Avestruz();
        obxA.camiñar();
        
        Papagaio obxP = new Papagaio();
        obxP.camiñar();obxP.voar();
    }
    
}
