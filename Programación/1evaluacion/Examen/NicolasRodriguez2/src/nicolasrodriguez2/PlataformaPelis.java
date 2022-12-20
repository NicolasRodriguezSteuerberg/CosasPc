/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nicolasrodriguez2;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class PlataformaPelis {
    private Peliculas pli;
    
    public PlataformaPelis(Peliculas pli){
        this.pli = pli;
        pli.setPrezo(Float.parseFloat(JOptionPane.showInputDialog("Teclee o novo prezo")));
    }
    
    
   
    public void visualizar(){
        System.out.println(pli.toString());
    }
    
    public void rebaixa(){
        float rebaixa = Float.parseFloat(JOptionPane.showInputDialog("Teclee a rebaixa a realizar"));
        float prezo = pli.getPrezo();
        prezo = prezo - (prezo*rebaixa/100);
        System.out.println("O novo prezo é de " + prezo + "\n");
    }

}
