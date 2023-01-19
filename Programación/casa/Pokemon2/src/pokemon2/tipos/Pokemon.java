/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon2.tipos;
import javax.swing.JOptionPane;
import pokemon2.Ataque;
import pokemon2.Pokemons;
import pokemon2.Random;

/**
 *
 * @author nicol
 */
public class Pokemon {
    //atributos de los pokemons
    public String nombre, tipo;
    public int vida, ofensiva, defensa, velocidad, minimo, maximo,danio;

    
    
    //constructor
    public Pokemon() {

    }
   
    private Pokemons[] pokemons = new Pokemons[1];
    private Ataque[] ataques = new Ataque [4];
    

    //generar ataques aleatorios teniendo en cuenta el numero minimo de la enum ataques y el maximo, para que sean de su tipo
    public void generarAtaques(int minimo, int maximo){
        int i = 0;
        ataques[i] = Ataque.values()[Random.generarAleatorio(minimo, maximo)];
        for(i = 1; i < ataques.length; i++){
            for(int j = 0; j < i; j++){
                if (ataques[i] == ataques[j]){
                    i--;
                }
            }
        }
    }
    
    //elegir y guardar el pokemon y sus stats?
    public void generarPokemon(){
        
        pokemons[0] = Pokemons.BULBASAUR;
        nombre = pokemons[0].getNome();
        vida = pokemons[0].getVida();
        ofensiva = pokemons[0].getOfensiva();
        defensa = pokemons[0].getDefensa();
        velocidad = pokemons[0].getVelocidad();
        minimo = pokemons[0].getMinimo();
        maximo = pokemons[0].getMaximo();
    }
    

        
    public Ataque getAtaque(int indice){
        if(indice >= 0 && indice <= 4)
            return ataques[indice];
        return null;
    }
    
    public String getNombre() {
        return nombre;
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

    public int getDanio() {
        return danio;
    }
    
    
    
    
    
    

    
}
