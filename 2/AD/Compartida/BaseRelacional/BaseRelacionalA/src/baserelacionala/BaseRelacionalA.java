/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baserelacionala;

import java.sql.*;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author postgres
 */
public class BaseRelacionalA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
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
                    + "2. Listar\n"
                    + "3. Actualizar\n"
                    + "4. Eliminar"
                    )
            );
            
            switch(numero){
                case 1:
                    
                    codigo = JOptionPane.showInputDialog("Cal é o código?");
                    descricion = JOptionPane.showInputDialog("Cal é a descricion?");
                    prezo = Integer.parseInt(JOptionPane.showInputDialog("Cal é o prezo?"));
                    data = JOptionPane.showInputDialog("Cal é a data (DDMMYEAR)?");
                    
                    obx.insireProduto(conn, codigo, descricion, prezo, data);
                    
                    break;
                case 2:
                    
                    obx.consultar(conn);
                    break;
                case 3:
                    
                    codigo = JOptionPane.showInputDialog("Cal é o código do produto a modificar?");
                    prezo = Integer.parseInt(JOptionPane.showInputDialog("Cal é o novo prezo?"));
                    
                    obx.modificar(conn, codigo, prezo);
                    break;
                case 4:
                    codigo = JOptionPane.showInputDialog("Cal é o código do produto a modificar?");
                    
                    obx.borrar(conn, codigo);
                    break;
            }
            
        } while(numero < 5 && numero > 0);
    }
    
    
}
