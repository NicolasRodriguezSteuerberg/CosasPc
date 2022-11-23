import javax.swing.*;

/**
 * @author NSteuerberg
 */
public class Adivinar2 {

    public void adivinarNumero() {
        PedirDatos obx = new PedirDatos();
        int numAAdivinar, numEsc, numInt, i;
        numAAdivinar = obx.numA();
        numInt = obx.numIntentos();

        for (i = 0; i < numInt; i++) {
            numEsc = obx.numEsc();
            if (numAAdivinar < numEsc) {
                JOptionPane.showMessageDialog(null, "El numero es menor");
            }
            else if (numAAdivinar > numEsc) {
                JOptionPane.showMessageDialog(null, "El numero es mayor");
            }
            else if (numAAdivinar == numEsc) {
                JOptionPane.showMessageDialog(null, "Adivinaste el número era " + numAAdivinar);
                break;
            }

        }
        if (i == numInt) {
            JOptionPane.showMessageDialog(null, "Perdiste, el numero era " + numAAdivinar);
        }
    }
}
