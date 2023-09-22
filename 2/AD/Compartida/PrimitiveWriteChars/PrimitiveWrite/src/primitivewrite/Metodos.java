/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivewrite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author postgres
 */
public class Metodos {
    int tamaño;
    public void escribir(String ruta){
        FileOutputStream esc = null;
        BufferedOutputStream bufEsc = null;
        DataOutputStream dataEsc = null;
        try {
            esc = new FileOutputStream(ruta,false);
            bufEsc = new BufferedOutputStream(esc);
            dataEsc = new DataOutputStream(bufEsc);
            
            String cadea ="o tempo está xélido";

            for (int i = 0; i < 2; i++) {
                dataEsc.writeChars("o tempo está xélido");
                System.out.println("escribindo: " + cadea);
                tamaño=cadea.length();
                System.out.println("a lonxitude desta cadea en caracteres é de: " + tamaño + " caracteres");
                System.out.println("tamaño do ficheiro: " + dataEsc.size());
            }
            System.out.println("Tamaño final do ficheiro: " + dataEsc.size());
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error escritura");
        } catch (IOException ex) {
            System.out.println("Error escritura");
        }finally{
            try {
                dataEsc.close();
            } catch (IOException ex) {
                System.out.println("Error escritura");
            }
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
            
            int c;
            
            while((c=dataLec.available())!=0){
                System.out.println("quedan: " + c + " bytes por ler");
                for (int i = 0; i < tamaño; i++) {
                    System.out.print(dataLec.readChar());
                }
                System.out.println();
            }
            
            System.out.println("Xa non queda nada por ler");
                    
        } catch (FileNotFoundException ex) {
            System.out.println("Error encontrando el archivo");
        } catch (IOException ex) {
            System.out.println("Error lectura");
        }finally{
            try {
                dataLec.close();
            } catch (IOException ex) {
                System.out.println("Error lectura");
            }
        }
        
    }
}
