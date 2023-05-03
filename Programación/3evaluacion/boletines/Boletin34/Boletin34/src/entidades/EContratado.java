package entidades;

import java.util.GregorianCalendar;

/**
 *
 * @author NSteuerberg
 */
public class EContratado extends Empregado{
    
    private float soldoBasico;
    private int anoActual = 2023;
    private float soldoTotal;
    
    /**
     * @param DNI
     * @param nome
     * @param apelidos
     * @param calendario
     * @param soldoBasico
     */
    public EContratado(String DNI, String nome, String apelidos, GregorianCalendar calendario, float soldoBasico) {
        super(DNI, nome, apelidos, calendario);
        this.soldoBasico = soldoBasico;
        this.soldoTotal = soldoACobrar();
    }
    
    public float soldoACobrar(){
        float soldoTotal;
        int anosTrabajados = anoActual - super.getCalendario().get(GregorianCalendar.YEAR);
        
        if(anosTrabajados>=0 && anosTrabajados<=3){
            soldoTotal = soldoBasico + (5/100)*soldoBasico;
        }
        else if(anosTrabajados<=7){
            soldoTotal = soldoBasico + (10/100)*soldoBasico;
        }
        else if(anosTrabajados<=15){
            soldoTotal = soldoBasico + (15/100)*soldoBasico;
        }
        else{
            soldoTotal = soldoBasico + (20/100)*soldoBasico;
        }
        return soldoTotal;
    }
    
    //setters && getters
    public float getSoldoBasico() {
        return soldoBasico;
    }

    public void setSoldoBasico(float soldoBasico) {
        this.soldoBasico = soldoBasico;
    }

    public int getAnoActual() {
        return anoActual;
    }

    public void setAnoActual(int anoActual) {
        this.anoActual = anoActual;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + soldoTotal;
    }
    
    
    
}
