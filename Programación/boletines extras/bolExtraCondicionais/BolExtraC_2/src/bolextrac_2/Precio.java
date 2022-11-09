/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolextrac_2;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Precio {
    public void calcPrecio(){
        //Ejercicio2
        
        //atributos
        float pInicial, pFinal;
        int tamaño, tipo;
        pInicial=Float.parseFloat(JOptionPane.showInputDialog("Teclee o prezo inicial"));
        tipo=Integer.parseInt(JOptionPane.showInputDialog("Teclee o tipo, siendo este 0 o 1"));
        tamaño=Integer.parseInt(JOptionPane.showInputDialog("Teclee o tamaño, siendo este 1 o 2"));
        if(tipo==0 && tamaño==1){
            pFinal=pInicial+0.20f;
            JOptionPane.showMessageDialog(null, "O precio final é "+pFinal);
        }
        else if(tipo==0 && tamaño==2){
            pFinal=pInicial+0.30f;
            JOptionPane.showMessageDialog(null, "O precio final é "+pFinal);
        }
        else if(tipo==1 && tamaño==1) {
            pFinal=pInicial-0.50f;
            JOptionPane.showMessageDialog(null, "O precio final é "+pFinal);
        }
        else if(tipo==1 && tamaño==2) {
            pFinal=pInicial-0.30f;
            JOptionPane.showMessageDialog(null, "O precio final é "+pFinal);
        }
        else if(tipo!=0 && tipo!=1) {
            JOptionPane.showMessageDialog(null, "O tipo é incorrecto");
        }
        else {
            JOptionPane.showMessageDialog(null, "O tamaño é incorrecto");
        }
    }
}
