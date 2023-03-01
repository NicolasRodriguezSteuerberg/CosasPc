package escritura;

import java.io.File;
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
}
