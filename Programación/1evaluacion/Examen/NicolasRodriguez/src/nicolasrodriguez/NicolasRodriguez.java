/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nicolasrodriguez;

import javax.swing.JOptionPane;

/**
 *
 * @author NicolasRodriguez
 */
public class NicolasRodriguez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaro o atributo numeroValidacion para poder validar se se quere continuar no programa
        int numeroValidacion;
        
        //fago do while para que se execute ata que o usuario ponga que non quere seguir
        do{
            PlataformaPelis pel1 = new PlataformaPelis("Contos de Vigo", 22f);
            pel1.visualizar();
            pel1.rebaixa();
            numeroValidacion = JOptionPane.showConfirmDialog(null, "Queres seguir no programa?");
        }
        while(numeroValidacion == 0);
    }
    
}
