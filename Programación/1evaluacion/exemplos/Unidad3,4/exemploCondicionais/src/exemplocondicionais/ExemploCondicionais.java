/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplocondicionais;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class ExemploCondicionais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Condicional simple        
        /*CondicionalSimple obxCS=new CondicionalSimple();
        obxCS.maiorEdade(20);
        obxCS.maiorEdade(16);
        pedimos datos utilizando JOptionPane
        String res=JOptionPane.showInputDialog("teclea a edade");
        int edade=Integer.parseInt(res);
        obxCS.maiorEdade(edade);*/
        
        //Condicional Dobre       
        CondicionalDobre obxCD=new CondicionalDobre();
        String res=JOptionPane.showInputDialog("Teclee a súa edade");
        int edade=Integer.parseInt(res);
        int edad=Integer.parseInt(JOptionPane.showInputDialog("Teclee a súa edade"));  //lo mismo que arriba pero simplificado y feo :)
        obxCD.consultaEdade(edade);
        obxCD.operarEdade(edade); //condicion dobre con operando

        
        
        
    
    
    
    
    
    
    }
    
}
