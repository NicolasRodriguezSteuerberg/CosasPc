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
        Scanner obxSca = new Scanner(System.in);
                
        String estado1 = "vivo";
        String estado2 = "vivo";
        int pok1, pok2;
        String nPoke1 = ""; 
        String nPoke2 = "";
        
        
        System.out.println("Jugador 1 escoge tu pokemon:\n1. Pickachu\n2. Bulbasaur\n3. Charmander\n4. Squirtle");
        pok1 = obxSca.nextInt();
        switch(pok1){
            case 1:
                Pickachu Pika1 = new Pickachu("Pikachu", 35, 55, 50, 90);
                nPoke1 = Pika1.getNombre();
                break;
                
            case 2:
                Bulbasaur obxB = new Bulbasaur("Bulbasaur", 45, 49, 65, 45);
                nPoke1 = obxB.getNombre();
                break;
            case 3:
                Charmander obxC = new Charmander("Charmander", 39, 60, 50, 65);
                nPoke1 = obxC.getNombre();
                break;
            case 4:
                Squirtle obxS = new Squirtle("Squirtle", 44, 50, 65, 43);
                nPoke1 = obxS.getNombre();
                break;
        }
        
        System.out.println("Jugador 2 escoge tu pokemon:\n1. Pickachu\n2. Bulbasaur\n3. Charmander\n4. Squirtle");
        pok2 = obxSca.nextInt();
        switch(pok2){
            case 1:
                Pickachu Pika1 = new Pickachu("Pikachu", 35, 55, 50, 90);
                nPoke2 = Pika1.getNombre();
                break;
                
            case 2:
                Bulbasaur obxB = new Bulbasaur("Bulbasaur", 45, 49, 65, 45);
                nPoke2 = obxB.getNombre();
                break;
            case 3:
                Charmander obxC = new Charmander("Charmander", 39, 60, 50, 65);
                nPoke2 = obxC.getNombre();
                break;
            case 4:
                Squirtle obxS = new Squirtle("Squirtle", 44, 50, 65, 43);
                nPoke2 = obxS.getNombre();
                break;
        }
        
        System.out.println("Los equipos son los siguientes:\nPokemon primer jugador: " + nPoke1 + "\nPokemon segundo jugador: " + nPoke2);
        
        
        
        
        
    }
    
}
