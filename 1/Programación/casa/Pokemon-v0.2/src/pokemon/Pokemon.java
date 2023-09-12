/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon;

import com.nicosteuerberg.datos.PedirDatos;
import javax.swing.JOptionPane;
import pokemon.operaciones.Batalla;
import pokemon.operaciones.BatallaContraMaquina;


/**
 *
 * @author nicol
 */
public class Pokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Batalla bat = new Batalla();
        BatallaContraMaquina batM = new BatallaContraMaquina();
        
        int num = PedirDatos.getInt("1. Batalla contra otro jugador\n2. Batalla contra la maquina hasta que pierdas");
        switch(num){
            case 1:
                JOptionPane.showMessageDialog(null, "Bienvenido a la batalla contra otro jugador\nQue gane el mejor");
                bat.generarPokemon1();
                bat.generarPokemon2();
                bat.batalla();
                break;
            case 2:
                batM.generarPokemon1();
                batM.batalla();
                break;
        }



                
    }
    
}
