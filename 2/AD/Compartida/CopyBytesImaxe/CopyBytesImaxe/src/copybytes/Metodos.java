/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copybytes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
    
    public void leerEscribirBuffer(String rutaLeer, String rutaEscribir,boolean falso_verdadero){
        System.out.println(falso_verdadero);
        try {
            FileInputStream lectura = new FileInputStream(rutaLeer);
            BufferedInputStream lecBuf = new BufferedInputStream(lectura);
            
            //FileOutputStream escritura = new FileOutputStream(JOptionPane.showInputDialog("Teclee la ruta a pegar"));
            FileOutputStream escritura = new FileOutputStream(rutaEscribir, falso_verdadero);
            BufferedOutputStream escBuf = new BufferedOutputStream(escritura);
            
            int bytes2;
            
            while((bytes2 = lecBuf.read()) != -1){
                escBuf.write(bytes2);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopyBytes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopyBytes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
