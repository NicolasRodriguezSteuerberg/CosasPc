/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicosteuerberg.datos;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author dam1
 */
public class VentanaLabel {
    
    /**
     * Poner texto y color al texto
     * @param texto -> texto que quieres que saque
     * @param label -> la etiqueta
     * @param color -> el color: Color.colorQuerido
     */
    public static void mensajeLabel(String texto, JLabel label, Color color){
        label.setText(texto);
        label.setForeground(color);
    }
    
}
