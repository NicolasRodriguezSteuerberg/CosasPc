package datos;

import entidades.EContratado;
import entidades.EDestajo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author NSteuerbreg
 */
public class ListaEmpleados {
    
    FileWriter obxWriter = null;
    PrintWriter obxPrint = null;
    
    public void engadirEmpleadoContratado(File f, EContratado e){
        try{
            obxWriter = new FileWriter(f, true);
            obxPrint = new PrintWriter(obxWriter);
            obxPrint.println(e.toString());
        }catch (IOException ex){
            System.out.println("Error de escritura: " + ex.getMessage());
        }
        finally{
            obxPrint.close();
        }
    }
    
    public void engadirEmpleadoContratado(File f, EDestajo e){
        try{
            obxWriter = new FileWriter(f, true);
            obxPrint = new PrintWriter(obxWriter);
            obxPrint.println(e.toString());
        }catch (IOException ex){
            System.out.println("Error de escritura: " + ex.getMessage());
        }
        finally{
            obxPrint.close();
        }
    }
    
}
