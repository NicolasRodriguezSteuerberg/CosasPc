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
    private float daño = 0;
    
    public Pickachu(String nome, float ps, int ataque, int defensa, int velocidad) {
        super(nome, ps, ataque, defensa, velocidad);
    }
    
    public void verAtaques(){
        System.out.println("1. Arañazo\t2. Impactrueno\n3. Rayo   \t4.Puño trueno");
    }

    public void arañazo(){
        daño = super.getAtaque()*20;
    }

    public void impactrueno(){
        daño = super.getAtaque()*40;
    }
    
    public void rayo(){
        daño = super.getAtaque()*50;
    }
    
    public void puñoTrueno(){
        daño = super.getAtaque()*55;

    }
    
    
    public float getDaño(){
        return daño;
    }

       
}
