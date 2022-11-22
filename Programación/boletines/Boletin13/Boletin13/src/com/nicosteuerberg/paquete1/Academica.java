package com.nicosteuerberg.paquete1;

import com.nicosteuerberg.paquete2.*;
import javax.swing.JOptionPane;


public class Academica {
    
    public static int numReferencia = 2018;   
    private int nota;    
    private String nome;    
    private Persoal alum = new Persoal();
    
    
    public Academica(){
        numReferencia ++;
    }
    
    public Academica(String nom, int note, String tlf, String email){
        numReferencia ++;
        nome = nom;
        nota = note;
        nota = validarNota();
        alum.setTelefono(tlf);
        alum.setCorreo(email);
    }

    
    @Override
    public String toString() {
        return "nota=" + nota + ", nome=" + nome +", numero de referencia=" + numReferencia+ ", " + alum;
    }
    
    public int validarNota(){  
        while(nota<0 || nota>10){
            nota = Integer.parseInt(JOptionPane.showInputDialog("A nota de "+nome+" non é válida"));
        }
        return nota;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Persoal getPersoal(){
        return alum;
    }
}
