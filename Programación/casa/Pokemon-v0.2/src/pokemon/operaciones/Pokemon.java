/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon.operaciones;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import Enumeraciones.Ataque;
import Enumeraciones.Pokemons;


/**
 *
 * @author nicol
 */
public class Pokemon {

    //atributos de los pokemons
    public String nombre;
    public String tipo, debilidad1, debilidad2;
    public int vida, ofensiva, defensa, velocidad, minimo, maximo;

    //constructor
    public Pokemon() {

    }
        
    public Pokemons[] crearPokemons() {
        Pokemons[] pokemons = {Pokemons.HELIOLISK, Pokemons.SQUIRTLE,Pokemons.BULBASAUR, Pokemons.CHARMANDER};
        return pokemons;
    }
    public int numPokemons(Pokemons[] pokemons){
        return pokemons.length;
    }
    
    public void verPokemons(Pokemons[] pokemons){
        int i;
        for (i = 0; i < pokemons.length; i++) {
            System.out.println((i+1) + ". " + pokemons[i].getNome());
        }
    }

    //elegir y guardar el pokemon y sus stats?
    public void generarPokemon(Pokemons[] pokemons, int nPokemon) {
        int i;
        for (i = 0; i < pokemons.length; i++) {
            if ((i+1) == nPokemon) {
                nombre = pokemons[i].getNome();
                //setNombre(pokemons[i].getNome());
                vida = pokemons[i].getVida();
                ofensiva = pokemons[i].getOfensiva();
                defensa = pokemons[i].getDefensa();
                velocidad = pokemons[i].getVelocidad();
                tipo = pokemons[i].getTipo();
                debilidad1 = pokemons[i].getDebilidad1();
                debilidad2 = pokemons[i].getDebilidad2();
                minimo = pokemons[i].getMinimo();
                maximo = pokemons[i].getMaximo();
            }
        }
    }
    
    //generar ataques aleatorios teniendo en cuenta el numero minimo de la enum ataques y el maximo, para que sean de su tipo
   
    public Ataque[] atac = new Ataque[4];
    
     public void generarAtaques(Ataque[] atac){
        Ataque[] ataq = {Ataque.PISTOLA_AGUA, Ataque.HIDROBOMBA, Ataque.RAYO_BURBUJA, Ataque.SURF, Ataque.CASCADA, Ataque.COLMILLO_RAYO, Ataque.IMPACTRUENO, Ataque.RAYO, Ataque.TRUENO, Ataque.ELECTROCANON, Ataque.ASCUAS, Ataque.GIRO_FUEGO, Ataque.LANZALLAMAS, Ataque.HUMAREDA, Ataque.LLAMARADA, Ataque.HOJA_AFILADA, Ataque.LATIGO_CEPA, Ataque.HOJA_AGUDA, Ataque.ENERGIBOLA, Ataque.DANZA_PETALO};
        int num;
        for(int i = 0; i < atac.length ; i++){
            int numero = (int) (Math.random()*((maximo+1) - minimo))+minimo;
            if(i>0){
                for(int j = i; j > -1; j--){
                    while(atac[j] == ataq[numero]){
                        numero = (int) (Math.random()*((maximo+1) - minimo))+minimo;
                        j = i;
                    }
                }
            }
            atac[i] = ataq[numero];
            System.out.print((i+1) + ". " + atac[i].getNome() + "    ");

        }
    }
     
    public void verAtaques(Ataque[] atac){
        for(int i = 0; i < atac.length ; i++){
            System.out.print((i+1) + ". " +atac[i].getNome() + "    ");
        }
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMinimo() {
        return minimo;
    }

    public int getMaximo() {
        return maximo;
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
    
    public String getTipo(){
        return tipo;
    }

    public String getDebilidad1() {
        return debilidad1;
    }

    public String getDebilidad2() {
        return debilidad2;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
}
