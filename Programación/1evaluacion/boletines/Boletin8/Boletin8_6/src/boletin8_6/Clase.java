/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin8_6;

/**
 *
 * @author nicol
 */
public class Clase {
        public void ventas(String nomA,float ventA){
            if (ventA<=100){
            System.out.println(nomA+" É de baixo consumo");
            }
            else if(ventA>100&&ventA<=500){
                System.out.println(nomA+" É de consumo medio");
            }
            else if(ventA>500&&ventA<=1000){
                System.out.println(nomA+" É de consumo alto");
            }
            else{
                System.out.println(nomA+" É de primeira necesidade");
            }
        }
}
