package earraylist;

import com.nicosteuerberg.datos.PedirDatos;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class eArrayList {

    public static void main(String[] args) {
        // TODO code application logic here
        /*Metodos obx = new Metodos();
        obx.crear();
        obx.ver();*/
        
        ListaEnteiros obxE = new ListaEnteiros();
        int num ;
        ArrayList <Integer> aux = new ArrayList();
        do{
            num = PedirDatos.getInt("1. Crear lista numeros\n2. Ver\n3. Añadir\n4. Borrar por posición\n5. Buscar si existe\n6. Añadir varios\n7. Borrar por numero\n8. Ordenar menor a maior\n9. Ordenar de maior a menor");
            switch (num){
                case 1:
                    aux = obxE.crear();
                    break;
                case 2:
                    obxE.ver();
                    break;
                case 3:
                    obxE.añadir(aux, PedirDatos.getInt("Teclee a posicion onde o queres añadir"));
                    break;
                case 4:
                    obxE.borrar(aux, PedirDatos.getInt("Teclee a posición a borrar"));
                    break;
                case 5:
                    obxE.buscarElemento(aux, PedirDatos.getInt("Teclee o elemento a atopar"));
                    break;
                case 6:
                    obxE.añadirVarios(aux, PedirDatos.getInt("Teclee a cantidad de numeros a añadir"));
                    break;
                case 7:
                    obxE.borrarNumero(aux, PedirDatos.getInt("Teclee o numero a borrar"));
                    break;
                case 8:
                    obxE.ordenar();
                    break;
                case 9:
                    obxE.ordenarMaiorMenor();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Saliendo do programa");
                    break;
            }
        }while(num > 0 && num < 10);
    }
    
}
