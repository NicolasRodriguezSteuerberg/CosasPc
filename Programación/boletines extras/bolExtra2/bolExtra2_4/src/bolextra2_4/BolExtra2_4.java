/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolextra2_4;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class BolExtra2_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conta obxC=new Conta();
        Scanner Sca=new Scanner(System.in);
        System.out.println("Escriba o teu nome");
        obxC.setnomeCliente(Sca.next());
        System.out.println("Escriba o teu saldo actual");
        obxC.sgSaldo(Sca.nextDouble());
        System.out.println("Teclee a cantidade a ingresar");
        obxC.ingreso(Sca.nextDouble());
        System.out.println("O saldo actual é "+obxC.calcularSaldo());
        System.out.println("Teclee a cantidade a retirar");
        obxC.reintegro(Sca.nextDouble());
        System.out.println("O saldo actual é de "+obxC.calcularSaldo2());
        
        obxC.transferencia("teclee o teu nome"+Sca.next(), "teclee o nome da conta da transferencia"+Sca.next(),123.34);
        

    }
    
}
