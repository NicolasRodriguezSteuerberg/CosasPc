/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xenericos;

/**
 *
 * @author dam1
 */
public class Xenericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClaseXenerica <Xogador> obx = new ClaseXenerica();
        Xogador x = new Xogador("Manuel", 2);
        
        obx.setDato(x);
        System.out.println(obx.getDato());
    }
    
}
