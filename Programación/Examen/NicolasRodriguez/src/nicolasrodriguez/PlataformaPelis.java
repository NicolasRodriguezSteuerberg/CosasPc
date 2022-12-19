/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nicolasrodriguez;

import javax.swing.JOptionPane;

/**
 *
 * @author NicolasRodriguezSteuerberg
 */
public class PlataformaPelis extends Pelicula{

    //constructor PlataformaPelis con los parametros de pelicula
    public PlataformaPelis(String titulo, float prezo){
        super.Pelicula(titulo = JOptionPane.showInputDialog("Teclee o título"), prezo =Float.parseFloat(JOptionPane.showInputDialog("Teclee el prezo")));
    }
    
    //metodos
    public void visualizar(){
        System.out.println(super.toString());
    }
    
    public void rebaixa(){
        float rebaixa = Float.parseFloat(JOptionPane.showInputDialog("Teclee a rebaixa a realizar"));
        float prezo = super.getPrezo();
        prezo = prezo - (prezo*rebaixa/100);
        System.out.println("O novo prezo é de " + prezo + "\n");
    }
    
    
}
