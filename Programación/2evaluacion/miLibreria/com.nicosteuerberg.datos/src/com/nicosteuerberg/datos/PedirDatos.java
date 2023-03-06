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
    
    public static byte pedirbyte(String mensaxe){
        return Byte.parseByte(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static short pedirshort(String mensaxe){
        return Short.parseShort(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static int pedirint(String mensaxe){
        return Integer.parseInt(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static Integer pedirInteger(String mensaxe){
        return Integer.valueOf(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static long pedirlong(String mensaxe){
        return Long.parseLong(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static float pedirfloat(String mensaxe){
        return Float.parseFloat(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static Float pedirFloat(String mensaxe){
        return Float.valueOf(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static double pedirdouble(String mensaxe){
        return Double.parseDouble(JOptionPane.showInputDialog(mensaxe));
    }
    
    public static String getString(String mensaxe){
        return JOptionPane.showInputDialog(mensaxe);
    }
    
}
