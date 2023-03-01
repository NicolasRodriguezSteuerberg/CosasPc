package boletin27;

import boletin27.ClasesObx.Libros;
import com.nicosteuerberg.datos.PedirDatos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class metodos {
    FileWriter obxWriter = null;
    PrintWriter obxPrint = null;
    
    public ArrayList<Libros> crearArray(){
        ArrayList <Libros>lista = new ArrayList();
        return lista;
    }
    
    public void engadir(File e, ArrayList<Libros> lista,int nEngadir){
        int i = 0;
        
        while(i < nEngadir){
            try{
                int y= 0;
                String nombre;
                do{
                    nombre = PedirDatos.getString("Teclee o titulo do " + (i+1) + " libro");
                    for(int z = 0; z < lista.size(); z++){
                        if(lista.get(z).g){
                            
                        }
                    }
                }while(y == 1);
                
                String autor = PedirDatos.getString("Teclee o autor do " + (i+1) + " libro");
                float precio = PedirDatos.getFloat("Teclee o precio do " + (i+1) + " libro");
                int unidades = PedirDatos.getInt("Teclee as unidades a haber no libro: " + nombre);
                lista.add(new Libros(nombre, autor, precio, unidades));
                
                obxWriter = new FileWriter(e,true);
                obxPrint = new PrintWriter(obxWriter);
                obxPrint.println(lista.);
                
            }catch (IOException ex){
                System.out.println("Error ao engadir: " + ex.getMessage());
            }catch (Exception t){
                System.out.println("Error ao escribir os datos: " + t.getMessage());
            }
            finally{
                    obxPrint.close();
            }
            
        }
        
    }
    
    
    
    
}
