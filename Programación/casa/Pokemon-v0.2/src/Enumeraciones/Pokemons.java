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
    HELIOLISK("Heliolisk",62,109,94,109, 45,"electrico", "normal","" , "",5, 9),
    
    /*fuego
    *1
    */
    CHARMANDER("Charmander",78, 109, 85,100, 1,"fuego", "","agua" ,"",10, 14),
    
    /*AGUA
    *2
    */
    SQUIRTLE("Squirtle",79, 83, 105, 78,"agua", "planta", "electrico", 0, 4),
    
    /*PLANTA
    *3
    */
    BULBASAUR("Bulbasaur",80, 100, 100, 80,"planta", "fuego", "", 15, 19);
    
    
    private String nombre, tipo1, tipo2, debilidad1, debilidad2;
    private int vida, ofensiva, defensa, velocidad, nivel, minimo1, maximo1;    
    
    private Pokemons(String nombre, int vida, int ofensiva, int defensa, int velocidad, int nivel, String tipo1, String tipo2, String debilidad1, String debilidad2,int minimo1, int maximo1){
        this.nombre = nombre;
        this.vida = vida;
        this.ofensiva = ofensiva;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.debilidad1 = debilidad1;
        this.debilidad2 = debilidad2;
        this.nivel = nivel;
        this.minimo1 = minimo1;
        this.maximo1 = maximo1;
    }
    
    //setters, solo de las estadísticas que van a cambiar
    public void setOfensiva(int ofensiva) {
        this.ofensiva = ofensiva;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    
    //getters de todo
    public int getMinimo() {
        return minimo1;
    }
    
    public String getTipo(){
        return tipo1;
    }
    
    public int getMaximo() {
        return maximo1;
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
