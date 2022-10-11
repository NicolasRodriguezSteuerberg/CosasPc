/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin5;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Consumo {
    Scanner obxSca=new Scanner(System.in);
    private float km, litros, vMed, pGas; //declaracion atributos
   
    
    //declaracion métodos
    public Consumo(){};
    
    public void setKm(float kilometros){
        km=kilometros;
    }
    public float getKm(){
        return km;
    }
    
    
    
    
    
    
    
    public float getTempo(float km,float vMed){
        float tempo=km/vMed;
        return tempo;
    }
}
