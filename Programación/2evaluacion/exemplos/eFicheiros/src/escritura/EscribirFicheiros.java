package escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class EscribirFicheiros {
    
    FileWriter obxWriter = null;
    PrintWriter obxPrint = null;
    
    public void escribir(File f){
        try{
            obxWriter = new FileWriter(f);
            obxPrint = new PrintWriter(obxWriter);
            obxPrint.println("luns");
            obxPrint.println("martes");
            obxPrint.println("mercores");
            obxPrint.println("xoves");
            obxPrint.println("venres");
        }catch (IOException ex){
            System.out.println("Error de escritura: " + ex.getMessage());
        }
        finally{
            obxPrint.close();
        }
    }
    
    public void engadirRexistro(File f){
        try{
            obxWriter = new FileWriter(f, true);
            obxPrint = new PrintWriter(obxWriter);
            obxPrint.println("sabado");
            obxPrint.println("domingo");
        }catch (IOException ex){
            System.out.println("Error de escritura: " + ex.getMessage());
        }
        finally{
            obxPrint.close();
        }
    }
    
    public void escribirBuffer(File ficheiro){
        BufferedWriter bf = null;
        
        try {
            bf = new BufferedWriter(new FileWriter(ficheiro,true));
            bf.write("Hola\n");
            bf.write("que\n");
            bf.write("tal");
        } catch (FileNotFoundException ex) {
            System.out.println("Erro lectura buffer: " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("Erro lectura buffer: " + ex.getMessage());
        }
        finally{
            try {
                bf.close();
            } catch (IOException ex) {
                System.out.println("Erro en cerrar: " + ex.getMessage());
            }
        }
    }
}
