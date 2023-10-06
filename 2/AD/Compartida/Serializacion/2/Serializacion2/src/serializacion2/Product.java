package serializacion2;

import java.io.Serializable;

public class Product implements Serializable{
    //declaración de variables
    private String codigo, descripcion;
    private double prezo;

    //Constructores, uno por defecto y otro con parametros
    public Product(){
        codigo = null;
        descripcion = null;
        prezo = 0;
    }
    public Product(String codigo, String descripcion, double prezo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.prezo = prezo;
    }

    //Setters && getters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return codigo + ", " + descripcion + ", " + prezo;
    }
    
    
}
