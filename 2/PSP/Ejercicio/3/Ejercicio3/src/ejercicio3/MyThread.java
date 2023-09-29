/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2
 */
public class MyThread extends Thread{
    
    int contador;
    
    public MyThread(String name, int contador){
        super(name);
        this.contador = contador;
    }
    
    public void run(){
        System.out.println("Soy el hilo: " + getName());
        if(contador==Integer.parseInt(getName())){
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep((long)(Math.random() * (600 - 100) +100));
                    System.out.println("Thread " + getName() + ": " + i);
                } catch (InterruptedException ex) {
                    System.out.println("Error sleep");
                }
            }
            System.out.println("Terminó el hilo: " + getName());
            
        }else{
            String nombre = String.valueOf(Integer.parseInt(getName())+1);
            MyThread obx = new MyThread(nombre, contador);
            obx.start();
            
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep((long)(Math.random() * (600 - 100) +100));
                    System.out.println("Thread " + getName() + ": " + i);
                } catch (InterruptedException ex) {
                    System.out.println("Error sleep");
                }
            }
            try {
                obx.join();
                System.out.println("Terminó el hilo: " + getName());
            } catch (InterruptedException ex) {
                System.out.println("Error join");
            }
        }
    }
}
