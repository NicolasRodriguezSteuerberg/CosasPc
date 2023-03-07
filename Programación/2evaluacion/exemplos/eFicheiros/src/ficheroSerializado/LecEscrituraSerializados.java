/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheroSerializado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author dam1
 */
public class LecEscrituraSerializados {
    ObjectInputStream lec = null;
    ObjectOutputStream esc = null;
    
    
    public void escribirSeri(File fich){
        try{
            esc = new ObjectOutputStream(new FileOutputStream(fich));
            AlumnadoSerializado al1 = new AlumnadoSerializado ("aa",5);
            AlumnadoSerializado al2 = new AlumnadoSerializado ("bb",6);
            AlumnadoSerializado al3 = new AlumnadoSerializado ("cc",7);
            
            esc.writeObject(al1);
            esc.writeObject(al2);
            esc.writeObject(al3);
            
        }catch(FileNotFoundException ex){
            System.out.println("Erro 1: " + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Erro 2: " + ex.getMessage());
        }
        finally{
            try {
                esc.close();
            } catch (IOException ex) {
                System.out.println("Erro close: " + ex.getMessage());
            }
        }
    }
    
    public void lerSerializable(File fich){
        AlumnadoSerializado al = null;
        try{
            lec = new ObjectInputStream(new FileInputStream(fich));
            al = (AlumnadoSerializado)lec.readObject();
            while(al!=null){
                System.out.println(al);
                al = (AlumnadoSerializado)lec.readObject();
            }
        }catch (ClassNotFoundException ex) {
            System.out.println("Erro 3: " + ex.getMessage());
        }catch (FileNotFoundException ex) {
            System.out.println("Erro 4: " + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Erro 5: " + ex.getMessage());
        }
        finally{
            try {
                lec.close();
            } catch (IOException ex) {
                System.out.println("close ler: " + ex.getMessage());
            }
        }
        
    }
    
    public void engadirSeri(File fich){
        MeuObjectOutputStream esc = null;
        try{
            esc = new MeuObjectOutputStream(new FileOutputStream(fich,true));
            AlumnadoSerializado al1 = new AlumnadoSerializado ("qq",5);
            AlumnadoSerializado al2 = new AlumnadoSerializado ("ww",6);
            
            esc.writeObject(al1);
            esc.writeObject(al2);
            
        }catch(FileNotFoundException ex){
            System.out.println("Erro 1: " + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Erro 2: " + ex.getMessage());
        }
        finally{
            try {
                esc.close();
            } catch (IOException ex) {
                System.out.println("Erro close: " + ex.getMessage());
            }
        }
    }
}
