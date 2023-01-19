/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon2.tipos;

import pokemon2.Ataque;
import pokemon2.Pokemons;

/**
 *
 * @author nicol
 */
public class Electrico extends Pokemon{

    public Electrico() {
        super();
    }





    public int getAtaque(Ataque ataque){
        int dano = 0;
            switch(ataque){
                case BOLA_VOLTIO:
                    dano = ofensiva * 50;
                    break;
                case IMPACTRUENO:
                    dano = ofensiva * 35;
                    break;
                case RAYO:
                    dano = ofensiva * 70;
                    break;
                case TRUENO:
                    dano = ofensiva * 65;
                    break;
                case ELECTROCANON:
                    dano = ofensiva * 45;
                    break;
                default:
                    dano = 0;
                    break;
            }
            
        return dano;
    }

   
    
}
