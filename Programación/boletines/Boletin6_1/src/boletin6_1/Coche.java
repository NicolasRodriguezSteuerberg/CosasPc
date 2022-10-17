/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin6_1;

/**
 *
 * @author dam1
 */
public class Coche {
    //atributos
    private int velocidade;
    private int v;
    private int v2;
    //constructor
    public Coche(){
    velocidade =0 ;
    }
    //metodos
    public int getVelocidade(){
        return velocidade;
    }
    public void acelerar(int valor){
        v=velocidade+valor;
    }
    public int getacelerar(){
        return v;
    }
    public void frenar(int menos){
        v2=v-menos;
    }
    public int getfrenar(){
        return v2;
    }
}
