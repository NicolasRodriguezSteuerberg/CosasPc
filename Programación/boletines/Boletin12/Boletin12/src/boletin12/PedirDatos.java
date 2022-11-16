/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin12;

import javax.swing.JOptionPane;

/**
 * @author dam1
 */
public class PedirDatos {

    public int numMin() {
        int numMin = Integer.parseInt(JOptionPane.showInputDialog("Teclee o número minimo do intervalo a adivinar"));
        return numMin;
    }

    public int numMax() {
        int numMax = Integer.parseInt(JOptionPane.showInputDialog("Teclee o número máximo do intervalo a adivinar"));
        return numMax;
    }

    public int numIntentos() {
        int intentos = Integer.parseInt(JOptionPane.showInputDialog("Escoge cuantos intentos para adivinar"));
        if (intentos < 1) {
            JOptionPane.showMessageDialog(null, "Los intentos no pueden ser menor que 1, te regalo 5 intentos");
            intentos = 5;
        }
        return intentos;
    }

    public int numEsc() {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Teclee un número"));
        if (num > 50 || num < 1) {
            do {
                num = Integer.parseInt(JOptionPane.showInputDialog("O numero ten que estar comprendido entre 1 y 50"));

            }
            while (num > 50 || num < 1);
        }
        return num;
    }

    public int numA() {
        int numAdiv;
        do {
            numAdiv = Integer.parseInt(JOptionPane.showInputDialog("Teclee o numero a adivinar entre 1 y 50"));

        }
        while (numAdiv < 1 || numAdiv > 50);
        return numAdiv;
    }
}
