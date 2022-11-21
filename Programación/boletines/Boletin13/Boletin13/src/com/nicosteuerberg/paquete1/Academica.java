package com.nicosteuerberg.paquete1;

import com.nicosteuerberg.paquete2.*;


public class Academica {
    static int numReferencia = 2018;
    
    private int nota;
    
    private String nome;
    
    private Persoal alum = new Persoal();
    
    
    public Academica(){}
    
    public Academica(String nom, int note, double tlf, String email){
        numReferencia ++;
        nome = nom;
        nota = note;
        alum.setTelefono(tlf);
        alum.setCorreo(email);
    }

    
    @Override
    public String toString() {
        return "Academica{" + "nota=" + nota + ", nome=" + nome +", tu numero de referencia=" + numReferencia + ", alum=" + alum +'}';
    }
}
