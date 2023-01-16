/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Pokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pickachu obxP = new Pickachu(35, 55, 40, 90);
        Bulbasaur obxB = new Bulbasaur(45, 49, 49, 45);
        Scanner obxSca = new Scanner(System.in);
        
        
        String estado1 = "vivo";
        String estado2 = "vivo";
        String poke1;
        String poke2 = "";
        
        System.out.println("Jugador 1 teclee el nombre de tu pokemon:\nPickachu\nBulbasaur");
        poke1 = obxSca.next();
        
        if(poke1 == "Pickachu"){
            poke2 = "Bulbasaur";
        }else{
            poke2 = "Pickachu";
        }
        System.out.println("Los equipos son los siguientes:\nPokemons primer jugador \t Pokemons segundo jugador\n   " + poke1 +"\t \t " + poke2);
        
        
        
        do{
            if(poke1 == "Pickachu"){
                obxP.getVelocidad();
                obxB.getVelocidad();
                
            }
        }while(estado1 != "vivo" || estado2 != "vivo");
        
    }
    
}
