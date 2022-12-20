/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicosteuerberg.datos;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class PedirDatos {
    
    public byte getByte(){
        return Byte.parseByte(JOptionPane.showInputDialog("Teclee o número"));
    }
    
    public short getShort(){
        return Short.parseShort(JOptionPane.showInputDialog("Teclee o número"));
    }
    
    
    public static int getInt(){
        return Integer.parseInt(JOptionPane.showInputDialog("Teclee o numero"));
    }
    
    public long getLong(){
        return Long.parseLong(JOptionPane.showInputDialog("Teclee o número"));
    }
    
    public float getFloat(){
        return Float.parseFloat(JOptionPane.showInputDialog("Teclee o número"));
    }
    
    public double getDouble(){
        return Double.parseDouble(JOptionPane.showInputDialog("Teclee o número"));
    }
    
    public String getNome(){
        return JOptionPane.showInputDialog("Teclee o nome");
    }
    
    public String getApelido(){
        return JOptionPane.showInputDialog("Teclee o apelido");
    }
    
    public String getString(){
        return JOptionPane.showInputDialog("Teclee a palabra");
    }
}
