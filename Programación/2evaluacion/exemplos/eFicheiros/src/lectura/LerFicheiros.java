package lectura;

import eficheiros.Alumno;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author NSteuerberg
 */
public class LerFicheiros {
    Scanner sc;
    
    //Leelo por palabras
    public void lerPalabras(File ficheiro, String del){
        try {
            sc = new Scanner(ficheiro).useDelimiter("\\s*" + del + "\\s*");
            while(sc.hasNext()){
                String dato = sc.next();
                System.out.println(dato);
            }
        }catch (FileNotFoundException ex) {
            System.out.println("erro 1 " + ex.getMessage());
        }
        finally{
            sc.close();
        }
    }
    
    //Leerlo por liñas
    public void lerLiñas(File ficheiro){
        try {
            sc = new Scanner(ficheiro);
            while(sc.hasNextLine()){
                String dato = sc.nextLine();
                System.out.println(dato);
            }
        }catch (FileNotFoundException ex) {
            System.out.println("erro 2 " + ex.getMessage());
        }
        finally{
            sc.close();
        }
    }
    
    //arrayList
    public ArrayList<Integer> lerNumero(File ficheiro){
        int num;
        //int aux;
        ArrayList<Integer>lista=new ArrayList<>();
        try{
            sc = new Scanner(ficheiro);
            while(sc.hasNext()){
                num=sc.nextInt();
                //aux = Integer.parseInt(num);
                lista.add(num);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("error leer numero"+ex.getMessage());
        }
        finally{
                sc.close();
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
            sc = new Scanner(ficheiro).useDelimiter(",");
            while(sc.hasNext()){
                num=sc.nextInt();
                //aux = Integer.parseInt(num);
                lista.add(num);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("error leer numero"+ex.getMessage());
        }
        finally{
                sc.close();
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
            sc = new Scanner(ficheiro);
            while(sc.hasNextLine()){
                aux = sc.nextLine().split(", ");
                lista.add(new Alumno(aux[0], Integer.parseInt(aux[1])));
            }
        }catch (FileNotFoundException ex){
            System.out.println("non se pode ler do ficheiro");
        }finally{
            sc.close();
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
    }
    
    
    //3º xeito
}
