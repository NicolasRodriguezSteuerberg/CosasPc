/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraria;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Libro {
    private String titulo;
    private float prezo;
    
    //constructores
    public Libro (){}

    public Libro(String titulo, float prezo){
        this.titulo = titulo;
        this.prezo = prezo;
    }
    
    //metodos (set/get/toString)
    public void setPrezo(float prezo){
        this.prezo = prezo;
    }
    
    public float getPrezo(){
        return prezo;
    }

    @Override
    public String toString() {
        return "titulo=" + titulo + "\tprezo=" + prezo;
    }
    
    
}
