/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin14;


/**
 *
 * @author dam1
 */
public class Boletin14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ordenador obx = new Ordenador(21.2f, "corsair", 2, 1020.3f);
        System.out.println(obx.toString());
        System.out.println(obx.getPrecio());
        System.out.println(obx.getTeclado().getMarca());
        System.out.println(obx.getCpu().getVelocidade()+"\n\n");
   
        
        
        Ordenador obx1 = new Ordenador(24.0f, "logitech",3 ,1001.2f);
        System.out.println(obx1.toString());
    }
    
}
