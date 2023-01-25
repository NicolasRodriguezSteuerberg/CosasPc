/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin21;

import com.nicosteuerberg.datos.PedirDatos;

/**
 *
 * @author dam1
 */
public class Boletin21_Metodos {
    private int CTE = 5;
    
    public int[] arrayNumeros(){
        int numeros[] = new int[6];
        for (int i = 0; i < numeros.length; i++){
            int num = (int) (Math.random()*50+1);
            for (int j = i; j > 0; j--){
                if(numeros[j] == num){
                    num = (int) (Math.random()*50+1);
                    j = i;
                }
            }
            numeros[i] = num;            
        }
        return numeros;        
    }
    public void amosarArrayNumeros(int numeros[]){
        for(int i = (numeros.length-1); i>=0; i--){
            System.out.println("O numero da " + (i + 1) + "º posicion = " + numeros[i]);
        }
    }
    
    public int[] arrayNotas(){
        int notas[] = new int[CTE];
        for (int i = 0; i < notas.length; i++){
            int num = (int) (Math.random()*10+1);
            notas[i] = num;
        }
        return notas;
    }    
    
    public String[] arrayNombre(){
        String nombres[] = new String[CTE];
        for (int i = 0; i < nombres.length; i++){
            nombres[i] = PedirDatos.getString("Teclee el nombre del " + (i+1) +"º alumno");
        }
        return nombres;
    }
    
    public void amosarNotas(int notas[]){
        int aprobados = 0;
        int suspensos = 0;
        for (int i = 0; i < notas.length; i++){
            if(notas[i] >= 5){
                aprobados++;
            }
            else{
                suspensos++;
            }
        }
        System.out.println("Numeros de aprobados = " + aprobados + "\nNumeros de suspensos = " + suspensos);
    }
    
    public void amosarNotaMedia(int notas[]){
        int suma = 0;
        for (int i = 0; i < notas.length; i++){
            suma = suma + notas[i];
        }
        float media = (float) suma/(notas.length);
        System.out.println("La nota media es de: " + media);
    }
    
    public void amosarNotaAlta(int notas[]){
        int notaAlta = 0;
        int acumulador = 1;
        for (int i = 0; i < notas.length; i++){
            if(notaAlta < notas[i]){
                notaAlta = notas[i];
            }
           
        }
        System.out.println("A nota máis alta é " + notaAlta);
    }
    
    public void amosarNotaDeterminada(String nombres[], int notas[]){
        String nombreAlum = PedirDatos.getString("Teclee o alumno a ver");
        int num = 0;
        for(int i = 0; i < nombres.length; i++){
            if(nombres[i].equalsIgnoreCase(nombreAlum)){
                System.out.println(nombres[i] + " ten un " + notas[i] + " de nota");
                num = 1;
            }
        }
        if(num == 0){
            System.out.println("Nombre no encontrado");
        }
    }
    
    public void amosarAprobados(String nombres[], int notas[]){
        System.out.println("Aprobaron:");
        int num = 0;
        for (int i = 0; i < notas.length; i++){
            if(notas[i] >= 5){
                System.out.println((i+1) + "º alumno: " + nombres[i] + " con un " + notas[i]);
                num = 1;
            }
        }
        if (num == 0){
            System.out.println("No aprobó nadie");
        }
    }
    
    public void ordernarLista(String nombres[], int notas[]){
        for(int i = 0; i < CTE-1; i++){
            for(int j = i+1; j < CTE ; j++){
                if(notas[i] > notas[j]){
                    int aux = notas[i];
                    String auxN = nombres[i];
                    notas[i] = notas[j];
                    nombres[i] = nombres[j];
                    notas[j] = aux;
                    nombres[j] = auxN;
                }
            }
        }
        System.out.println("Lista ordenada:");
        for(int i = 0; i < notas.length; i++){
            System.out.println(nombres[i] + ": " + notas[i]);
        }
    }
    
    public void calcularLetraNIF(){//8
        long num;
        num = PedirDatos.getLong("Teclee o numero do teu NIF");
        while(num < 10000000 || num > 100000000){
            num = PedirDatos.getLong("O numero do NIF ten que tener 8 digitos, siendo 10000000 la primera combinacion posible ");
        }
        float div = num%23;
        int resto = (int) div;
        char letra[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        for (int i = 0; i<letra.length; i++){
            if (resto == i){
                System.out.println("Tu letra es: " + letra[i]);
            }
        }
    }
}
