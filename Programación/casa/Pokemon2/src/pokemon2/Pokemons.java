/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon2;

/**
 *
 * @author nicol
 */
public enum Pokemons {
    /*electricos
    * 0
    */
    PIKACHU("Pikachu",35,50,30,90, "electrico"),
    
    /*fuego
    *1
    */
    CHARMANDER("Charmander",43, 45, 20, 40, "fuego"),
    
    /*AGUA
    *2
    */
    SQUIRTLE("Squirtle",39, 56, 19, 35,"agua"),
    
    /*PLANTA
    *3
    */
    BULBASAUR("Bulbasaur",50, 30, 50, 30,"planta");
    
    
    private String nombre, tipo;
    private int vida, ofensiva, defensa, velocidad;
    
    private Pokemons(String nombre, int vida, int ofensiva, int defensa, int velocidad, String tipo){
        this.nombre = nombre;
        this.vida = vida;
        this.ofensiva = ofensiva;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
    }

    public void setVida(int vida) {
        this.vida = vida;
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
    
    
}
