/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matriz;

import com.nicosteuerberg.datos.PedirDatos;

/**
 *
 * @author dam1
 */
public class Metodos {
    int filas;
    int columnas;
    int [][] notas;
    float[] media;
    float[] mediaAs;
    String[] nomes ={"1º alumno","2º alumno"};
    public int[][] crearMatriz(){
        filas = PedirDatos.getInt("Teclee el numero de filas");
        columnas = PedirDatos.getInt("Teclee el numero de columnas");
        notas = new int [filas][columnas];
        for (int i = 0; i < notas.length; i++){ //tamen i < filas
            for (int j = 0; j < notas[i].length; j++) {
                //notas[i][j] = PedirDatos.getInt("Teclee a nota de la fila " + (i+1) + " en la columna " + (j+1));
                notas[i][j] = (int) (Math.random()*10);   //notas del 11 (no incluido) al 0(incluido)
                //notas[i][j] = (int) (Math.random()*(11-1)+1);  //notas del 10 al 1 (incluidos)
            }
        }
        return notas;
    }
    
    public void verMatriz(int [][] notas, float[] media, float[] mediaAs){
        System.out.print("Las notas son:\n\t\t");
        for (int k = 0; k < columnas; k++){
            System.out.print(PedirDatos.getString("Teclee o " + (k+1) + "º modulo"));
            if(k < (columnas-1)){
                System.out.print("    ");
            }
            else{
                System.out.print("   ");
            }
        }
        System.out.println(" Media Alumno");
        for (int i = 0; i < notas.length; i++){
            System.out.print("   " + nomes[i] + " | ");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print("  " + notas[i][j] + "   ");                
            }
            System.out.print("|     " + media[i]);
            System.out.println("     |");
        }
        System.out.print("Media módulo |  ");
        for (int i = 0; i < mediaAs.length; i++) {
            System.out.print(mediaAs[i]);
            if(i < (mediaAs.length-1)){
                System.out.print("   ");
            }
        }
        System.out.println("  |");
    }
    
    public float[] crearMediaAlumno(int [][] notas){
        media = new float [filas];
        int suma = 0;
        for (int i = 0; i < filas; i++) {
            suma=0;
            for (int j = 0; j < columnas; j++) {
                suma = suma + notas[i][j];                
            }
            float median = (float)suma/columnas;
            media[i] = (float) (Math.round(median * 100d)/100d);
        }
        return media;
    }
    public float[] crearMediaAsignatura(int [][] notas){
        mediaAs = new float [columnas];
        int suma = 0;
        for (int i = 0; i < columnas; i++) {
            suma = 0;
            for (int j = 0; j < filas; j++) {
                suma = suma + notas[j][i];
            }
            float median = (float) suma/filas;
            mediaAs[i] = (float) (Math.round(median * 100d)/100d);        
        }
        return mediaAs;
    }
    
    public void ordenar(int[][] notas, float []media){
        int aux = 0;
        float aux2 = 0;
        String auxN = "";
        
        for (int i = 0; i < notas.length-1; i++) {
            for (int j = i+1; j < media.length; j++) {
                if(media[i]<media[j]){
                    aux2 = media[i];
                    media[i] = media[j];
                    media[j] = aux2;
                    auxN = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = auxN;
                    
                    for(int k = 0; k<notas[i].length; k++){
                        aux = notas[i][k];
                        notas[i][k] = notas[j][k];
                        notas[j][k] = aux;
                    }
                }
                
            }
            
        }
    }
}
