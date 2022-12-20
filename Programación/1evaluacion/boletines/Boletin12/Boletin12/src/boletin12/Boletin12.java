
package boletin12;

import javax.swing.JOptionPane;
/**
*@author NSteuerberg
* @version 1.0.0
 */
public class Boletin12 {
    static final String MSG_CANT_JUGADORES = "Escoge cuantos a jugar 1 o 2";

    public static void main(String[] args) {

        Adivinar2 obx2 = new Adivinar2();
        AdivinarSolo obxS = new AdivinarSolo();

        int cantJugadores;
        cantJugadores = Integer.parseInt(JOptionPane.showInputDialog(MSG_CANT_JUGADORES));

        switch (cantJugadores) {
            case 1:
                obxS.adivinarNumero();
                break;
            case 2:
                obx2.adivinarNumero();
                break;
        }
    }

}
