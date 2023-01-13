/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;


public abstract class DatosComunes {
    private int numPokedex, temporada;
    private String nome, sexo;
    private float peso;
    
    public DatosComunes(String nome, int numPokedex, String sexo, float peso,int temporada){
        this.nome = nome;
        this.numPokedex = numPokedex;
        this.sexo = sexo;
        this.peso = peso;
        this.temporada = temporada;
    }
    
    //public atacarPlacaje();
    
    public String getNome(){
        return nome;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public int getNumPokedex(){
        return numPokedex;
    }
    
    public int getTemporada(){
        
    }
    
}
