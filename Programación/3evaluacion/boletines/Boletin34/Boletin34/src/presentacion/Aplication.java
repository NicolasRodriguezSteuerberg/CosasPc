/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import java.io.File;

/**
 *
 * @author dam1
 */
public class Aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f = new File("contratados.txt");
        File e = new File("destajados.txt");
        GUI obx = new GUI();
        obx.llevarElFile(f,e);
        obx.setVisible(true);
        
    }
}
