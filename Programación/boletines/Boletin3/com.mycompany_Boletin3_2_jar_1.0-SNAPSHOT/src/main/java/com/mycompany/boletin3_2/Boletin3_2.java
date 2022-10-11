/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.boletin3_2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin3_2 {

    /*public static void main(String[] args) {
        Scanner obxScanner=new Scanner(System.in);
        double tC, tF, tkelvin;//tCelsius, tFahrenheit, tKelvin
        System.out.println("Ingrese os grados centigrados a convertir");
        tC=obxScanner.nextInt();
        tF=tC*1.8+32;
        tkelvin=tC + 273.15;
        System.out.println("Os "+tC+" grados celsius son equivalentes a \n"+tF+" Grados Fahrenheit \n"+ tkelvin +" Grados kelvin");
      
     }  */         
    public static void getInputsFromScanner(){        
        double tC;
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese os grados centígrados ");
        tC = input.nextLine();
        System.out.print("Has ingresado: "+tC+"ºC");

         
    }
     
    public static void getInputsFromJOptionPane()
    {
        String name;
        name = JOptionPane.showInputDialog(null,
         "Please enter your name");
        JOptionPane.showMessageDialog(null,"Hi "+ name);
         
    }
     
    public static void main(String args[])
    {
       getInputsFromScanner();
       getInputsFromJOptionPane(); 
    }

