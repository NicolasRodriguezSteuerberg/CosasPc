/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin22;

import com.nicosteuerberg.datos.PedirDatos;

/**
 *
 * @author dam1
 */
public class Boletin22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num;
        
        Metodos obx = new Metodos();
        int [][]auxGoles = null;
        int []auxXornadas;
        auxGoles = obx.crearArrayGoles();
        auxXornadas = obx.crearXornadas();
        do{
            num = PedirDatos.getInt("1. Ver tabla\n2. Ordenar por goles máximos");
            switch(num){
                case 1:
                    obx.verTabla(auxXornadas, obx.equipos, auxGoles);
                    break;
                case 2:
                    obx.ordenarTabla(obx.equipos, auxGoles);
                    break;
            }
        }while(num>0);
    }
    
}
