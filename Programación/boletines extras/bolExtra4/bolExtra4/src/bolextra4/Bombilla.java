/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolextra4;

import javax.swing.JOptionPane;

/**
 *
 * @author dam1
 */
public class Bombilla {
    private byte estadoEA;
    
    public void casaBombilla(){
        int nBombillas = nBombillas();
        int acceso;
        String seguir;
        do{
            acceso = Integer.parseInt(JOptionPane.showInputDialog("Quieres acceder a la bombilla(0) o al general(1) o al estado de las luces(3)?"));
        
            switch(acceso){
                case 0:
                    
                    break;
                case 1:
                    interruptorGeneral();
                    break;
                case 2:
                    estado();
                default:
                    JOptionPane.showMessageDialog(null, "Comando incorrecto");
                    break;
            }
        
        
            seguir=JOptionPane.showInputDialog("Quieres seguir manipulando las luces de la casa?");
        }
        while(!"no".equals(seguir));
        
        
        
        
    }
    
    
    public void interruptorGeneral(){
        String intG = JOptionPane.showInputDialog("Quiere apagar o encender la luz general");
        
        if(intG=="apagar"){
            JOptionPane.showMessageDialog(null, "Todas las bombillas están apagadas");
        }
        else if (intG == "encender"){
            JOptionPane.showMessageDialog(null, estadoEA);
        } 
    }
    
    public int nBombillas(){
        int nbom=Integer.parseInt(JOptionPane.showInputDialog("Teclee o número dos bombillos que hay na casa"));
        return nbom;
    }
    
    private String estado(){
        estadoEA=eEA;
        if (estadoEA==1){
            JOptionPane.showMessageDialog(null, "está encendida");
        }
        
    }
}
