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
    PIKACHU("Pikachu",35,50,30,90, "electrico", 6, 10),
    
    /*fuego
    *1
    */
    CHARMANDER("Charmander",43, 45, 20, 40, "fuego", 11, 15),
    
    /*AGUA
    *2
    */
    SQUIRTLE("Squirtle",39, 56, 19, 35,"agua", 0, 5),
    
    /*PLANTA
    *3
    */
    BULBASAUR("Bulbasaur",50, 30, 50, 30,"planta", 16, 20);
    
    
    private String nombre, tipo;
    private int vida, ofensiva, defensa, velocidad, minimo, maximo;
    
    private Pokemons(String nombre, int vida, int ofensiva, int defensa, int velocidad, String tipo, int minimo, int maximo){
        this.nombre = nombre;
        this.vida = vida;
        this.ofensiva = ofensiva;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
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
}
