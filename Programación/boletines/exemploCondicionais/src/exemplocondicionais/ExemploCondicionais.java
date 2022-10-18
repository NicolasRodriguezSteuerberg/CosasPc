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
       // CondicionalSimple obxCS=new CondicionalSimple();
       // obxCS.maiorEdade(20);
       // obxCS.maiorEdade(16);
       
       //pedimos datos utilizando JOptionPane
       String resS=JOptionPane.showInputDialog("teclea a edade");
       int res=Integer.parseInt(resS);
       if(res>=18){
           JOptionPane.showMessageDialog(null, "É maior de edade");
       }
       JOptionPane.showMessageDialog(null, "Se acaba o if");
        
    }
    
}
