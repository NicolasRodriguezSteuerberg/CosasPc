/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin22;

/**
 *
 * @author dam1
 */
public class Metodos {
    int filas = 20;
    int columnas = 36;
    int [][]goles;
    int []xornadas = new int[36];//15
    String []equipos = {"      Barcelona", "    Real Madrid", "Atlético Madrid", "  Real Sociedad", "      Villareal", "          Betis", "        Osasuna", "       Athletic", " Rayo Vallecano", " R.C.D Mallorca", "        Almería", "         Girona", "        Sevilla", "  Valencia C.F.", "   RCD Espanyol", "  Celta de Vigo", "     Valladolid", "          Cádiz", "         Getafe", "      Elche C.F"};
    
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
        int[][] auxGoles = new int [1][36];
        int[] sumaGoles = new int[filas];
        
        //conseguir a suma dos goles para poder ordenar
        for(int i = 0; i < filas; i++){
            int suma = 0;
            for(int j = 0; j < columnas; j++){
                suma = suma + goles[i][j];
            }
            sumaGoles[i] = suma;
            System.out.println(equipos[i] + " " + sumaGoles[i]);
        }
        
        //ordenar
        for(int i = 0; i < filas-1; i++){
            for(int j = i+1; j < filas; j++){
                if(sumaGoles[i] > sumaGoles[j]){
                    auxEquipos = equipos[i];
                    equipos[i] = equipos[j];
                    equipos[j] = auxEquipos;
                    for (int k = 0; k < columnas; k++){
                        auxGoles[0][k] = goles[i][k];
                        goles[i][k] = goles[j][k];
                        goles[j][k] = auxGoles[0][k];
                    }
                }
                
            }
        }
        System.out.println("\nTabla ordenada\n");
    }
}
