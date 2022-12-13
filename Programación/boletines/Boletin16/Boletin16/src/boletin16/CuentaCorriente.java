/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin16;

/**
 *
 * @author dam1
 */
public class CuentaCorriente extends Conta{
        
    //atributos
    private double interese = 1.5;
    
    private double saldo;
    
    //constructores
    public CuentaCorriente(){}
    
    public CuentaCorriente(Cliente cli, long nC){
        super (cli, nC);
        super.setSaldo(1500);
        saldo = super.getSaldo();
        saldo = saldo - (saldo*interese/100);
    }
    
    //método toString

    @Override
    public String toString() {
        return super.toString() + " saldo=" + saldo;
    }

    
}
