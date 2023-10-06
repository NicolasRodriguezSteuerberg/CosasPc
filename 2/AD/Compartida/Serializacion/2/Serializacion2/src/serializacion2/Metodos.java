/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author postgres
 */
public class Metodos {
    
    public void write(String ruta, Product [] obx) throws FileNotFoundException, IOException{
        ObjectOutputStream obxW = null;
        FileOutputStream obxOS = null;
        Product obxN = null;
        
        obxOS = new FileOutputStream(ruta, false);
        obxW = new ObjectOutputStream(obxOS);
        for (int i = 0; i < obx.length; i++) {
            obxW.writeObject(obx[i]);
        }
        obxW.writeObject(obxN);
        
        obxW.close();
        
    }
    
    public void read(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream lec = null;
        Product obx = null;

        lec = new ObjectInputStream(new FileInputStream(ruta));
        
        do{
            obx = (Product) lec.readObject();
            if(obx != null){
                System.out.println(obx.toString());
            }
            else{
                System.out.println("Objeto nulo");
            }
        }while(obx != null);
            
        lec.close();

    }
}
