/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author dam1
 */
public class Charmander extends DatosComunes implements IFuego{

    private float daño = 0;
    
    public Charmander(String nome, int ps, int ataque, int defensa, int velocidad) {
        super(nome, ps, ataque, defensa, velocidad);
    }
    
    public void ataques(){
        System.out.println("Los ataques de Charmander son:\n1. Arañazo\n2. Ascuas\n3. Puño fuego\n4. Lanzallamas");
    }
    
    public void arañazo(){
        System.out.println("Charmander ha usado Arañazo");
        daño = super.getAtaque()*20/100;
    }
    
    public void atacarAscuas() {
        System.out.println("Charmander ha usado Ascuas");
        daño = super.getAtaque()*35/100;
    }
    
    public void atacarPuñoFuego() {
        System.out.println("Charmander ha usado Puño fuego");
        daño = super.getAtaque()*50/100;
    }

    public void atacarLanzallamas() {
        System.out.println("Charmander ha usado Lanzallamas");
        daño = super.getAtaque()*55/100;
    }
    
    public float getDaño(){
        return daño;
    }
    
}
