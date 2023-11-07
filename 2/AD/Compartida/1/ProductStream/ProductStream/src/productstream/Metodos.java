package productstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Metodos {
    
    public void escritura(String ruta, ArrayList<Product> lista){
        FileOutputStream esc = null;
        BufferedOutputStream bufEsc = null;
        DataOutputStream dataEsc = null;
        try {
            esc = new FileOutputStream(ruta);
            bufEsc = new BufferedOutputStream(esc);
            dataEsc = new DataOutputStream(bufEsc);
            
            for(Product e:lista){
                dataEsc.writeUTF(e.getCodigo());
                dataEsc.writeUTF(e.getDescripcion());
                dataEsc.writeDouble(e.getPrezo());
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error al escribir");
        } catch (IOException ex) {
            System.out.println("Error escritura");
        }finally{
            try {
                dataEsc.close();
            } catch (IOException ex) {
                System.out.println("Error cerrar escritura");
            }
        }
    }
    
    public void lectura(String ruta){
        FileInputStream lec = null;
        BufferedInputStream bufLec = null;
        DataInputStream dataLec = null;
        try {
            lec = new FileInputStream(ruta);
            bufLec = new BufferedInputStream(lec);
            dataLec = new DataInputStream(bufLec);
            
            Product obx = new Product();
            
            
            while(dataLec.available()!=0){
                obx.setCodigo(dataLec.readUTF());
                obx.setDescripcion(dataLec.readUTF());
                obx.setPrezo(dataLec.readDouble());
                System.out.println(obx.toString());
            }
            
        } catch (IOException ex) {
            System.out.println("Error lectura UTF");
        } finally{
            try {
                dataLec.close();
            } catch (IOException ex) {
                System.out.println("Fallo cerrar lectura");
            }
        }
    }
    
}
