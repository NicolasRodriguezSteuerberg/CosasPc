/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baerelacionalb;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author postgres
 */
public class BaeRelacionalB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Metodos obx = new Metodos();
        
        Connection conn = null;
        
        conn = obx.conexion();
        int numero;
        String codigo, descricion, data;
        int prezo;
        do{
            numero = Integer.parseInt(JOptionPane.showInputDialog(
                      "1. Listar\n"
                    + "2. Modificar\n"
                    + "3. Añadir\n"
                    + "4. Eliminar"
                    )
            );
            
            switch(numero){
                case 1:
                    obx.listadoCompleto(conn);
                    break;
                case 2:
                    codigo = JOptionPane.showInputDialog("Cal é o código a modificar?");
                    prezo = Integer.parseInt(JOptionPane.showInputDialog("Cal é o prezo novo?"));
                    
                    obx.modificar(conn, codigo, prezo);
                    break;
                case 3:
                    codigo = JOptionPane.showInputDialog("Cal é o código a engadir?");
                    descricion = JOptionPane.showInputDialog("Cal é a descricion?");
                    prezo = Integer.parseInt(JOptionPane.showInputDialog("Cal é o prezo?"));
                    
                    obx.engadir(conn, codigo, descricion, prezo);
                    break;
                case 4:
                    codigo = JOptionPane.showInputDialog("Cal é o código do produto a modificar?");
                    obx.borrar(conn, codigo);
                    break;
            }
            
        } while(numero < 5 && numero > 0);
    }
    
}
