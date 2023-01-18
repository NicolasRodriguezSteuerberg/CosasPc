package array;

import java.util.Arrays;
import javax.swing.JOptionPane;


public class Array {


    public static void main(String[] args) {

        //Creo o obxecto metodos
        Metodos obx = new Metodos();
        float [] auxiliar = null; //para gardar o array de metodos tempos que crear un array
        /*auxiliar = obx.crearArrayFloat(); //igualamos o array co metodo da array
        
        obx.amosarArray(auxiliar);
        
        obx.amosarPorPosicion(auxiliar, 3);
        
        obx.amosarArrayForEach(auxiliar);
        */
        int opcion;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("\t***MENÚ***\n1-->CREAR ARRAY\n2-->AMOSAR\n3-->BÚSQUEDA\n4-->ORDENAR"));
        
            switch(opcion){
                case 1:
                    auxiliar = obx.crearArrayFloat();
                    break;
                    
                case 2:
                    obx.amosarArray(auxiliar);
                    System.out.println();
                    break;
                    
                case 3:
                    obx.buscarArray(auxiliar);
                    break;
                case 4:
                    obx.ordenarArray(auxiliar);
                    break;
                default:
                    System.out.println("Fin do programa");
                    break;
                    
            }
        }while(opcion <= 4);
        
        
    }
    
}
