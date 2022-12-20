/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin11;

/**
 *
 * @author dam1
 */
public class Boletin11_2 {
    public void calcSumaMult(){
        int suma=0;
        double mult=1;
        for (int i=10; i<91; i++){
            suma=suma+i;
            mult=mult*i;
        }
        System.out.println("A suma é "+suma+"\nO produto é "+mult);
    }
}
