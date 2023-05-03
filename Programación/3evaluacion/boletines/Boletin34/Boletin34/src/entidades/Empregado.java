package entidades;

import java.util.GregorianCalendar;

/**
 *
 * @author NSteuerberg
 */
public class Empregado {
    private String DNI,nome,apelidos;
    private GregorianCalendar calendario;

    public Empregado(String DNI, String nome, String apelidos, GregorianCalendar e) {
        this.DNI = DNI;
        this.nome = nome;
        this.apelidos = apelidos;
        this.calendario = e;
    }

    @Override
    public String toString() {
        return DNI + ", " + nome + ", " + apelidos + ", " + calendario.get(GregorianCalendar.YEAR) + ", " + calendario.get(GregorianCalendar.MONTH) + ", " + calendario.get(GregorianCalendar.DATE);
    }
    
    //setters y getters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public GregorianCalendar getCalendario() {
        return calendario;
    }

    public void setCalendario(GregorianCalendar calendario) {
        this.calendario.set(calendario.get(GregorianCalendar.YEAR), GregorianCalendar.MONTH, GregorianCalendar.DATE);
    }

    
    
    
}
