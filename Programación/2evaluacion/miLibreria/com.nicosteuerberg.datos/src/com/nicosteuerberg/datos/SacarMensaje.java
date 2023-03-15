/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicosteuerberg.datos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class SacarMensaje {
    public static void sacarVentana(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static int pedirOpciones(String mensaje, String []aux){
        int opcion = JOptionPane.showOptionDialog(null, mensaje, "", 0, JOptionPane.QUESTION_MESSAGE, null, aux, null);
        return opcion;
    }
}
