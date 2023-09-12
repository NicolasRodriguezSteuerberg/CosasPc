package com.nicosteuerberg.paquete1;


public class Aplicacion {

 
    public static void main(String[] args) {
        Academica obx = new Academica("Nico",9, "65128912", "nico@gmail.com");
        System.out.println(obx.toString());
        
        System.out.println(obx.getNome());
        
        Academica obx2 = new Academica("Gabriel", 5, "89788912", "gabriel@gmail.com");
        System.out.println(obx2.toString());
        
        System.out.println(obx.getPersoal().getTelefono());
    }
    
}
