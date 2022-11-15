
package boletin12;

import javax.swing.JOptionPane;

public class Boletin12 {

    public static void main(String[] args) {
        Adivinar2 obx2=new Adivinar2();
        AdivinarSolo obxS=new AdivinarSolo();
        int sOd=Integer.parseInt(JOptionPane.showInputDialog("Escoge cuantos a jugar 1 o 2"));
        
        switch(sOd){
            case 1:
                obxS.adivinarNumero();
                break;
            case 2:
                obx2.adivinarNumero();
                break;
        }
    }
    
}
