import javax.swing.*;

/**
 * @author NSteuerberg
 */
public class Adivinar2 {

    public void adivinarNumero() {
        PedirDatos obx = new PedirDatos();

        /**
         * declaro numeroadivinar, numeroescogido, numero intentos, intentos
         */

        int numAAdivinar, numEsc, numInt, i;
        numAAdivinar = obx.numA();
        numInt = obx.numIntentos();

        /**
         * For para repetir todos los intententos
         */

        for (i = 0; i < numInt; i++) {
            numEsc = obx.numEsc();
            /**
             *Si numero a adivinar < que numero escogido que salga "numero es menor"
              */

            if (numAAdivinar < numEsc) {
                JOptionPane.showMessageDialog(null, "El numero es menor");
            }

            /**
             * si numero a adivinar > que numero escogido que salga "numero es mayor"
             */

            else if (numAAdivinar > numEsc) {
                JOptionPane.showMessageDialog(null, "El numero es mayor");
            }

            /**
             * si numero a adivinar = numero escogido que se rompa bucle for y salga que el adivinaste
             */

            else if (numAAdivinar == numEsc) {
                JOptionPane.showMessageDialog(null, "Adivinaste el número era " + numAAdivinar);
                break;
            }

        }

        /**
         * si se producen todos los intentos que salga que perdiste
         */

        if (i == numInt) {
            JOptionPane.showMessageDialog(null, "Perdiste, el numero era " + numAAdivinar);
        }
    }
}
