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
public class Boletin11_5 {

    public void calc(){
        int numT=numT();
        float soldo;
        int soldTC=0;//soldo comprendido entrre 1000-1750
        double soldP=0;//soldo de trabajadores menor que 1000
        if (numT<0){
            JOptionPane.showMessageDialog(null,"O numero de trabajadores no puede ser negativo ni 0");
        }
        for (int i=0;i<numT;i++){
            soldo=Float.parseFloat(JOptionPane.showInputDialog("Teclee el soldo del trabajador "+(1+i)));
            if (soldo<0){
                do{
                JOptionPane.showMessageDialog(null, "O soldo non pode ser negativo");
                soldo=Float.parseFloat(JOptionPane.showInputDialog("Teclee el soldo del trabajador "+(1+i)));
                }
                while(soldo<0);
            }
            else if(soldo==0){
                System.out.println("Fin programa");
                break;
            }
            else{
                
                if (soldo>=1000 && soldo<=1750){
                    soldTC=soldTC+1;
                }
                else if (soldo>0 && soldo<1000){
                    soldP=soldP+1;
                }
                
            }
            
            
        }
        System.out.println("O numero de trabajadores que ganan entre 1000 e 1750 euros é "+soldTC);
        System.out.println("O porcentaxe dos tranajadores que ganan menos de 1000 é "+((soldP/numT)*100)+"%");   
    }
    
    
    public int numT(){
        int numT=Integer.parseInt(JOptionPane.showInputDialog("Teclee el numero de trabajadores"));
        return numT;
    }
    
    

    
}
