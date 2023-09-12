package boletin27;

import boletin27.ClasesObx.Libros;
import com.nicosteuerberg.datos.PedirDatos;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Metodos {
    FileWriter obxWriter = null;
    PrintWriter obxPrint = null;
    Scanner sc;
    
    public void engadir(File e, ArrayList<Libros> lista,int nEngadir){
        int i = 0;
        
        while(i < nEngadir){
            try{
                String nombre;
                nombre = PedirDatos.getString("Teclee o titulo do " + (i+1) + " libro");
                
                if(lista.size()>0){
                    for(int z = 0; z < lista.size(); z++){
                        if(lista.get(z).getNome().equalsIgnoreCase(nombre)){
                            nombre = PedirDatos.getString("O titulo non pode ser igual a uno existente, intentelo de nuevo");
                            z=0;
                        }
                    }
                }
                String autor = PedirDatos.getString("Teclee o autor do " + (i+1) + " libro");
                float precio = PedirDatos.getFloat("Teclee o precio do " + (i+1) + " libro");
                int unidades = PedirDatos.getInt("Teclee as unidades a haber no libro: " + nombre);
                lista.add(new Libros(nombre, autor, precio, unidades));
                
                obxWriter = new FileWriter(e,true);
                obxPrint = new PrintWriter(obxWriter);
                obxPrint.println(lista.get((lista.size()-1)));
                i++;
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
    
    public void consultar(ArrayList<Libros> lista, String nombre){
        int atopar = 0;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getNome().equalsIgnoreCase(nombre)){
                System.out.println("El precio de " + lista.get(i).getNome() + "es de: " + lista.get(i).getPrecio());
                atopar = 1;
            }
        }
        if (atopar==0){
            JOptionPane.showMessageDialog(null, "Libro no encontrado");
        }
    }
    
    public void amosar(File e){
        try {
            sc = new Scanner(e);
            while(sc.hasNext()){
                String dato = sc.nextLine();
                System.out.println(dato);
            }
        }catch (FileNotFoundException ex) {
            System.out.println("erro lectura " + ex.getMessage());
        }
        finally{
            sc.close();
        }
    }
    
    public void borrar(File e,ArrayList<Libros> lista){        
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getUnidades()==0){
                String mod = lista.get(i).toString();
                lista.remove(i);
            }
        }
    }
    
    public void modificarPrecio(File e,ArrayList<Libros> lista, String titulo){
        String antes = null;
        String ahora = null;
        for(int i = 0; i < lista.size(); i++){
            if(titulo.equalsIgnoreCase(lista.get(i).getNome())){
                antes = lista.get(i).toString();
                float precio;
                precio = PedirDatos.getFloat("Precio anterior = " + lista.get(i).getPrecio() + "\nTeclee el nuevo precio");
                lista.get(i).setPrecio(precio);
                ahora = lista.get(i).toString();
                
            }
        }
        modFile(e, antes, ahora, "Erro en modificar precio: ");
    }
    
    public void modFile(File e, String anterior ,String modificacion,String mensaxe){
        try {
            sc = new Scanner(e);
            obxWriter = new FileWriter(e);
            obxPrint = new PrintWriter(obxWriter);
            
            while (sc.hasNext()){
                String linea = sc.nextLine();
                System.out.println(linea);
                if(anterior.equals(linea)){
                    obxPrint.write(modificacion);
                }
                
            }
        } catch (IOException ex) {
            System.out.println(mensaxe + ex.getMessage());
        }
        finally{
            sc.close();
            obxPrint.close();
        }
        
        
    }
}
