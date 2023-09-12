/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin22;

import com.nicosteuerberg.datos.PedirDatos;

/**
 *
 * @author dam1
 */
public class Metodos {
    int filas = 20;
    int columnas = 36;
    int [][]goles;
    int []xornadas = new int[columnas];//15
    String []equipos = {"Barcelona      ", "Real Madrid    ", "Atlético Madrid", "Real Sociedad  ", "Villareal      ", "Betis          ", "Osasuna        ", "Athletic       ", "Rayo Vallecano ", "R.C.D Mallorca ", "Almería        ", "Girona         ", "Sevilla        ", "Valencia C.F.  ", "RCD Espanyol   ", "Celta de Vigo  ", "Valladolid     ", "Cádiz          ", "Getafe         ", "Elche C.F      "};
    
    public int[][] crearArrayGoles(){
        goles = new int[filas][columnas];
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                goles[i][j] = (int) (Math.random()*10);
            }
        }
        return goles;
    }
    
    public int[] crearXornadas(){
        for(int i = 0; i < xornadas.length; i++){
            xornadas[i] = (i+1);
        }
        return xornadas;
    }
    
    public void verTabla(int[] xornadas, String[] equipos, int[][] goles){
        //imprimir as xornadas
        System.out.print(" Equipo/xornada |");
        for(int i = 0; i < columnas; i++){
            if(xornadas[i] < 10){
                System.out.print("  x");
            }
            else{
                System.out.print("  x");
            }
            System.out.print(xornadas[i]);
        }
        System.out.println("");
        
        //imprimir nombre de equipos e goles
        for(int i = 0; i < filas; i++){
            System.out.print(equipos[i] + " |   ");
            for(int j = 0; j < columnas; j++){
                System.out.print(goles[i][j]);
                if(j < 9){
                    System.out.print("   ");
                }
                else{
                    System.out.print("    ");
                }
            }
            System.out.println("");
        }
        
    }
    
    public void ordenarTabla(String[] equipos, int[][] goles){
        System.out.println("");
        String auxEquipos;
        int auxGoles;
        int auxSumaGoles;
        int[] sumaGoles = new int[goles.length];
        
        //conseguir a suma dos goles para poder ordenar
        for(int i = 0; i < goles.length; i++){
            int suma = 0;
            for(int j = 0; j < columnas; j++){
                suma = suma + goles[i][j];
            }
            sumaGoles[i] = suma;
            System.out.println(equipos[i] + " " + sumaGoles[i]);
        }
        
        //ordenar
        for(int i = 0; i < goles.length-1; i++){
            for(int j = i+1; j < sumaGoles.length; j++){
                if(sumaGoles[i] > sumaGoles[j]){
                    auxSumaGoles = sumaGoles[i];
                    sumaGoles[i] = sumaGoles[j];
                    sumaGoles[j] = auxSumaGoles;
                    auxEquipos = equipos[i];
                    equipos[i] = equipos[j];
                    equipos[j] = auxEquipos;
                    
                    for (int k = 0; k < goles[i].length; k++){
                        auxGoles = goles[i][k];
                        goles[i][k] = goles[j][k];
                        goles[j][k] = auxGoles;
                    }
                }
                
            }
        }
        System.out.println("\nTabla ordenada\n");
    }
    
    public void verMaximoGoleadorXornada(String[] equipos, int[] xornadas, int[][] goles){
        int nGoles = 0;
        System.out.println("");
        for (int i = 0; i < xornadas.length; i++){
            for (int j = 0; j < goles.length; j++){
                if(goles[j][i] > nGoles){
                    nGoles = goles[j][i];
                }
            }
            System.out.println("Na xornada x" + xornadas[i] + " o goles máximos fueron " + nGoles + " e os marcaron:");
            for (int k = 0; k < goles.length; k++){
                if(goles[k][i] == nGoles){
                    System.out.println(equipos[k]);
                }
            }
            nGoles = 0;
        }
    }
    
    public void verEquipoMaxGolesPorXornada(String []equipos, int[] xornadas, int[][] goles){
        int xornadaBuscar = PedirDatos.getInt("Teclee a xornada a buscar que equipo marcou máis goles");
    }
    
    
    
    
    
    public void verEquipoXornadaPorGoles(String[] equipos, int[] xornadas, int[][] goles){
        int atopado = 0;
        int numGoles = PedirDatos.getInt("Teclee el nº goles a buscar");
        System.out.println("i");
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                if(numGoles == goles[i][j]){
                    System.out.println("Los " + numGoles + " los han marcado en la x" + xornadas[j] + " y fue el " + equipos[i]);
                    atopado = 1;
                }
            }
        }
        if(atopado == 0){
            System.out.println("Nadie marco esa cantidad de goles");
        }
    }
}
