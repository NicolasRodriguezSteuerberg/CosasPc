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
        Operacions obx = new Operacions();
        int numero;
        ArrayList<Integer> lista= new ArrayList(); 
        do{
            numero = PedirDatos.getInt("1 --> Añadir\n2 --> Elemento mínimo\n3 --> Elemento máximo\n4 --> Buscar elemento");
            switch(numero){
                case 1:
                    obx.engadir(PedirDatos.getInt("Teclee un numero"), lista);
                    break;
                case 2:
                    obx.elementoMinimo(lista);
                    break;
                case 3:
                    obx.elementoMaximo(lista);
                    break;
                case 4:
                    obx.buscarElemento(lista, PedirDatos.getInt("Teclee o numero a buscar"));
                    break;
                default:
                    System.out.println("Saíndo do programa");
                    break;
            }
        }while(numero > 0 && numero < 5);
    }
    
}
