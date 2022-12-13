/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin16;

/**
 *
 * @author dam1
 */
public class Boletin16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cli = new Cliente("Nicolas", "Rodriguez Steuerberg", "1234524F"); 
        
        Cliente cli2 = new Cliente("Ramon", "Perez", "4567234d");
        
        CuentaAhorro obxCa = new CuentaAhorro(cli, 6394, 0.45, 1000);
        System.out.println(obxCa.toString());
        obxCa.ingresar();
        obxCa.retirar();
        obxCa.actualizarSaldo();
        
        CuentaCorriente Cc = new CuentaCorriente(cli2, 5489);
        System.out.println(Cc.toString());
        Cc.ingresar();
        Cc.retirar();
        Cc.actualizarSaldo();
        
    }
    
}
