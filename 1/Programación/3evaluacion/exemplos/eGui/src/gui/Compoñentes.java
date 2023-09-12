package gui;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author NSteuerberg
 */
public class Compoñentes {
    JFrame marco;
    JPanel panel;
    JLabel etiqueta;
    JTextField lTexto;
    JTextArea aTexto;
    JButton bCopiar, bSair;
    
    public void iniciar(){
        
        //declar compoñentes
        marco = new JFrame("Compoñentes");
        panel = new JPanel();
        etiqueta = new JLabel("linea de texto");
        lTexto = new JTextField();
        aTexto = new JTextArea();
        bCopiar = new JButton("Copiar");//se lle pode por tanto nombre, imaxe ou ambas
        bSair = new JButton();
        
        
        //dámoslle características
        
        //marco:
        marco.setBounds(0, 0, 800, 800);
        marco.setDefaultCloseOperation(3);
        marco.setVisible(true);
        
        //panel:
        panel.setBounds(5, 5, 750, 750);
        panel.setBackground(Color.cyan);
        
        //compoñentes
        etiqueta.setBounds(50, 100, 100, 50);
        lTexto.setBounds(200, 100, 200, 50);
        aTexto.setBounds(50, 200, 200, 300);
        bCopiar.setBounds(100, 600, 150, 100);
        bSair.setBounds(500, 600, 150, 100);
        bSair.setText("Saír");
        bSair.setToolTipText("Para saír do programa");
        
        //engadir os compoñentes ao panel
        panel.setLayout(null);
        panel.add(etiqueta);
        panel.add(lTexto);
        panel.add(aTexto);
        panel.add(bCopiar);
        panel.add(bSair);
        marco.add(panel);
        
    }
    
}
