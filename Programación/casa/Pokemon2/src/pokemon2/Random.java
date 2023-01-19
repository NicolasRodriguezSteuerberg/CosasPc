/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon2;

import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Random {
    public static int generarAleatorio(int minimo, int maximo){
        return (int) (Math.round(Math.random()*(maximo-minimo) + minimo));
    }
    public static int generarPokemonN(int poki){
        return Integer.parseInt(JOptionPane.showInputDialog("Teclee o numero del pokemon a elegir"));
    }
}
