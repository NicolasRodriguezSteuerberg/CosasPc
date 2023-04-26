package entidades;

/**
 *
 * @author NSteuerberg
 */
public class Empregado {
    private String DNI,nome,apelidos,dataIngreso;

    @Override
    public String toString() {
        return "DNI: " + DNI + ", nome: " + nome + ", apelidos: " + apelidos + ", dataIngreso: " + dataIngreso;
    }
    
    
}
