package array;

import java.util.Arrays;
import com.nicosteuerberg.datos.PedirDatos;
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
            opcion = PedirDatos.getInt("\t***MENÚ***\n1-->CREAR ARRAY\n2-->AMOSAR\n3-->BÚSQUEDA\n4-->ORDENAR\n5-->BORRAR\n6-->ENGADIR\n7-->SAIR");
        
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
                case 5:
                    obx.borrarArray(auxiliar);
                    break;
                case 6:
                    obx.engadirArray(auxiliar);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción incorrecta. Fin do programa");
                    break;
                    
            }
        }while(opcion <= 7 && opcion >=1);
        
        
    }
    
}
