/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arquivos;

import java.io.File;
import javax.swing.JOptionPane;


/**
 *
 * @author postgres
 */
public class Arquivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        int opcion;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1 -> buscar directorio"
                    + "\n2 -> busca si es un fichero"
                    + "\n3 -> crear directorio"
                    + "\n4 -> crear fichero"
                    + "\n5 -> modo de acceso"
                    + "\n6 -> calcular lonxitude"
                    + "\n7 -> facer que sea lectura"
                    + "\n8 -> facer que sea de escritura"
                    + "\n9 -> borrar ficheiro"
                    + "\n10 -> borrar directorio"
                    + "\n11 -> contido do directorio"
                    + "\n12 -> nose"
                    ));
            switch(opcion){
                case 1:
                    obx.eDirectorio(JOptionPane.showInputDialog("Teclee la direccion"));
                    break;
                case 2:
                    obx.eFicheiro(JOptionPane.showInputDialog("Teclee la direccion"));
                    break;
                case 3:
                    obx.crearDirectorio(JOptionPane.showInputDialog("Teclee la direccion de la carpeta a crear"));
                    break;
                case 4: 
                    obx.crearFichero(JOptionPane.showInputDialog("Teclee a dirección onde quere crear o ficheiro"), JOptionPane.showInputDialog("Tecle o nome do ficheiro"));
                    break;
                case 5:
                    obx.modoAcceso(JOptionPane.showInputDialog("Teclee la ruta"));
                    break;
                case 6:
                    obx.calculaLonxitude(JOptionPane.showInputDialog("Teclee a dirección"));
                    break;
                case 7:
                    obx.mLectura(JOptionPane.showInputDialog("Teclee a dirección e o nome do archivo"));
                    break;
                case 8:
                    obx.mEscritura(JOptionPane.showInputDialog("Teclee a dirección e o nome do archivo"));
                    break;
                case 9:
                    obx.borraFicheiro(JOptionPane.showInputDialog("Teclee a dirección e o nome do archivo a borrar"));
                    break;
                case 10:
                    obx.borraDirectorio(JOptionPane.showInputDialog("Teclee a dirección do directorio a borrar"));
                    break;
                case 11:
                    obx.mContido(JOptionPane.showInputDialog("Teclee a dirección do directorio do que queres ver o seu contido"));
                    break;
                case 12:
                    
                    break;
            }
        }while(opcion<=12 && opcion>0);
        JOptionPane.showMessageDialog(null, "Saíndo do programa");
    }
    
}
