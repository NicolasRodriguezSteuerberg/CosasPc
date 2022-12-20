/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nicolasrodriguez2;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Peliculas {
    private String titulo;
    private float prezo;
    
    public Peliculas (String titulo , float prezo){
        this.titulo = titulo;
        this.prezo = prezo;
    }
    
    public void setPrezo(float prezo){
        this.prezo = prezo;
    }
    public float getPrezo(){
        return prezo;
    }

    @Override
    public String toString() {
        return "Peliculas{" + "titulo=" + titulo + ", prezo=" + prezo + '}';
    }
    
    
}
