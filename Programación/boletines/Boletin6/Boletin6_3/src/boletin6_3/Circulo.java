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
    private double area;
    private double lonx;
    
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
    public double getPi(){
        return PI;
    }
    
    public double calcularArea(){
        area=PI*Math.pow(radio, 2);
        return area;
    }


    public double calcularLonxitude(){
        lonx=2*radio*PI;
        return lonx;
    }
    public void verResultado(){
        System.out.println("A área é de "+area+"\n"
                + "A lonxitude é de "+ lonx+ "\n");
    }
}