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
public class Extras3_1 {
    public void calculoCota(){
        
        float euros = 800;
        int idade;
        
        idade=Integer.parseInt(JOptionPane.showInputDialog("Teclee a súa idade"));
        
        if (idade>65){
            euros = euros - euros*40/100;
        }
        
        else if (idade<21){            
            String socio = JOptionPane.showInputDialog("O teu pai é socio?");
            
            if ("si".equals(socio)){
                euros = euros - euros*45/100;
            }
            else {
                euros = euros - euros*25/100;
            }
        }
        
        JOptionPane.showMessageDialog(null, "A túa cota é de "+euros);
        
    }    
}
