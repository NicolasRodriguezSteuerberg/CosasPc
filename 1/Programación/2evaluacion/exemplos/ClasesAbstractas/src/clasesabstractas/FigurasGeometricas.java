/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesabstractas;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public abstract class FigurasGeometricas {
    //atributos
    private float base;
    private float altura;
    
    //constructor

    public FigurasGeometricas(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }
    
    
    //métodos
    public abstract float calcularArea();
    
    public abstract float calcularPerimetro();
    
    //set-get
    public float getBase(){
        return base;
    }

    public float getAltura() {
        return altura;
    }
        
    
}
