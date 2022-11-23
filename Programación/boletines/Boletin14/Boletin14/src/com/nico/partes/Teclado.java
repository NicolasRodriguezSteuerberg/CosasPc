/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nico.partes;

/**
 *
 * @author dam1
 */
public class Teclado {
    private String marca;
    
    public void setMarca(String marc){
        marca = marc;
    }
    
    public String getMarca(){
        String marc = marca;
        return marc;
    }

    @Override
    public String toString() {
        return "A marca do teclado é " + marca;
    }
    
    
}
