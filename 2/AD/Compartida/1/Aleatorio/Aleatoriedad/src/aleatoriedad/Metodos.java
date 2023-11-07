/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aleatoriedad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
        
    public void escrituraLectura(String[] codes, String[] descricion, int[] prices, String path, int numero){
        try {
            RandomAccessFile raf = null;
            raf = new RandomAccessFile(new File(path), "rw");
            String cod = null;
            String desc = null;
            int prezo = 0;
            for (int i = 0; i < codes.length; i++) {
                cod = String.format("%" + 3 + "s", codes[i]);
                desc = String.format("%" + 10 + "s", descricion[i]);
                
                raf.writeChars(cod);
                raf.writeChars(desc);
                raf.writeInt(prices[i]);
            }
            
            int posicion = (numero-1)*30;
            raf.seek(posicion);
            
            String cadena = "";
            
            for (int i = posicion; i < (posicion + 3); i++) {
                cadena += raf.readChar();
            }
            posicion+=3;
            System.out.println(cadena.trim());
            
            cadena = "";
            for (int i = posicion; i < (posicion + 10); i++) {
                cadena += raf.readChar();
            }
            
            posicion+=10;
            System.out.println(cadena.trim());
            
            System.out.println(raf.readInt());
            
        
        } catch (FileNotFoundException ex) {
            System.out.println("Error random");
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
