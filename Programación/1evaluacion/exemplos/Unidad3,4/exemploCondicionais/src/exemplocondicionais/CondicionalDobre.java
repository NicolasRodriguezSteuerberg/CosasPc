/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplocondicionais;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class CondicionalDobre {
    public void consultaEdade(int edade){

        
        if(edade>=18){
            JOptionPane.showMessageDialog(null, "É maior de edade");
        }
        else{
            JOptionPane.showMessageDialog(null, "É menor de edade");
        }
    }
    //con operando (?)
    public void operarEdade(int edade){
        String res= (edade>=18)? "maior":"menor";
            System.out.println(res);
            
            
            
    }
   
}
