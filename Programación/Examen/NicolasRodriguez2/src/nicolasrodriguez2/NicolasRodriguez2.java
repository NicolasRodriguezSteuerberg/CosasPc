/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nicolasrodriguez2;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class NicolasRodriguez2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //declaro o atributo numeroValidacion para poder validar se se quere continuar no programa
        int numeroValidacion;        
        //fago do while para que se execute ata que o usuario ponga que non quere seguir
        do{
            Peliculas pli1 = new Peliculas("Contos de Vigo" , 22.3f);
            PlataformaPelis pel1 = new PlataformaPelis(pli1);
            pel1.visualizar();
            pel1.rebaixa();
            numeroValidacion = JOptionPane.showConfirmDialog(null, "Queres seguir no programa?");
        }
        while(numeroValidacion == 0);
    }
    
}
