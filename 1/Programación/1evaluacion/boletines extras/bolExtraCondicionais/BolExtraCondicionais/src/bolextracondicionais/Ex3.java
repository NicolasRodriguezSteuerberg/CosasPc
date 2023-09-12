/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolextracondicionais;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Ex3 {
    public void ex3(){
        //defino atributos
        float custA; //coste * persoa
        float pCV;//prezo compañia viaxes
        int numA=Integer.parseInt(JOptionPane.showInputDialog("Introduzca o numero de persoas que van a viaxe"));
        
        if (numA>=100){
            custA=65;
        }
        
        else if (numA>=50 && numA<=99){
            custA=70;
        }
        
        else if (numA>=30 && numA<=49){
            custA=95;
        }
        else{
            custA=4000/numA;
        }
        
        JOptionPane.showMessageDialog(null, "O custo por persoa é de "+custA);
        JOptionPane.showMessageDialog(null, "O prezo a pagar á compañía de viaxes é de "+(custA*numA));
        
        
    }
}
