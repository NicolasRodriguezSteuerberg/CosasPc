/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin18;

/**
 *
 * @author dam1
 */
public class ConversorTemperaturas {
    private final static float CTE = 80;
       
    public float centigradosAFharenheit(float grados) throws TemperaturaErradaExcepcion{
        float fharenheit = 0;
        if(grados<CTE){
            throw new TemperaturaErradaExcepcion("Los ºC para la conversion a ºFharenheit no pueden ser menor de 80");
        }        
        return fharenheit;
    }
    
    public void centigradosAReamur(float grados) throws TemperaturaErradaExcepcion{
        if(grados<CTE){
            throw new TemperaturaErradaExcepcion("Los ºC para la conversion a ºReamur no pueden ser menor de 80");
        }        
    }
}
