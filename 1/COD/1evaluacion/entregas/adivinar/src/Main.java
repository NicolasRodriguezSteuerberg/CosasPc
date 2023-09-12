import javax.swing.*;

public class Main {
    /**
     * Empieza el programa
     *
     * @author NSteuerberg
     * @version 1.0.0
     */
    static final String MSG_CANT_JUGADORES = "Escoge cuantos a jugar 1 o 2";

    public static void main(String[] args) {
        /**
         * inicializo los objetos adivinar solo y 2
         */
        Adivinar2 obx2 = new Adivinar2();
        AdivinarSolo obxS = new AdivinarSolo();

        /**
         * inicializo la cantidad de jugadores y la pido por consola
         */
        int cantJugadores = Integer.parseInt(JOptionPane.showInputDialog(MSG_CANT_JUGADORES));

        /**
         * Un switch para saber que objeto utilizar
         */

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