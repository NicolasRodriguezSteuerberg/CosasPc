/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin4;

/**
 *
 * @author dam1
 */
public class Libro {
    //Instanciamos os valores co seu tipo
    private String titulo, autor;
    private int ano;
    private short numPaginas;
    private float valoracion;
    //Creo o constructor por defecto
    public Libro(){
    }
    //constructores para inicializar titulo, autor, ano e numPaxinas
    public Libro(String tit, String aut, int an, short numP){
        titulo=tit;
        autor=aut;
        ano=an;
        numPaginas=numP;
        
    }
    public void setTit(String tit){
        titulo=tit;
    }
    public String getTit(){
        return titulo;
    }
    
    public void setAut(String aut){
        autor=aut;
    }
    public String getAut(){
        return autor;
    }
    
    public void setAn(int an){
        ano=an;
    }
    public int getAn(){
        return ano;
    }
    
    public void setNumPaginas(short numP){
        numPaginas=numP;
    }
    public short getNumP(){
        return numPaginas;
    }
    public void setValoracion(float val){
        valoracion=val;
    }
    public float getValoracion(){
        return valoracion;
    }
    
    //defino el método amosar
    public void amosar(String tit, String aut, int an, short numP, float valor){
            System.out.println("Título: "+titulo+"\n"
                    + "Autor: "+autor+"\n"
                    + "Ano: "+ano+"\n"
                    + "Número de páginas: "+numPaginas+"\n"
                    + "Valoracion: "+valoracion);
}


    
}

