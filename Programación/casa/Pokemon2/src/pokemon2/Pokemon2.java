/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon2;

import pokemon2.tipos.Pokemon;


/**
 *
 * @author nicol
 */
public class Pokemon2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pokemons auxiliar[];
        Pokemon poke = new Pokemon();
        auxiliar = poke.crearPokemons();
        poke.generarPokemon(auxiliar);
    }
    
}
