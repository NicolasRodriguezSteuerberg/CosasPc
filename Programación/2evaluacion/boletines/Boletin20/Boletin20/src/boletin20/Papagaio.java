/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin20;

/**
 *
 * @author dam1
 */
public class Papagaio extends Aves implements IPodeVolar, IPodeCamiñar{
    public void camiñar(){
        System.out.print("Os papagaios poden camiñar");
    }
    public void voar(){
        System.out.println(" e tamen poden volar\n");
    }
}
