/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nico.partes;

/**
 *
 * @author dam1
 */
public class Monitor {
    private float pulgadas;
    
    public void setPulgadas (float pulg){
        pulgadas = pulg;
    }
    
    public float getPulgadas(){
        float pulg=pulgadas;
        return pulg;
    }

    @Override
    public String toString() {
        return "As pulgadas do monitor é " + pulgadas;
    }
    
    
}
