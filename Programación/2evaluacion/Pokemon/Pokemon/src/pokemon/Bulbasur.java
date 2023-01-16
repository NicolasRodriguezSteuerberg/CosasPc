/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author Usuario
 */
public class Bulbasur extends DatosComunes implements IPlanta{

    public Bulbasur(String nome, int numPokedex, String sexo, float peso, int temporada) {
        super(nome, numPokedex, sexo, peso, temporada);
    }

    @Override
    public void atacarPlacaje() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con placaje");
    }

    public void atacarMordisco() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con mordisco");
    }

    public void atacarArañazo() {
       System.out.println("Soy " + super.getNome() + "y estoy atacando con Arañazo"); 
    }

    public void atacarParalizar() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Paralizar");
    }

    public void atacarDrenaje() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Drenaje");
    }

    @Override
    public void atacarHojaAfilada() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Hoja afilada");
    }

    @Override
    public void atacarLatigoCepa() {
        System.out.println("Soy " + super.getNome() + "y estoy atacando con Latigo cepa");
    }
    
}
