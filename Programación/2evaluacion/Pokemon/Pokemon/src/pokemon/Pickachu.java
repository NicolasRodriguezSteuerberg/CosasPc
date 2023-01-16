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

    public Pickachu(String nome, int numPokedex, String sexo, float peso, int temporada) {
        super(nome, numPokedex, sexo, peso, temporada);
    }

    public void atacarPlacaje() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Placaje");
    }

    public void atacarMordisco() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Mordisco");
    }

    public void atacarArañazo() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Arañazo");
    }
        

    public void atacarImpactrueno() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Impactrueno");
    }
    
    public void atacarPuñoTrueno() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Puño trueno");
    }
    
    public void atacarRayo() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Rayo");
    }
  
    public void atacarRayoCarga() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Rayo cara");
    }
    
}
