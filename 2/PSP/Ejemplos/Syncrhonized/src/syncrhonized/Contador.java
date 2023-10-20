/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syncrhonized;

/**
 *
 * @author dam2
 */
public class Contador {
    private static int cuenta = 0;

    public static void cuenta(String name) {
        cuenta++;
        System.out.println("Soy el " + name + " hilo y la cuenta está en: " + cuenta);
    }
    
    public int getCuenta(){
        return cuenta;
    }
}
