package gui;

import javax.swing.*;

/**
 *
 * @author NSteuerberg
 */
public class Ventana1 {
    JFrame marco;
   
    public void iniciarVentana(){
        //El constructor que recibe un string es para que salga el nombre de la ventana arriba
        marco = new JFrame("Primera gui de mi vida uououo");
        
        //características da ventana
        
        //tamaño de la ventana, tambien sirve setBounds()-> aqui pones tambien los puntos x,y donde empieza la ventana
        marco.setSize(800, 400);
        
        //para centrar la ventana automáticamente
        marco.setLocationRelativeTo(marco);
        
        
        //CARACTERÍSTICAS ESENCIALES
        //para finalizar la ejecucuión si cierras la ventana -> exit_on_close=3
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //para hacer visible la ventana
        marco.setVisible(true);
    }
}
