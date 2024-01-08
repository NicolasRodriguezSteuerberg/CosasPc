/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyThread obx = new MyThread("1");
        MyThread obx2 = new MyThread("2");
        /*
        obx2.start();
        obx2.join();
        obx.start();
        */
        obx.setPriority(1);
        obx2.setPriority(10);
        obx2.start();
        obx.start();
        // Con las prioridades no siempre hace el orden que quiero :(
    }
    
}
