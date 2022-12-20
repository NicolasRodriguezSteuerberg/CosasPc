/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nicolasrodriguez;

/**
 *
 * @author NicolasRodriguez
 */
public class Pelicula {
    
    //declaración de atributos
    private String titulo;
    private float prezo;
    
    
    //constructor por defecto y parametrizado
    public Pelicula(){}
    
    public void Pelicula(String titulo, float prezo){
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
        return "titulo=" + titulo + "\t" + " prezo=" + prezo;
    }
    
    
}
