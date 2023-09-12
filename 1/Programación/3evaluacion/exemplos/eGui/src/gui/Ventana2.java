package gui;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author NSteuerberg
 */
public class Ventana2 extends JFrame{
    //damoslle as características
    
    public void iniciarVentana(){
        this.setSize(800, 400);
        
        /*
        //Para usar un panel, podemos utilizar el default, para usar el color de fondo necesitamos un panel
        JPanel panel = (JPanel) this.getContentPane(); 
        panel.setBackground(Color.BLUE);
        */
        
        
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

}
