/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin5;



/**
 *
 * @author dam1
 */
public class Consumo {
    private float km, litros, vMed, pGas; //declaracion atributos
   
    
    //constructores
    public Consumo(){};
    
    public Consumo(float kilometros, float l, float vm, float pg){
        km=kilometros;
        litros=l;
        vMed=vm;
        pGas=pg;
    }
    
    //métodos
    public void setKm(float kilometros){
        km=kilometros;
    }
    public float getKm(){
        return km;
    }
    public void setLitros(float l){
        litros=l;
    }
    public float getLitros(){
        return litros;
    }
    public void setvMed(float vm){
        vMed=vm;
    }
    public float getvMed(){
        return vMed;
    }
    public void setpGas(float pg){
        pGas=pg;
    }
    public float getpGas(){
        return pGas;
    }
    public float getTempo(float km,float vMed){
        float tempo=km/vMed;
        return tempo;
    }
    public float consumoMedio(float km, float litros){
        float consMedio=litros/km*100;
        return consMedio;
    }
    public float consumoEuros(float litros, float km, float PGas){
        float consumoEuros=consumoMedio(litros,km)*PGas;
        return consumoEuros;
    }
}
