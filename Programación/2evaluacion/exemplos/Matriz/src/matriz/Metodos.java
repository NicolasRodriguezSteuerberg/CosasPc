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
    public int[][] crearMatriz(){
        filas = PedirDatos.getInt("Teclee el numero de filas");
        columnas = PedirDatos.getInt("Teclee el numero de columnas");
        notas = new int [filas][columnas];
        for (int i = 0; i < notas.length; i++){ //tamen i < filas
            for (int j = 0; j < notas[i].length; j++) {
                //notas[i][j] = PedirDatos.getInt("Teclee a nota de la fila " + (i+1) + " en la columna " + (j+1));
                notas[i][j] = (int) (Math.random()*11);   //notas del 11 (no incluido) al 0(incluido)
                //notas[i][j] = (int) (Math.random()*(11-1)+1);  //notas del 10 al 1 (incluidos)
            }
        }
        return notas;
    }
    
    public void verMatriz(int [][] notas, float[] media, float[] mediaAs){
        System.out.println("Las notas son:");
        for (int i = 0; i < notas.length; i++){
            System.out.print((i+1) + "º alumno | ");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print(notas[i][j] + " ");                
            }
            System.out.print("| " + media[i]);
            System.out.println(" |");
        }
        System.out.print("          |");
        for (int i = 0; i < mediaAs.length; i++) {
            System.out.print(mediaAs[i] + " ");
        }
        System.out.println("|");
    }
    
    public float[] crearMediaAlumno(int [][] notas){
        media = new float [notas.length];
        for (int i = 0; i < notas.length; i++) {
            int suma=0;
            for (int j = 0; j < notas[i].length; j++) {
                suma = suma + notas[i][j];                
            }
            float median = (float)suma/notas[i].length;
            media[i] = (float) (Math.round(median * 100d)/100d);
        }
        return media;
    }
    public float[] crearMediaAsignatura(int [][] notas){
        mediaAs = new float [columnas];
        int suma = 0;
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < notas.length; j++) {
                suma = suma + notas[j][i];
            }
            float median = (float) suma/filas;
            mediaAs[i] = (float) (Math.round(median * 100d)/100d);        
        }
        return media;
    }
}
