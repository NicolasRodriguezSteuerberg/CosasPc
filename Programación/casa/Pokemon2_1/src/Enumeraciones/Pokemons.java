/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enumeraciones;

/**
 *
 * @author nicol
 */
public enum Pokemons {
    /*electricos
    * 0
    */
    HELIOLISK("Heliolisk",62,109,94,109, "electrico", "" , "",5, 9),
    
    /*fuego
    *1
    */
    CHARMANDER("Charmander",78, 109, 85,100, "fuego", "agua" ,"",10, 14),
    
    /*AGUA
    *2
    */
    SQUIRTLE("Squirtle",79, 83, 105, 78,"agua", "planta", "electrico", 0, 4),
    
    /*PLANTA
    *3
    */
    BULBASAUR("Bulbasaur",80, 100, 100, 80,"planta", "fuego", "", 15, 19);
    
    
    private String nombre, tipo, debilidad1, debilidad2;
    private int vida, ofensiva, defensa, velocidad, minimo, maximo;    
    
    private Pokemons(String nombre, int vida, int ofensiva, int defensa, int velocidad, String tipo, String debilidad1, String debilidad2,int minimo, int maximo){
        this.nombre = nombre;
        this.vida = vida;
        this.ofensiva = ofensiva;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
        this.debilidad1 = debilidad1;
        this.debilidad2 = debilidad2;
        this.minimo = minimo;
        this.maximo = maximo;
    }
    
    public String getNome(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setOfensiva(int ofensiva) {
        this.ofensiva = ofensiva;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
    
    

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMinimo() {
        return minimo;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public int getMaximo() {
        return maximo;
    }
       
    public int getVida() {
        return vida;
    }

    public int getOfensiva() {
        return ofensiva;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    public String getDebilidad1(){
        return debilidad1;
    }
    
    public String getDebilidad2(){
        return debilidad2;
    }
}
