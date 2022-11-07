/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplobucles;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class DoWhile {
    //o mesmo ejercicio que bucleWhile
    public void verNum(){
        double num;
        double acu=0;
        double suma;
        Scanner obx=new Scanner(System.in);
        do{
            num=obx.nextDouble();
            acu=acu+num;
        }
         while(num>0);
            
    }
}
