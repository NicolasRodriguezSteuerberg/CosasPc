/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copycaracteres22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
    public void leerEscribir(String rutaEsc, String rutaLec){
        FileWriter esc = null;
        BufferedWriter bufEsc = null;
        PrintWriter printEsc = null;
        FileReader lec = null;
        BufferedReader bufLec = null;
        
        try {
            esc = new FileWriter(rutaEsc);
            printEsc = new PrintWriter(esc);
            
            lec = new FileReader(rutaLec);
            bufLec = new BufferedReader(lec);
            
            String linea;
            while((linea = bufLec.readLine())!=null){
                printEsc.println(linea);
            }
            System.out.println("Escritura terminada");
        } catch (IOException ex) {
            System.out.println("Error");
        }finally{
            try {
                printEsc.close();
                bufLec.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }
}
