/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enumeraciones;

/**
 *
 * @author nicol
 */
public enum Ataque {    
    /*0 a 4
    *Agua
    */
    PISTOLA_AGUA("Pistola agua", 40), HIDROBOMBA("Hidrobomba", 110), RAYO_BURBUJA("Rayo burbuja",65), SURF("Surf", 90), CASCADA("Cascada",80),
    
    /*5 a 9
    *Electrico
    */
    COLMILLO_RAYO("Colmillo rayo", 65), IMPACTRUENO("Impactrueno", 40), RAYO("Rayo", 90), TRUENO("Trueno", 110), ELECTROCANON("Electrocañón", 120),
    
    /*10 a 14
    *Fuego
    */
    ASCUAS("Ascuas", 40), GIRO_FUEGO("Giro fuego", 35), LANZALLAMAS("Lanzallamas", 90), HUMAREDA("Humareda", 80), LLAMARADA("Llamarada",110),
    
    /*15 a 19
    *Planta
    */
    HOJA_AFILADA("Hoja afilada", 55), LATIGO_CEPA("Latigo cepa", 45), HOJA_AGUDA("Hoja aguda", 90), ENERGIBOLA("Energibola", 90), DANZA_PETALO("Danza petalo", 120);
 
    private String nome;
    private int danoBase;
    
    private Ataque(String nome, int danoBase){
        this.nome = nome;
        this.danoBase = danoBase;
    }

    public String getNome() {
        return nome;
    }
    
    public int getDanoBase(){
        return danoBase;
    }
    
    
    
    
    
    
}
