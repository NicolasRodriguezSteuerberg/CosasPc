/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivos;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author postgres
 */
public class Metodos {
    
    public void eDirectorio(String cadea){
        File fichero = new File(cadea);
        if(fichero.isDirectory()){
            JOptionPane.showMessageDialog(null, "es un directorio");
        }else{
            JOptionPane.showMessageDialog(null, "no es un directorio");
        }
    }
    
    public void eFicheiro(String cadea){
        File fichero = new File(cadea);
        if(fichero.isFile()){
            JOptionPane.showMessageDialog(null, "es un ficheiro");
        }else{
            JOptionPane.showMessageDialog(null, "no es un ficheiro");
        }
    }
    
    public void crearDirectorio(String nome){
        File fichero = new File(nome);
        if(!fichero.isDirectory()){
            fichero.mkdir();
            JOptionPane.showMessageDialog(null, "Creado");
        }
        else{
            JOptionPane.showMessageDialog(null, "Xa existia o directorio");
        }
    }
    
    public void crearFichero(String cadea, String nome){
        File existe = new File(cadea);
        File fichero = new File(cadea + "/" + nome);
        if(existe.isDirectory()){
            if(!fichero.isFile()){
                try {
                    fichero.createNewFile();
                    JOptionPane.showMessageDialog(null, "Creado");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Xa existia o ficheiro");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe a dirección");
        }
    }
    
    public void modoAcceso(String nome){
        File fichero = new File(nome);
        
        String cadena;
        
        if(fichero.canRead()){
           cadena = "Puede leer";
        }else{
            cadena = "No puede leer";
        }
        
        if(fichero.canWrite()){
            cadena = cadena + "\nPuede escribir";
        }else{
            cadena = cadena + "\nNo puede escribir";
        }
        
        JOptionPane.showMessageDialog(null, cadena);
    }
    
    public void calculaLonxitude(String nome){
        File fichero = new File(nome);
        if(fichero.exists()){
            JOptionPane.showMessageDialog(null, "O archivo pesa: " + fichero.length());
        }else{
            JOptionPane.showMessageDialog(null, "Non existe o archivo");
        }
    }
    
    public void mLectura(String cadea){
        File fichero = new File(cadea);
        if(fichero.exists()){
            fichero.setReadOnly();
            JOptionPane.showMessageDialog(null, "Pode ler? " + fichero.canRead() + "\nPode escribir? " + fichero.canWrite());
        }else{
            JOptionPane.showMessageDialog(null, "Non existe o archivo");
        }
    }
    
    public void mEscritura(String cadea){
        File fichero = new File(cadea);
        if(fichero.exists()){
            fichero.setWritable(true);
            JOptionPane.showMessageDialog(null, "Pode ler? " + fichero.canRead() + "\nPode escribir? " + fichero.canWrite());
        }else{
            JOptionPane.showMessageDialog(null, "Non existe o archivo");
        }
    }
    
    public void borraFicheiro(String cadea){
        File fichero = new File(cadea);
        if(fichero.isFile()){
            fichero.delete();
            JOptionPane.showMessageDialog(null, "Ficheiro eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Non existe o ficheiro");
        }
    }
    
    public void borraDirectorio(String cadea){
        File fichero = new File(cadea);
        if(fichero.isDirectory()){
            fichero.delete();
            JOptionPane.showMessageDialog(null, "Directorio eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Non existe o directorio ou ten descendencia");
        }  
    }
    
    public void mContido(String cadea){
        File fichero = new File(cadea);
        if(fichero.isDirectory()){
            JOptionPane.showMessageDialog(null, fichero.list());
        }else{
            JOptionPane.showMessageDialog(null, "Non existe o ficheiro");
        }
    }
    
    public void recur(){
        
    }
    
}
