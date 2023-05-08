/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin33;

/**
 * no me gusta este boletin
 * @author dam1
 */
public class Boletin33 {

    /**
     * Falta el arrayList!!!!
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SeleccionFutbol obxF;
        obxF = new Futbolista();
        llamadas(obxF);
        obxF = new Entrenador();
        llamadas(obxF);
        obxF = new Masajista();
        llamadas(obxF);
        obxF = new Seleccionador();
        llamadas(obxF);
    }
    
    public static void llamadas(SeleccionFutbol obxF){
        obxF.concentrarse();
        obxF.viajar();
        obxF.entrenar();
        obxF.jugarPartido();
        System.out.println(obxF.toString());
        System.out.println("******************");
    }
    
}
