/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin18;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancio el objeto del conversor de temperaturas
        ConversorTemperaturas obx = new ConversorTemperaturas();
        
        //pido los grados centigrados para la conversion a fharenheit
        JOptionPane.showMessageDialog(null, "Conversion a ºFharenheit");
        
        float centigrados = Float.parseFloat(JOptionPane.showInputDialog("Teclee os grados centigrados"));
            
        //try-catch para que si los grados son menor de 80 de excepcion
        try{
            obx.centigradosAFharenheit(centigrados);
            
            float fharenheit = 9.0f/5.0f*centigrados+32.4f;
            
            System.out.println("ºFharenheit = " + fharenheit);
            
        }catch(TemperaturaErradaExcepcion e){
            System.out.println(e.getMessage());
        }
        
        //paso a la conversion a grados reamur y pido los grados
        JOptionPane.showMessageDialog(null, "Pasando a la conversion a reamur");
        
        centigrados = Float.parseFloat(JOptionPane.showInputDialog("Teclee os grados centigrados"));
        
        //try-catch para que si los grados son menor de 80 de excepcion
        try{
            obx.centigradosAReamur(centigrados);
            
            float reamur = 4f/5f*centigrados;
            
            System.out.println("ºReamur = " + reamur);
            
        }catch(TemperaturaErradaExcepcion e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("Fin del programa");
        
    }
    
    
}
