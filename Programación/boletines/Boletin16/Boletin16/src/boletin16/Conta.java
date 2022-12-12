/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin16;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Conta{
    
    //atributos
    private long numeroConta;
    
    private double saldo;
    
    private Cliente cliente;
    
    //constructores
    public Conta(){}
    
    public Conta(Cliente cli, long nC){
        cliente = cli;
        numeroConta = nC;
    }
    
         //setters y getters
    public void setNumeroConta(long nC){
        numeroConta = nC;
    }
    
    public long getNumeroConta(){
        long nC = numeroConta;
        return nC;
    }
    
    public void setSaldo(double sald){
        saldo = sald;
    }
    
    public double getSaldo(){
        double sald = saldo;
        return sald;
    }
    
    
    //métodos
    
    public double ingresar(){
        int ing = JOptionPane.showConfirmDialog(null, "Quieres retirar dinero");
        
        if (ing == 0){
            double ingreso;
            ingreso = Double.parseDouble(JOptionPane.showInputDialog("Teclee a cantidade a ingresar"));
            while (ingreso < 0){
                ingreso = Double.parseDouble(JOptionPane.showInputDialog("No puedes ingresar menos de 0"));
            }
            saldo = saldo - ingreso;
        }
        return saldo;
    }
    
    public double retirar(){
        int ret = JOptionPane.showConfirmDialog(null, "Quieres retirar dinero");
        if (ret == 0){
            double retirar;
            retirar = Double.parseDouble(JOptionPane.showInputDialog("Teclee a cantidade a ingresar"));
            while (retirar > saldo){
                retirar = Double.parseDouble(JOptionPane.showInputDialog("No puedes retirar mas de lo que tienes de saldo"));
            }
            saldo = saldo - retirar;
        }
        return saldo;
    }
    
    public void actualizarSaldo(){
        JOptionPane.showMessageDialog(null, "O novo saldo é "+saldo);
    }
    
    
}
