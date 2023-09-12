/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin33;

/**
 *
 * @author dam1
 */
public class Masajista extends SeleccionFutbol{

    private String titulacion;
    private Integer aniosExperiencia;
    
    @Override
    public void concentrarse() {
        System.out.println("concentrase o masajista");
    }

    @Override
    public void viajar() {
        System.out.println("Viaxa o masajista");
    }

    @Override
    public void entrenar() {
        System.out.println("O masajista entrena los masajes");
    }

    @Override
    public void jugarPartido() {
        System.out.println("O masajista no juega los partidos");
    }
    
    public void darMensaje(){
        System.out.println("O masajista da un mensaxe");
    }

    @Override
    public String toString() {
        return super.toString() + ", titulacion=" + titulacion + ", aniosExperiencia=" + aniosExperiencia;
    }
    
    
}
