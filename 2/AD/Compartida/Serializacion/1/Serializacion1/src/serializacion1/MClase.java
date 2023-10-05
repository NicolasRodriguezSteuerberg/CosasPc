/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializacion1;

import java.io.Serializable;

/**
 *
 * @author postgres
 */
public class MClase implements Serializable{
    String nombre;
    //int numero1;
    double numero2;
    transient int numero1;

    public MClase(String nombre, int numero1, double numero2) {
        this.nombre = nombre;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    
    public MClase(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    @Override
    public String toString() {
        return "Objeto:\n\tNombre = " + nombre + ", numero1 = " + numero1 + ", numero2 = " + numero2;
    }
    
    
    
}
