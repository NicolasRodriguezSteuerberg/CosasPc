/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin21;

import com.nicosteuerberg.datos.PedirDatos;
import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Boletin21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Boletin21_Metodos obx1 = new Boletin21_Metodos();
        int auxNum[];
        int auxNotas[] = null;
        String auxNombres[] = null;
        int numero;
        do{
            numero = PedirDatos.getInt("1. Array numeros\n2. Entrar en alumnos\n3. Calcular letra NIF");
            switch(numero){
                case 1:
                    auxNum = obx1.arrayNumeros();
                    obx1.amosarArrayNumeros(auxNum);
                    break;
                case 2:
                    int num = 0;
                    do{
                        num = PedirDatos.getInt("1. Crear alumnos con sus notas\n2. Numero de aprobados y suspensos\n3. Ver la media\n4. Ver nota más alta\n5. Buscar nota a partir del nombre\n6. Ver lista de alumnos aprobados\n7. Ordenar ascendete de notas\n8. Salir");
                        switch(num){
                            case 1:
                                auxNotas = obx1.arrayNotas();
                                auxNombres = obx1.arrayNombre();
                                break;
                            case 2:
                                obx1.amosarNotas(auxNotas);
                                break;
                            case 3:
                                obx1.amosarNotaMedia(auxNotas);
                                break;
                            case 4:
                                obx1.amosarNotaAlta(auxNotas);
                                break;
                            case 5:
                                obx1.amosarNotaDeterminada(auxNombres, auxNotas);
                                break;
                            case 6:
                                obx1.amosarAprobados(auxNombres, auxNotas);
                                break;
                            case 7:
                                obx1.ordernarLista(auxNombres, auxNotas);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Saíndo das notas");
                        }
                        
                    }while (num > 0 && num < 8);
                case 3:
                    obx1.calcularLetraNIF();
                    break;
                    


                    
            }
        }while(numero >= 5);
        
    }
    
}
