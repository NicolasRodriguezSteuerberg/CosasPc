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
        
        //conversion a fharenheit con try-catch
        float centigrados = Float.parseFloat(JOptionPane.showInputDialog("Teclee os grados centigrados para la conversion a Fharenheit"));
        
       JOptionPane.showInputDialog("Te gustan las tetas?");
        
        try{
            obx.centigradosAFharenheit(centigrados);
            float fharenheit = 9.0f/5.0f*centigrados+32.4f;
             JOptionPane.showMessageDialog(null, centigrados + "ºC son " + fharenheit + "ºFharenheit");
            System.out.println(centigrados + "ºC son " + fharenheit + "ºFharenheit");
        }catch(TemperaturaErradaExcepcion e){
            System.out.println(e.getMessage());
        }
        
        //conversion a grados reamur con try-catch
        centigrados = Float.parseFloat(JOptionPane.showInputDialog("Teclee os grados centigrados para la conversion a reamur"));
        
        try{
            obx.centigradosAReamur(centigrados);
            float reamur = 4f/5f*centigrados;
            System.out.println(centigrados + "ºC son " + reamur + "ºReamur");
        }catch(TemperaturaErradaExcepcion e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("Fin del programa");
        
    }
    
    
}
