package produtosjava;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Produtosjava {

    public static void main(String[] args) throws SQLException {
        Metodos obx = new Metodos();
        Connection con = obx.conexion();
        
        obx.engadir(
                con, 
                JOptionPane.showInputDialog("Codigo"), 
                JOptionPane.showInputDialog("Descripcion"), 
                Integer.parseInt(JOptionPane.showInputDialog("prezo")), 
                JOptionPane.showInputDialog("cidade"), 
                Integer.parseInt(JOptionPane.showInputDialog("CODIGO POSTAL"))
        );
        obx.listadoCompleto(con);
        
        System.out.println("");
        obx.modificar(con,
                JOptionPane.showInputDialog("Codigo"), 
                JOptionPane.showInputDialog("cidade")
        );
        obx.listadoCompleto(con);
    }
    
}
