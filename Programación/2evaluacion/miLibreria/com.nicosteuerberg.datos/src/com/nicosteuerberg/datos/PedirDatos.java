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
    
    public static byte getByte(String mensaxe){
        return Byte.parseByte(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static short getShort(String mensaxe){
        return Short.parseShort(JOptionPane.showInputDialog(mensaxe));
    }
    
    
    public static int getInt(String mensaxe){
        return Integer.parseInt(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static long getLong(String mensaxe){
        return Long.parseLong(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static float getFloat(String mensaxe){
        return Float.parseFloat(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static double getDouble(String mensaxe){
        return Double.parseDouble(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static String getString(String mensaxe){
        return JOptionPane.showInputDialog(mensaxe);
    }
    
}
