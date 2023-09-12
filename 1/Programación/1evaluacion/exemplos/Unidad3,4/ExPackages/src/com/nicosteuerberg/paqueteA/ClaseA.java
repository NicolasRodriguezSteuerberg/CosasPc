/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicosteuerberg.paqueteA;

import com.nicosteuerberg.paqueteB.ClaseD;

/**
 *
 * @author dam1
 */
public class ClaseA {
    private void amosarClaseA(){
        System.out.println("Amosamos clase A");
    }
    
    public void amosar(){
        ClaseB obxB=new ClaseB();
        obxB.amosarClaseB();
    }
    
    public void amosarD(){
        ClaseD obxD=new ClaseD();
        obxD.amosarClaseD();
    }
}
