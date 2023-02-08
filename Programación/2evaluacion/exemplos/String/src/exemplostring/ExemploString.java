/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplostring;

import com.nicosteuerberg.datos.PedirDatos;
import java.util.Arrays;

/**
 *
 * @author dam1
 */
public class ExemploString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        int num;
        
        do{
            num = PedirDatos.getInt("1 --> Amosar tamaño\n2 --> Poner en mayúsculas\n3 --> Poner en minúsculas\n4 --> Comparar\n5 --> Comparar letras no mayúsculas\n6 --> Amosar como array\n7 --> Cortar la palabra\n8 --> Saír");
            switch (num){
                case 1:
                    obx.amosarTamaño();
                    break;
                case 2:
                    obx.ponerMayusculas();
                    break;
                case 3:
                    obx.ponerMinusculas();
                    break;
                case 4:
                    obx.comparar();
                    break;
                case 5:
                    obx.compararIgnorandoMayusculas();
                    break;
                case 6:
                    obx.amosarComoArray();
                    break;
                case 7:
                    obx.cortarDeterminadoLugar();
                    break;
                default:
                    System.out.println("Saíndo do programa");
                    break;
            }
        }while(num > 0 && num < 8);
        
    }
    
}
