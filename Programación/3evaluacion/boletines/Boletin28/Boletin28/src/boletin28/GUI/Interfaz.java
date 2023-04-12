package boletin28.GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author NSteuerberg
 */
public class Interfaz {
    
    JFrame marco;
    JPanel panel;
    JLabel etiqueta1, etiqueta2;
    JTextField lTexto1;
    JPasswordField lTexto2;
    JTextArea aTexto;
    JButton b1, b2;
    
    public void iniciar(){
        //declarar compoñentes
        marco = new JFrame("Boletin 28");
        panel = new JPanel();
        etiqueta1 = new JLabel("NOME");
        etiqueta2 = new JLabel("PASSWORD");
        lTexto1 = new JTextField();
        lTexto2 = new JPasswordField();
        aTexto = new JTextArea("   Area de texto");
        b1 = new JButton("PREMER");
        b2 = new JButton("LIMPAR");
        
        //dámoslles características
        
        //marco
        marco.setSize(800, 800);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
        
        
        //panel
        panel.setBounds(25, 25, 750, 750);
        panel.setLayout(null);
        
        //compoñentes:
        etiqueta1.setBounds(100,40,100,50);
        lTexto1.setBounds(350, 40, 300, 70);
        etiqueta2.setBounds(100,150,100,50);
        lTexto2.setBounds(350, 150, 300, 70);
        lTexto2.setEchoChar('⚫');
        
        aTexto.setBounds(90, 300, 500, 205);
        //aTexto.setText("Area de texto.");
        
        b1.setBounds(125, 650, 210, 50);
        
        
        b2.setBounds(450, 650, 210, 50);
        
        
        //engadimos os compoñentes ao panel
        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(lTexto1);
        panel.add(lTexto2);
        panel.add(aTexto);
        panel.add(b1);
        panel.add(b2);
        
        
        //engadimos o panel ao marco
        marco.add(panel);
    }
}
