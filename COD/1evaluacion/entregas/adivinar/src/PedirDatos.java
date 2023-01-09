import javax.swing.*;

/**
 * @author NSteuerberg
 */
public class PedirDatos {
    /**
     * Aquí pido todos los parámetros
     */
    public int numMin() {
        /**
         * Para conseguir el numero mínimo
         * @return numero mínimo
         */

        int numMin = Integer.parseInt(JOptionPane.showInputDialog("Teclee o número minimo do intervalo a adivinar"));
        return numMin;
    }

    public int numMax() {
        /**
         * Conseguir el número máximo de intervalo
         * @return numero máximo
         */
        int numMax = Integer.parseInt(JOptionPane.showInputDialog("Teclee o número máximo do intervalo a adivinar"));
        return numMax;
    }

    public int numIntentos() {
        /**
         * Conseguir numero de intentos y hacer que si los intentos son menor de 1 que le regalo 5 intentos
         * @return intentos
         */
        int intentos = Integer.parseInt(JOptionPane.showInputDialog("Escoge cuantos intentos para adivinar"));
        if (intentos < 1) {
            JOptionPane.showMessageDialog(null, "Los intentos no pueden ser menor que 1, te regalo 5 intentos");
            intentos = 5;
        }
        return intentos;
    }

    public int numEsc() {
        /**
         * Conseguir número a escoger
         * @return numero escogido
         */
        int num = Integer.parseInt(JOptionPane.showInputDialog("Teclee un número"));
        if (num > 50 || num < 1) {
            do {
                num = Integer.parseInt(JOptionPane.showInputDialog("O numero ten que estar comprendido entre 1 y 50"));

            }
            while (num > 50 || num < 1);
        }
        return num;
    }

    /**
     * Conseguir el número a adivinar
     *
     * @return numero a adivinar
     */
    public int numA() {
        int numAdiv;
        do {
            numAdiv = Integer.parseInt(JOptionPane.showInputDialog("Teclee o numero a adivinar entre 1 y 50"));

        }
        while (numAdiv < 1 || numAdiv > 50);
        return numAdiv;
    }
}

