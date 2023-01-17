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
    
    public Pickachu(String nome, int ps, int ataque, int defensa, int velocidad) {
        super(nome, ps, ataque, defensa, velocidad);
    }
    
    public void ataques(){
        System.out.println("Los ataques de Pickachu son 1. Arañazo\n2. Impactrueno\n3. rayo\n4. Puño Trueno");
    }

    public void arañazo(){
        System.out.println("Pickachu ha usado arañazo");
        daño = super.getAtaque()*20/100;
    }
        

    public void impactrueno(){
        System.out.println("Pickachu ha usado impactrueno");
        daño = super.getAtaque()*40/100;
    }
    
    public void rayo(){
        System.out.println("Pickachu ha usado rayo");
        daño = super.getAtaque()*50/100;
    }
    
    public void puñoTrueno(){
        System.out.println("Pickachu ha usado puño trueno");
        daño = super.getAtaque()*55/100;
    }
    
    public float getDaño(){
        return daño;
    }

       
}
