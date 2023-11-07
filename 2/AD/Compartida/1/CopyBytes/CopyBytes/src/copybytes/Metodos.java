/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copybytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author postgres
 */
public class Metodos {
    
    
    public byte[] lerFichero(String path){
        File fichero = new File(path);
        FileInputStream reader = null;
        byte bytes[] = null;
        try {
            reader = new FileInputStream(path);
            bytes = new byte[(int) fichero.length()];
            reader.read(bytes);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error en la lectura");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error lectura 2");
        }finally{
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar reader");
            }
        }
        return bytes;
    }
    
    public void escribirFicheiro(String ruta, byte bytes[]){
        File fichero = new File(ruta);
        if(!fichero.isFile()){
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error creacion fichero");
            }
        }
        FileOutputStream outputStream = null;
        try {
             outputStream = new FileOutputStream(fichero);
            outputStream.write(bytes);
        } catch (FileNotFoundException ex) {
            System.out.println("Error outputStream");
        } catch (IOException ex) {
            System.out.println("Error escritura");
        } finally{
            try {
                outputStream.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar output");
            }
        }
    }
    
    public void escribirFicheiroSenSobreescribir(String ruta, byte bytes[]){
        File fichero = new File(ruta);
        if(!fichero.isFile()){
            try {
                fichero.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error creacion fichero");
            }
        }
        FileOutputStream outputStream = null;
        try {
             outputStream = new FileOutputStream(fichero,true);
            outputStream.write(bytes);
        } catch (FileNotFoundException ex) {
            System.out.println("Error outputStream");
        } catch (IOException ex) {
            System.out.println("Error escritura");
        } finally{
            try {
                outputStream.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar output");
            }
        }
    }
    
    public void leerEscribir(String rutaLeer, String rutaEscribir,boolean falso_verdadero){
        System.out.println(falso_verdadero);
        try {
            FileInputStream lectura = new FileInputStream(rutaLeer);
            
            //FileOutputStream escritura = new FileOutputStream(JOptionPane.showInputDialog("Teclee la ruta a pegar"));
            FileOutputStream escritura = new FileOutputStream(rutaEscribir, falso_verdadero);
            
            int bytes2;
            
            while((bytes2 = lectura.read()) != -1){
                escritura.write(bytes2);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopyBytes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopyBytes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
