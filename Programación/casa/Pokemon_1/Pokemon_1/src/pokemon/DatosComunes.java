/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;


public class DatosComunes {
    private int ps, ataque, defensa, velocidad;
    private String nome;

    public DatosComunes(String nome, int ps, int ataque, int defensa, int velocidad) {
        this.nome = nome;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    public String getNombre(){
        return nome;
    }
    
    public int getPs() {
        return ps;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    
    public int getVelocidad(){
        return velocidad;
    }
    
}
