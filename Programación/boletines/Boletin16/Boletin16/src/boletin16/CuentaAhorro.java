/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin16;

/**
 *
 * @author dam1
 */
public class CuentaAhorro extends Conta{
    //atributos
    private double interese;
    
    private double saldoMinimo;
    
    private double saldo;
    
    
    //constructor defecto
    public CuentaAhorro(){}
    
    //constructor parametrizado
    public CuentaAhorro(Cliente cli ,long nC, double inte, double sm){
        super (cli, nC);
        interese = inte;
        saldoMinimo = sm;
        
        //set y get saldo
        super.setSaldo(2343);
        saldo = super.getSaldo();
        
        if (super.getSaldo()>saldoMinimo){
            saldo = saldo - (saldo*(interese/100)*1);
        }
        
        else {
            System.out.println("O teu saldo é inferior ao mínimo");
        }
        
        
    }

    @Override
    public String toString() {
        return super.toString()+" saldo=" + saldo;
    }

    
    
    
    
    
}
