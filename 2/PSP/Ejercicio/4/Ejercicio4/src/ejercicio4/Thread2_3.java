/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author dam2
 */
public class Thread2_3 extends Thread{
    public void run(){
        int suma = 0;
        for (Integer i = 1; i <= 1000; i++) {
            if(i % 10 == 2 || i % 10 == 3){
                suma += i;
            }
        }
        System.out.println(suma);
    }
}
