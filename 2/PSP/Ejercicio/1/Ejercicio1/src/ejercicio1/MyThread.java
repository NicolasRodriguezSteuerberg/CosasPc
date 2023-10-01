/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author dam2
 */
public class MyThread extends Thread{
    
    public MyThread(String name){
        super(name);
    }
    
    public void run(){
        double numero;
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "Thread: " + (i+1));
            try{
                numero = Math.random()*(5000 - 100) + 100;
                Thread.sleep((long) numero);
                
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Error sleep " + getName());
            }
        }
    }
}
