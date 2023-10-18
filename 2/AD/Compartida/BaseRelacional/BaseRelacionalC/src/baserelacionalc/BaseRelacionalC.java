/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baserelacionalc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author postgres
 */
public class BaseRelacionalC {

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
                    "1. Insertar\n"
                    + "2. Actualizar\n"
                    + "3. Visualizar"
                    )
            );
            
            switch(numero){
                case 1:
                    codigo = JOptionPane.showInputDialog("Cal é o código?");
                    descricion = JOptionPane.showInputDialog("Cal é a descricion?");
                    prezo = Integer.parseInt(JOptionPane.showInputDialog("Cal é o prezo?"));
                    obx.insert(conn, codigo, descricion, prezo);
                    break;
                case 2:
                    codigo = JOptionPane.showInputDialog("Cal é o código do produto a modificar?");
                    descricion = JOptionPane.showInputDialog("Cal é a nova descricion?");
                    obx.update(conn, codigo, descricion);
                    break;
                case 3:
                    obx.select(conn);
                    break;
            }
            
        } while(numero < 4 && numero > 0);
        
        conn.close();
    }
    
}
