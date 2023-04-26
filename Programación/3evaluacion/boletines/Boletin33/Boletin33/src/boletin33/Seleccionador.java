/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin33;

/**
 *
 * @author dam1
 */
public class Seleccionador extends SeleccionFutbol{
    
    
    public void seleccionarXogador(){
        System.out.println("selecciona o xogador");
    }

    @Override
    public void concentrarse() {
        System.out.println("Concentrase en seleccionar bós xogadores");
    }

    @Override
    public void viajar() {
        System.out.println("Viaxa para buscar bós xogadores");
    }

    @Override
    public void entrenar() {
        System.out.println("No entrena");
    }

    @Override
    public void jugarPartido() {
        System.out.println("Non xoga os partidos");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
