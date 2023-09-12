/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin33;

/**
 *
 * @author dam1
 */
public abstract class SeleccionFutbol implements IntegranteSeleccionFutbol{
    protected Integer id,edad;
    protected String nombre,apellidos;

    @Override
    public String toString() {
        return "id=" + id + ", edad=" + edad + ", nombre=" + nombre + ", apellidos=" + apellidos;
    }
    
    
}
