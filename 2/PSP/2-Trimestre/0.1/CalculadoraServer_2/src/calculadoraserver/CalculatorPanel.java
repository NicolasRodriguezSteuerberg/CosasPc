package calculadoraserver;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author postgres
 */
public class CalculatorPanel extends JPanel{
    private static final long serialVersionUID = 1L;
    private JTextField display; // Área de texto para mostrar la entrada
    private StringBuilder input; // Almacena la entrada del usuario
    
    public CalculatorPanel(){
        setLayout(new BorderLayout());
        
    }
    
}
