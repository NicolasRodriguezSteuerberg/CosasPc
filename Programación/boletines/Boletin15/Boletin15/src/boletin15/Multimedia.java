/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin15;

/**
 *
 * @author nicol
 */
public class Multimedia {
    private String titulo;
    private String autor;
    private  String formato;
    private String duracion;
    
    public Multimedia(){};
    
    public Multimedia(String tit, String aut, String form, String dur){
    titulo = tit;
    autor = aut;
    formato = form;
    duracion = dur;
    }
    
    //Setters y Getters
    
    public void setTitulo(String tit){
    titulo=tit;
    }
    public void setAutor(String aut){
    autor=aut;
    }
    public void setFormato(String form){
    formato=form;
    }
    public void setDuracion(String dur){
    duracion=dur;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getFormato(){
        return formato;
    }
    public String getDuracion(){
        return duracion;
    }

    @Override
    public String toString() {
        return "titulo: " + titulo + ", autor: " + autor + ", formato: " + formato + ", duracion: " + duracion;
    }
    
    
}
