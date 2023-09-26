/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
    
    int tamaño;
    
    int bytesTotais;
    
    public void escritura(String ruta){
        FileOutputStream esc = null;
        BufferedOutputStream bufEsc = null;
        DataOutputStream dataEsc = null;
        try {
            esc = new FileOutputStream(ruta);
            bufEsc = new BufferedOutputStream(esc);
            dataEsc = new DataOutputStream(bufEsc);
            
            String cadea = "Está en casa";
            tamaño = cadea.length();
            
            escrituraUTF(dataEsc, cadea);
            escrituraChars(dataEsc, cadea);
            escrituraUTF(dataEsc, cadea);
            
            bytesTotais = dataEsc.size();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al escribir");
        }finally{
            try {
                dataEsc.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar escritura");
            }
        }
    }
    
    public void escrituraUTF(DataOutputStream dataEsc, String cadea){
        System.out.println("writeUTF escribindo: " + cadea);
        try {
            dataEsc.writeUTF(cadea);
            System.out.println("bytes totais escritos: " + dataEsc.size());
        } catch (IOException ex) {
            System.out.println("Error escrituraUTF");
        }
    }
    
    public void escrituraChars(DataOutputStream dataEsc, String cadea){
        System.out.println("writeChars escribindo: " + cadea);
        try {
            dataEsc.writeChars(cadea);
            System.out.println("bytes totais escritos: " + dataEsc.size());
        } catch (IOException ex) {
            System.out.println("Error escrituraUTF");
        }
    }
    
    public void leer(String ruta){
        FileInputStream lec = null;
        BufferedInputStream bufLec = null;
        DataInputStream dataLec = null;
        try {
            lec = new FileInputStream(ruta);
            bufLec = new BufferedInputStream(lec);
            dataLec = new DataInputStream(bufLec);
            
            System.out.println("Bytes totais por ler = " + dataLec.available());
            
            lecturaUTF(dataLec, "primeira");
            lecturaChars(dataLec);
            lecturaUTF(dataLec, "terceira");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Fallo lectura");
        } catch (IOException ex) {
            System.out.println("Error lectura");
        }finally{
            try {
                dataLec.close();
            } catch (IOException ex) {
                System.out.println("Fallo cerrar lectura");
            }
        }
    }
    
    public void lecturaUTF(DataInputStream dataLec, String numero){
        System.out.print("lemos a " + numero + " cadea mediante readUTF: ");
        try {
            
            int c  = dataLec.available();
            
            while(dataLec.available() > (c-tamaño)){
                System.out.println(dataLec.readUTF());
            }
            System.out.println("numero de bytes por ler: " + dataLec.available());
        } catch (IOException ex) {
            System.out.println("Error lectura UTF");
        }
    }
    
    public void lecturaChars(DataInputStream dataLec){
        System.out.print("lemos a segunda cadea con readChar() en bucle: ");
        
        try {
            int c = dataLec.available();
            int i;
        
            while((i = dataLec.available()) > (c-tamaño)){
                for (int j = 0; j < tamaño; j++) {
                    System.out.print(dataLec.readChar());
                }
                System.out.println("\nnumero de bytes por ler: " + dataLec.available());
            }
        } catch (IOException ex) {
            System.out.println("Error lectura chars");
        }
    }
}
