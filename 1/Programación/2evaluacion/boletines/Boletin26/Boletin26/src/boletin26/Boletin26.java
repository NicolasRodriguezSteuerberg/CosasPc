/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin26;

import com.nicosteuerberg.datos.PedirDatos;
import java.util.ArrayList;

/**
 *
 * @author dam1
 */
public class Boletin26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Operacions<Integer> obx = new Operacions();
        int opcion;
        ArrayList<Integer> lista= new ArrayList(); 
        do{
            opcion = PedirDatos.getInt("1 --> Añadir\n2 --> Elemento mínimo\n3 --> Elemento máximo\n4 --> Buscar elemento\n5 --> Borrar primer elemento");
            switch(opcion){
                case 1:
                    int num = PedirDatos.getInt("Cuantos numeros quieres añadir?");
                    for(int i = 0; i < num; i++){
                        obx.engadir(PedirDatos.getInt("Teclee un numero"), lista);
                    }
                    break;
                case 2:
                    obx.elementoMinimo(lista);
                    break;
                case 3:
                    obx.elementoMaximo(lista);
                    break;
                case 4:
                    int posicion = obx.buscarElemento(lista, PedirDatos.getInt("Teclee o numero a buscar"));
                    if(posicion == -1){
                        System.out.println("");
                    }
                    break;
                case 5:
                    obx.borrar(lista, PedirDatos.getInt("Teclee o numero a borrar"));
                    break;
                default:
                    System.out.println("Saíndo do programa");
                    break;
            }
        }while(opcion > 0 && opcion < 6);
    }
    
}
