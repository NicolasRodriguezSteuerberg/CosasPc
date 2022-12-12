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
    
    private Conta con;
    
    private double interese = 1.5;
    
    public CuentaCorriente(){}
    
    public CuentaCorriente(Cliente cli, long nC, double inte){
        super (cli, nC);
        double sald = con.getSaldo();
        sald = sald - (sald*interese/100);
    }

    @Override
    public String toString() {
        return "conta=" + con + ", interese=" + interese + '}';
    }
    
    
}
