/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon2.tipos;
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
    public int vida, ofensiva, defensa, velocidad, danio;

    Pokemons poke;
    
    //constructor
    public Pokemon(int poki) {
        generarPokemon(poki);
        generarAtaques(poke.getMinimo(),poke.getMaximo());
    }
    private Pokemons[] pokimon = new Pokemons[1];
    private Ataque[] ataques = new Ataque [4];
    

    
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
    
    public void generarPokemon(int poki){
        int i = 0;
        pokimon[i] = Pokemons.values()[Random.generarPokemonN(poki)]; 
        for(i = 0; i < pokimon.length; i++){
            if(pokimon[poki-1] == pokimon[i]){
                
            }
        }
    }
    
    public Pokemons getPokemon(int ind){
        if (ind >= 0 && ind <= 4)
            return pokimon[ind];
        return null;
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
