/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin15;

/**
 *
 * @author dam1
 */
public class Disco extends Multimedia{
    
    //atributos
    private String xenero;
    
    //Constructores
    public Disco(){}
    
    public Disco(String tit, String aut, String form, String dur, String xen){
        super(tit,aut,form,dur);
        xenero = xen;
    }
    
    //metodos set/get
    public void setXenero(String xen){
        xenero = xen;
    }
    
    public String getXenero(){
        return xenero;
    }
    
    //toString

    @Override
    public String toString() {
        return super.toString() + " xenero=" + xenero;
    }
    
}
