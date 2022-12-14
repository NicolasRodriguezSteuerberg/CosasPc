package boletin17;

import javax.swing.JOptionPane;

/**
 *
 * @author NSteuerberg
 */
public class Boletin17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declaro atributo numero que será la condición para que el programa se repita si le damos a que queremos calcula otra nota
        int numero;
        
        //creo o obx de Probas
        Probas obx = new Probas();
        
        
        //bucle para repetir siempre que el numero sea 0 es decir que le demos a que si al JOption
        do{
            obx.Probas();
            
            numero = JOptionPane.showConfirmDialog(null, "Desexas calcular outra nota");
        }
        while(numero == 0);
        
        System.out.println("Saliendo del programa");
    }
    
}
