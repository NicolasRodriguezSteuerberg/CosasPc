/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin6_2;

/**
 *
 * @author dam1
 */
public class Satelite {
    //atributos
    private double meridiano;
    private double paralelo;
    private double distanciaTerra ;

    //constructores
    public Satelite(){
        meridiano = paralelo = distanciaTerra = 0;
    }
    public Satelite ( double m, double p, double d ){
        meridiano = m ;
        paralelo = p;
        distanciaTerra = d ;
    }
    //metodo
    public void verPosicion(){
        System.out.println("o satelite atopase no paralelo "+paralelo+"\n"
                + "o meridiano no "+meridiano+"\n"
                        + "a unha distancia da terra "+distanciaTerra+"\n");
    }
    
}
