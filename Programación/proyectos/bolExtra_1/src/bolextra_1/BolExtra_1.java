/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolextra_1;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class BolExtra_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float bIm, bIva, iIva, iTotal;//base imponible, % do IVA, importe só do IVA, importe Total
        Scanner obxScanner=new Scanner(System.in);
        System.out.println("Ingrese a base imponible");
        bIm=obxScanner.nextFloat();
        System.out.println("Ingrese o IVA");
        bIva=obxScanner.nextFloat();
        iIva=bIm*(bIva/100);        
        iTotal=bIm+iIva;
        System.out.println("O importe pagado do IVA é de "+iIva+ " de euros"+"\nO importe total pagado é de "+ iTotal+ " de euros");
    }
    
}
