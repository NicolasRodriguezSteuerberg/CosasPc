/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin6_3;

/**
 *
 * @author dam1
 */



public class Circulo {
    //atributos
    private double radio;
    final static double PI=3.14;
    
    //constructor
    public Circulo(){}
    
    public Circulo(double r){
        r=radio;
    }
    //métodos
    public void setradio(double r){ 
        radio=r;
    }
    public double getradio(){
        return radio;
    }
    
    public void calcularArea(){
        double area=PI*Math.pow(radio, 2);
    }
    public void calcularLonxitude(){
        double lonx=2*radio*PI;
    }
    
}