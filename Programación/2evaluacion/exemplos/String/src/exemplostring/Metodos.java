/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplostring;

import java.util.Arrays;

/**
 *
 * @author nicol
 */
public class Metodos {
    private String nome = "Nabuconodosor";
     
    public void amosarTamaño(){
         System.out.println("\n" + nome.length());
    }
    
    public void ponerMayusculas(){
        System.out.println("\n" + nome.toUpperCase());
    }
    
    public void ponerMinusculas(){
        System.out.println("\n" + nome.toLowerCase());
    }
    
    public void comparar(){
        int num = nome.compareTo("NaBuconodosor");
        if (num == 0){
            System.out.println("\nSon identicos");
        }
        else{
            System.out.println("\n Son diferentes");
        }
    }
    
    public void compararIgnorandoMayusculas(){
        int num = nome.compareToIgnoreCase("NaBuCoNoDoSoR");
        
        if(num == 0){
            System.out.println("\nNo tienen diferencias de letras");
        }
        else{
            System.out.println("\nTienen letras distintas");
        }        
    }
    
    public void amosarComoArray(){
        char caracteres[] = nome.toCharArray();
        System.out.println("\n" + Arrays.toString(caracteres));
    }
    
    public void cortarDeterminadoLugar(){
        System.out.println("\n" + nome.substring(0, 4));
    }
}
