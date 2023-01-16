/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author Usuario
 */
public class Pickachu extends DatosComunes implements IElectrico{
    private int daño = 0;
    
    public Pickachu(int ps, int ataque, int defensa, int velocidad) {
        super(ps, ataque, defensa, velocidad);
    }
    public void ataques(){
        System.out.println("placaje, mordisco, arañazo, impactrueno, puñoTrueno, rayo, ");
    }

    public void placaje(){
        daño = super.getAtaque()*20/100;
    }

    public void mordisco(){
        daño = super.getAtaque()*30/100;
    }

    public void arañazo(){
        daño = super.getAtaque()*20/100;
    }
        

    public void impactrueno(){
        daño = super.getAtaque()*40/100;
    }

    
    public void puñoTrueno(){
        daño = super.getAtaque()*75/100;
    }

    
    public void rayo(){
        daño = super.getAtaque()*90/100;
    }

    public int getDaño(){
        return daño;
    }

    
}
