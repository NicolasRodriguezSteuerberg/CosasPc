package earraylistobxetos;

import com.nicosteuerberg.datos.PedirDatos;
import java.util.ArrayList;

/**
 *
 * @author NSteuerberg
 */
public class EArrayListObxetos {

    public static void main(String[] args) {
        ArrayList<Xogador> xogadores = new ArrayList();
        Metodos obx = new Metodos();
        int opcion;
        
        do{
            
            opcion = PedirDatos.getInt("1 --> Engadir xogador\n2 --> Amosar lista\n3 --> Buscar nome polo dorsal\n4 --> Borrar xogador polo seu nome");
            
            switch (opcion){
                
                    case 1:
                        obx.engadir(xogadores);
                        break;
                    case 2:
                        obx.amosarArray(xogadores);
                        break;
                    case 3:
                        obx.buscarElemento(xogadores, PedirDatos.getInt("Teclee o dorsal do xogador a buscar"));
                        break;
                    case 4:
                        obx.borrarArray2(xogadores);
                        break;
                    default:
                        System.out.println("\nSaíndo do programa.");     

            }
            
        }while(opcion > 0 && opcion < 5);
        
    }
    
}
