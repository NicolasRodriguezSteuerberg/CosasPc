/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin17;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Probas{
    
    public void Probas(){
        
        //atributos
        float probasEscritas;
        
        float boletines;
        
        float probaPractica;
        
        float notaT;
        
        //constructor calculos para poder usar sus operaciones
        Calculos obx = new Calculos();
        
        //llamamos a nombre para pedirlo
        String nome = obx.Nombre();        
        
        //llamamos a nota, la guardamos en una variable para poder hacer la media
        JOptionPane.showMessageDialog(null, "A continuación teclee as notas das probas escritas");
        float notaE1 = obx.Notas();
        float notaE2 = obx.Notas();
        probasEscritas = ((notaE1+notaE2)/2)*0.4f;
        
        //llamamos a nota para calcular la prueba práctica
        JOptionPane.showMessageDialog(null, "A continuación teclee a nota da proba práctica");
        float notaP = obx.Notas();
        probaPractica = notaP*0.40f;
        
        //llamamos a boletines maximos y hechos para calcular la nota de boletines
        float bolM = obx.NBolMax();
        float bolH = obx.NBolHechos();
        
        //le doy valor a boletines dependiendo de la media que has realizado
        if (bolH/bolM*100 > 90){
            boletines = 2;
        }
        
        else if (70 <= bolH/bolM*100 && bolH/bolM*100 <= 90){
            boletines = 1;
        }
        
        else{
            boletines = 0;
        }
        
        notaT = probasEscritas + probaPractica + boletines;
        
        //decimlaFormat
        DecimalFormat decim = new DecimalFormat("##.##");
        
        
        System.out.println("ALUMNO = " + nome
                + "\nPROBAS TEÓRICAS = "+ decim.format(probasEscritas)
                + "\nPROBA PRÁCTICA = " + decim.format(probaPractica)
                + "\nBOLETINES = " + decim.format(boletines)
                + "\nNOTA TOTAL = " + decim.format(notaT) + "\n\n");
                
    }    
    
}
