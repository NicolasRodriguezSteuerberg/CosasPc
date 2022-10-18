/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolextra2_4;

/**
 *
 * @author dam1
 */
public class Conta {
    //atributos
    String nomeCliente;
    String numConta;
    double interese;
    double saldo;
    //Constructores
    public Conta(){
    }
    
    public Conta(String nomeCliente, String numConta, double interese, double saldo){     
    }
    //set e getters
    public void setnomeCliente(String nC){
        nomeCliente=nC;
    }
    public String getnomeCliente(String nC){
        return nomeCliente;
    }
    public void setnumConta(String numC){
        numConta=numC;
    }
    public String getnumConta(String numC){
        return numConta;
    }
    public double sgInterese(double in){
        interese=in;
        return interese;
    }
    public double sgSaldo(double sal){
        saldo=sal;
        return saldo;
    }
    //métodos + atributos nuevos
    double ingreso;
    double reintegro;
    public double ingreso(double ing){
        ingreso=ing;
        return ingreso;
    }
    public double reintegro(double rein){
        reintegro=rein;
        return rein;
    }
    public double calcularSaldo(){
        double nSaldo=saldo+ingreso-reintegro;
        System.out.println("O teu saldo actual é de "+saldo);
        return saldo;
    }
    public void transferencia(String cuentaOrigen, String cuentaDestino, double importe){
        if (importe<0){
            System.out.println("Error: Deposito incorrecto");
        }
        else
            System.out.println("O Señor "+cuentaOrigen+"transfire a "+cuentaDestino+"o importe de "+importe);
    }
    
    
}
