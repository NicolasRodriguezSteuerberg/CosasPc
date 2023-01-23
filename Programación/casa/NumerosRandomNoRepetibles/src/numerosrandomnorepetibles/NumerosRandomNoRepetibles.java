/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numerosrandomnorepetibles;
import numerosrandomnorepetibles.Ataque;

/**
 *
 * @author nicol
 */
public class NumerosRandomNoRepetibles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random ran = new Random();
        Ataque aux[] = new Ataque[4];
        ran.generarAtaques(aux);
    }
    
    
}
