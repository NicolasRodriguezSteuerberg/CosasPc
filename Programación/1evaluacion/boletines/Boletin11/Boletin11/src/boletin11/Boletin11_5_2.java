/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin11;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin11_5_2 {
    public void calc(){
        float soldo;
        int i=1, soldoTC=0;
        double soldP=0;
        do{
            soldo=Float.parseFloat(JOptionPane.showInputDialog("Teclee el soldo del trabajador "+i));
            if (soldo<0){
                do{
                    soldo=Float.parseFloat(JOptionPane.showInputDialog("Teclee el soldo del trabajador "+i));
                }
                while (soldo<0);
            }
            else if (soldo>0){
                if (soldo>=1000 && soldo<=1750){
                    soldoTC++;
                }
                else if (soldo>0 && soldo<1000){
                    soldP++;
                }
                System.out.println("O numero de trabajadores que ganan entre 1000 e 1750 euros é "+soldoTC);
                System.out.println("O porcentaxe dos tranajadores que ganan menos de 1000 é "+((soldP/i)*100)+"%");  
            }
            else{
                System.out.println("Fin");
            }
            i++;
        }
        while(soldo!=0);
    }
}
