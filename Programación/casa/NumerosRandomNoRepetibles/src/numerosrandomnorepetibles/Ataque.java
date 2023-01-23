/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numerosrandomnorepetibles;

/**
 *
 * @author nicol
 */
public enum Ataque {    
    /*0 a 4
    *Agua
    */
    PISTOLA_AGUA("Pistola agua"), HIDROBOMBA("Hidrobomba"), RAYO_BURBUJA("Rayo burbuja"), SURF("Surf"), CASCADA("Cascada"),
    
    /*5 a 9
    *Electrico
    */
    BOLA_VOLTIO("Bola voltio"), IMPACTRUENO("Impactrueno"), RAYO("Rayo"), TRUENO("Trueno"), ELECTROCANON("Electrocanon"),
    
    /*10 a 14
    *Fuego
    */
    ASCUAS("Ascuas"), GIRO_FUEGO("Giro fuego"), LANZALLAMAS("Lanzallamas"), HUMAREDA("Humareda"), LLAMARADA("Llamarada"),
    
    /*15 a 19
    *Planta
    */
    HOJA_AFILADA("Hoja afilada"), LATIGO_CEPA("Latigo cepa"), HOJA_AGUDA("Hoja aguda"), ENERGIBOLA("Energibola"), DANZA_PETALO("Danza petalo");
 
    private String nome;
    
    private Ataque(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    
    
    
    
}
