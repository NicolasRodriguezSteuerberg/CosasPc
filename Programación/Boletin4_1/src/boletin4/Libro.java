/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin4;
import javax.swing.JOptionPane;
/**
 *
 * @author dam1
 */
public class Libro {
    //Instanciamos os valores co seu tipo
    public String titulo, autor;
    public int ano;
    public short numPaginas;
    public float valoracion=4.9f;
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
    
    //defino el método amosar
    public void amosar(String tit, String aut, int an, short numP){
        String name = JOptionPane.showInputDialog("Escribe la contraseña");
	JOptionPane.showMessageDialog(null, "Contraseña correcta");
        JOptionPane.showMessageDialog(null, "Título: "+titulo);
        JOptionPane.showMessageDialog(null, "Autor: "+autor);
        JOptionPane.showMessageDialog(null, "Ano: "+ano);
        JOptionPane.showMessageDialog(null, "Número de páginas: "+numPaginas);
        JOptionPane.showMessageDialog(null, "Valoracion: "+valoracion);

}


    
}

