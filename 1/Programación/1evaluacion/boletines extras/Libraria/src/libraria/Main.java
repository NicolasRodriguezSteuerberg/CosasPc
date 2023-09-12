package libraria;

import javax.swing.JOptionPane;

/**
 *
 * @author Nico
 */
public class Main {

    public static void main(String[] args) {
        //chamo a libro para darlle os valores ao titulo e ao prezo
        Libro lbo1 = new Libro("Los cometas", 23.4f);
        
        //chamo a libraria darlle o nome 
        Libraria lba1 = new Libraria(lbo1, "Enrique");
        
        //chamo ao metodo mudar prezo
        lba1.mudarPrezo(Float.parseFloat(JOptionPane.showInputDialog("Teclee o novo prezo")));
        
        //asomo os atributos
        System.out.println(lba1.toString());
    }
    
}
