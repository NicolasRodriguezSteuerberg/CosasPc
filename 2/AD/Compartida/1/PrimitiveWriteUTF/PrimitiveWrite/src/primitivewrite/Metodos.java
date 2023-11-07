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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
    
    public void escribir(String ruta){
        FileOutputStream esc = null;
        BufferedOutputStream bufEsc = null;
        DataOutputStream dataEsc = null;
        try {
            esc = new FileOutputStream(ruta,false);
            bufEsc = new BufferedOutputStream(esc);
            dataEsc = new DataOutputStream(bufEsc);
            
            String cadea ="o tempo está xélido";

            for (int i = 0; i < 3; i++) {
                dataEsc.writeUTF("o tempo está xélido");
                System.out.println("escribindo a cadea: " + cadea);
                System.out.println("tamaño do ficheiro: " + dataEsc.size());
            }
            System.out.println("Tamaño final do ficheiro: " + dataEsc.size());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                dataEsc.close();
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println(dataLec.readUTF());
            }
            
            System.out.println("Xa non queda nada por ler");
                    
        } catch (FileNotFoundException ex) {
            System.out.println("Error encontrando el archivo");
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                dataLec.close();
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
