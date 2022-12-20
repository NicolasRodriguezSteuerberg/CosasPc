/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolextra3;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Extras3_2 {
    public void esFechaValida(){
        int dia, mes, ano;
        
        mes=Integer.parseInt(JOptionPane.showInputDialog("Teclee o mes"));
        while (mes<1 || mes >12){
            mes=Integer.parseInt(JOptionPane.showInputDialog("Teclee un mes válido"));
        }
        
        ano= Integer.parseInt(JOptionPane.showInputDialog("Teclee o ano"));
        
        while (ano<1600 || ano>3000){
            ano= Integer.parseInt(JOptionPane.showInputDialog("Teclee un ano entre 1600 e 3000"));
        }
        
    }
}
