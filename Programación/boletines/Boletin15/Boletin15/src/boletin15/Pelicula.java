/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin15;

/**
 *
 * @author nicol
 */
public class Pelicula extends Multimedia{
    private String actorPrincipal;
    private String actrizPrincipal;
    
    public Pelicula(){}
    
    public Pelicula(String tit, String aut, String form, String dur, String am, String af){
    super(tit,aut,form,dur);
    actorPrincipal=am;
    actrizPrincipal=af;
    }
    
    //Setters y Getters
    
    public void setActor(String am){
    actorPrincipal=am;
    }
    
    public String getActor(){
        return actorPrincipal;
    }
        
    public void setActriz(String af){
    actrizPrincipal=af;
    }
    
    public String getActriz(){
        return actrizPrincipal;
    }
    

    @Override
    public String toString() {
        return super.toString() + ", actorPrincipal: " + actorPrincipal + ", actrizPrincipal: " + actrizPrincipal;
    }
        
        
        
}
