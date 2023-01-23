/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplostring;

import java.util.Arrays;

/**
 *
 * @author dam1
 */
public class ExemploString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nome = "Nabuconodosor";
        System.out.println("1. " + nome.length());
        System.out.println("2. " + nome.toUpperCase());
        System.out.println("3. " + nome.toLowerCase());
        System.out.println("4. " + nome.compareTo("Nabuconodosor"));
        System.out.println("5. " + nome.compareToIgnoreCase("NaBuCoNoDoSoR"));
        char caracteres[] = nome.toCharArray();
        System.out.println("6. " + Arrays.toString(caracteres));
        System.out.println("7. " + nome.substring(0, 4));
        
    }
    
}
