/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author Usuario
 */
public class Bulbasaur extends DatosComunes implements IPlanta{
    private int daño = 0;
    public Bulbasaur(int ps, int ataque, int defensa, int velocidad) {
        super(ps, ataque, defensa, velocidad);
    }

    public void ataques(){
        System.out.println("Los ataques de bulbasaur son placaje, mordisco, arañazo, hojaAfilada, latigoCepa");
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

    public void hojaAfilada(){
        daño = super.getAtaque()*55/100;
    }

   
    public void latigoCepa(){
        daño = super.getAtaque()*55/100;
    }
    
    
}

