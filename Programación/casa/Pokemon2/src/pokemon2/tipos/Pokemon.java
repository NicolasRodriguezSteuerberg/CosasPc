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
    public String nombre;
    public String tipo;
    public int vida, ofensiva, defensa, velocidad, minimo, maximo, danio;

    //constructor
    public Pokemon() {

    }

    private Ataque[] ataques = new Ataque[4];

    //generar ataques aleatorios teniendo en cuenta el numero minimo de la enum ataques y el maximo, para que sean de su tipo
    public void generarAtaques(int minimo, int maximo) {
        int i = 0;
        ataques[i] = Ataque.values()[Random.generarAleatorio(minimo, maximo)];
        for (i = 1; i < ataques.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ataques[i] == ataques[j]) {
                    i--;
                }
            }
        }
    }

    public Pokemons[] crearPokemons() {
        Pokemons[] pokemons = {Pokemons.BULBASAUR, Pokemons.CHARMANDER};
        return pokemons;
    }

    //elegir y guardar el pokemon y sus stats?
    public void generarPokemon(Pokemons[] pokemons) {
        int i;
        System.out.println("Pokemons posibles para elegir:");
        for (i = 0; i < pokemons.length; i++) {
            System.out.println((i+1) + ". " + pokemons[i].getNome());
        }
        int nPokemon = Integer.parseInt(JOptionPane.showInputDialog("Teclea el numero del pokemon"));
        for (i = 0; i < pokemons.length; i++) {
            if ((i+1) == nPokemon) {
                nombre = pokemons[i].getNome();
                //setNombre(pokemons[i].getNome());
                vida = pokemons[i].getVida();
                ofensiva = pokemons[i].getOfensiva();
                defensa = pokemons[i].getDefensa();
                velocidad = pokemons[i].getVelocidad();
                minimo = pokemons[i].getMinimo();
                maximo = pokemons[i].getMaximo();
            }
        }
        System.out.println("Tu pokemon es: " + nombre);
    }

    public Ataque getAtaque(int indice) {
        if (indice >= 0 && indice <= 4) {
            return ataques[indice];
        }
        return null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
