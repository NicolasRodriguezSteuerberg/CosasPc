import javax.swing.*;

public class AdivinarSolo {
    /**
     * @author NSteuerberg
     */
    public void adivinarNumero() {
        /**
         * inicializo num a adivinar, numero escogido y numero de intentos
         */
        int numAdiv, numEsc, numInt, i;
        numAdiv = (int) (Math.random() * 50 + 1);
        PedirDatos obx = new PedirDatos();
        numInt = obx.numIntentos();

        /**
         * for para los intentos
         */

        for (i = 0; i < numInt; i++) {
            numEsc = obx.numEsc();

            /**
             * si numero a adivinar es numero escogido con diferencia de 5 que salga estas muy cerca
             */

            if (numAdiv + 5 >= numEsc && numAdiv + 1 <= numEsc || numAdiv - 5 <= numEsc && numAdiv - 1 >= numEsc) {
                JOptionPane.showMessageDialog(null, "Estas moi preto");
            }

            /**
             * si numero a adivinar es numero escogido con diferencia de 5 a 10 que salga estas  cerca
             */

            else if (numAdiv - 5 > numEsc && numAdiv - 10 < numEsc || numAdiv + 5 < numEsc && numAdiv + 10 > numEsc) {
                JOptionPane.showMessageDialog(null, "Estas preto");
            }

            /**
             * si numero a adivinar es numero escogido con diferencia de 10 a 20 que salga estas lejos
             */

            else if (numAdiv - 10 >= numEsc && numAdiv - 20 <= numEsc || numAdiv + 10 <= numEsc && numAdiv + 20 >= numEsc) {
                JOptionPane.showMessageDialog(null, "Estas lonxe");
            }

            /**
             * si numero a adivinar es numero escogido con diferencia de mas de 20 que salga estas muy lejos
             */

            else if (numAdiv + 20 < numEsc || numAdiv - 20 > numEsc) {
                JOptionPane.showMessageDialog(null, "Estas moi lonxe");
            }

            /**
             * si numero a adivinar = numero escogido que salga que adivinaste
             */

            else if (numAdiv == numEsc) {
                JOptionPane.showMessageDialog(null, "Adivinaste el número era " + numAdiv);
                break;
            }

            /**
             * Que salga cuantos intentos te quedan
             */

            JOptionPane.showMessageDialog(null, "Te quedan " + (numInt - (i + 1)) + " intentos");
        }

        /**
         * si has hecho todos los intentos que salga que pierdas
         */

        if (i == numInt) {
            JOptionPane.showMessageDialog(null, "Perdiste, el número era " + numAdiv);

        }
    }
}

