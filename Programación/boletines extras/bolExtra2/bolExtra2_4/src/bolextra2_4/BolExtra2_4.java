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
        Sca.next();
        Sca=obxC.se;
        obxC.ingreso(1230.45);
        obxC.reintegro(23.12);
        obxC.calcularSaldo();
    }
    
}
