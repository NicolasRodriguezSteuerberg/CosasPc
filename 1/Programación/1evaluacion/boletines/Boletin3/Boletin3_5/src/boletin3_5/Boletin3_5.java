/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin3_5;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Boletin3_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double sfixo, ivendas, kmf, dietas, sbruto, sliquido;//soldo fixo, importe das vendas, km feitos, dietas por dia movido, soldo bruto, soldo líquido
        Scanner obxScanner=new Scanner(System.in);
        System.out.println("Introduzca o soldo fixo");
        sfixo=obxScanner.nextDouble();
        System.out.println("Introduzca o importe das vendas");
        ivendas=obxScanner.nextDouble();
        System.out.println("Introduzca os quilometros feitos");
        kmf=obxScanner.nextDouble();
        System.out.println("Introduzca os días de desprazamento");
        dietas=obxScanner.nextDouble();
        sbruto=sfixo+ivendas*(5/100)+kmf*2+dietas*30 ;
        sliquido=sbruto-(18/100*sbruto-36);
        System.out.println("O teu soldo bruto é de "+sbruto+" de euros"+"\n"
                + "O teu soldo líquido é de "+sliquido+" de euros");
    }
    
}
