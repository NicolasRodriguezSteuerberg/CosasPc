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
    
   private String titulo;
    private float prezo;
    
    
    //constructor por defecto y parametrizado
    public PlataformaPelis(){}
    
    public PlataformaPelis(String titulo, float prezo){
        this.titulo = titulo;
        this.prezo = prezo;
    }
    
    
    //metodos (set/get/toString)
    public void setPrezo(float prezo){
        this.prezo = prezo;
    }
    
    public float getPrezo(){
        return prezo;
    }
    
    public void visualizar(){
        System.out.println(toString());
    }
    
    public void rebaixa(){
        float rebaixa = Float.parseFloat(JOptionPane.showInputDialog("Teclee a rebaixa a realizar"));
        prezo = prezo - (prezo*rebaixa/100);
        System.out.println("O novo prezo é de " + prezo + "\n");
    }

    @Override
    public String toString() {
        return "titulo=" + titulo + "\t" + " prezo=" + prezo;
    }
    
}
