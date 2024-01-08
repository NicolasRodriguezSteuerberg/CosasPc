/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

/**
 *
 * @author dam2
 */
public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    
    public void run(){
        System.out.println("Hola, soy el hilo numero " + getName());
    }
}
