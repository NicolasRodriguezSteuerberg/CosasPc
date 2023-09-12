/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author NSteuerberg
 */
public class Libro implements Comparable{
    private String titulo, autor, ISBN;
    private float prezo;
    private int unidades;
    
    public Libro(){}

    public Libro(String titulo, String autor, String ISBN, float prezo, int unidades) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.prezo = prezo;
        this.unidades = unidades;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public float getPrezo() {
        return prezo;
    }

    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return titulo + ", autor: " + autor + ", ISBN: " + ISBN + ", prezo: " + prezo + ", unidades: " + unidades;
    }
    
    public int compareTo(Object o){
        Libro lib = (Libro) o;
        if(this.titulo.compareToIgnoreCase(lib.titulo)>0){
            return 1;
        }
        else if(this.titulo.compareToIgnoreCase(lib.titulo)<0){
            return -1;
        }
        else {
            return 0;
        }
    }
}
