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
    private float daño = 0;
    
    public Bulbasaur(String nome, int ps, int ataque, int defensa, int velocidad) {
        super(nome, ps, ataque, defensa, velocidad);
    }

    public void ataques(){
        System.out.println("Los ataques de bulbasaur son placaje, mordisco, arañazo, hojaAfilada, latigoCepa");
    }
    
    public void placaje(){
        System.out.println("Bulbasaur ha usado placaje");
        daño = super.getAtaque()*20/100;
    }

    public void mordisco(){
        System.out.println("Bulbasaur ha usado mordisco");
        daño = super.getAtaque()*30/100;
    }

    public void hojaAfilada(){
        System.out.println("Bulbasaur ha usado hoja afilada");
        daño = super.getAtaque()*55/100;
    }

   
    public void latigoCepa(){
        System.out.println("Bulbasaur ha usado latigo cepa");
        daño = super.getAtaque()*60/100;
    }
    
    public float getDaño(){
        return daño;
    }
    
}

