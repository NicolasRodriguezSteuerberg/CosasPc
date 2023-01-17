/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author dam1
 */
public class Squirtle extends DatosComunes implements IAgua{
    private float daño = 0;    

    public Squirtle(String nome, int ps, int ataque, int defensa, int velocidad) {
        super(nome, ps, ataque, defensa, velocidad);
    }

    public void ataques(){
        System.out.println("Los ataques de squirtle son:\n1. placaje\n2. PistolaAgua\n3. Burbuja\n4. Hidropulso");
    }

    public void placaje(){
        System.out.println("Squirtle ha usado Placaje");
        daño = super.getAtaque()*20/100;
    }

    public void atacarPistolaAgua() {
        System.out.println("Squirtle ha usado Pistola agua");
        daño = super.getAtaque()*40/100;
    }

 
    public void atacarBurbuja() {
        System.out.println("Squirtle ha usado Burbuja");
        daño = super.getAtaque()*50/100;
    }


    public void atacarHidropulso() {
        System.out.println("Squirtle ha usado Hidropulso");
        daño = super.getAtaque()*55/100;
    }
    
    public float getDaño(){
        return daño;
    }
    
}
