/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " Thread: " + i);
            try{
                numero = Math.random()*(1500 - 100) + 100;
                Thread.sleep((long) numero);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Error sleep " + getName());
            }
        }
        
    }
    
}
