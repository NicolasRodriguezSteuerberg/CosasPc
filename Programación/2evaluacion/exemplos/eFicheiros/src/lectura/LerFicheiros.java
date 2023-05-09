package lectura;

import eficheiros.Alumno;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author NSteuerberg
 */
public class LerFicheiros {
    Scanner obxSc;
    
    //Leelo por palabras
    public void lerPalabras(File ficheiro, String del){
        try {
            obxSc = new Scanner(ficheiro).useDelimiter("\\s*" + del + "\\s*");
            while(obxSc.hasNext()){
                String dato = obxSc.next();
                System.out.println(dato);
            }
        }catch (FileNotFoundException ex) {
            System.out.println("erro 1 " + ex.getMessage());
        }
        finally{
            obxSc.close();
        }
    }
    
    //Leerlo por liñas
    public void lerLiñas(File ficheiro){
        try {
            obxSc = new Scanner(ficheiro);
            while(obxSc.hasNextLine()){
                String dato = obxSc.nextLine();
                System.out.println(dato);
            }
        }catch (FileNotFoundException ex) {
            System.out.println("erro 2 " + ex.getMessage());
        }
        finally{
            obxSc.close();
        }
    }
    
    //arrayList
    public ArrayList<Integer> lerNumero(File ficheiro){
        int num;
        //int aux;
        ArrayList<Integer>lista=new ArrayList<>();
        try{
            obxSc = new Scanner(ficheiro);
            while(obxSc.hasNext()){
                num=obxSc.nextInt();
                //aux = Integer.parseInt(num);
                lista.add(num);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("error leer numero"+ex.getMessage());
        }
        finally{
                obxSc.close();
        }
       
        for(Integer ele:lista){
            System.out.println(ele);
        }
       
        return lista;
    }
    
    public ArrayList<Integer> lerNumeroDelimitadores(File ficheiro){
        int num;
        //int aux;
        ArrayList<Integer>lista=new ArrayList<>();
        try{
            obxSc = new Scanner(ficheiro).useDelimiter(",");
            while(obxSc.hasNext()){
                num=obxSc.nextInt();
                //aux = Integer.parseInt(num);
                lista.add(num);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("error leer numero"+ex.getMessage());
        }
        finally{
                obxSc.close();
        }
       
        for(Integer ele:lista){
            System.out.println(ele);
        }
       
        return lista;
    }
    
    public void lerObxecto(File ficheiro){
        ArrayList<Alumno> lista = new ArrayList();
        String []aux = new String[2];
        try{
            obxSc = new Scanner(ficheiro);
            while(obxSc.hasNextLine()){
                aux = obxSc.nextLine().split(", ");
                lista.add(new Alumno(aux[0], Integer.parseInt(aux[1])));
            }
        }catch (FileNotFoundException ex){
            System.out.println("non se pode ler do ficheiro");
        }finally{
            obxSc.close();
        }
        for(Alumno al:lista){
            System.out.println(al);
        }
            
    }
    
    public void lerBuffer(File ficheiro){
        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(ficheiro));
            String linea;
            linea = bf.readLine();
            while(linea!=null){
                System.out.println(linea);
                linea=bf.readLine();
            }
        }catch(FileNotFoundException ex){
            System.out.println("Erro lectura buffer: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro lectura: " + ex.getMessage());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        JOptionPane.showMessageDialog(null, "Este es un mensaje");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    //3º xeito
}
