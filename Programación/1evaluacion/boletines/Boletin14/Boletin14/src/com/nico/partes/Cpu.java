/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nico.partes;

/**
 *
 * @author dam1
 */
public class Cpu {
    private int velocidade;
    
    public void setVelocidade(int vel){
        velocidade = vel;
    }
    
    public int getVelocidade(){
        int vel = velocidade;
        return vel;
    }

    @Override
    public String toString() {
        return "A velocidade de CPU é de " + velocidade;
    }
    
    
}
