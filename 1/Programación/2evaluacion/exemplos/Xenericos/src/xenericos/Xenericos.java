/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xenericos;

import com.nicosteuerberg.datos.PedirDatos;
import java.util.ArrayList;

/**
 *
 * @author dam1
 */
public class Xenericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ClaseXenerica <Xogador> obx = new ClaseXenerica();
        Xogador x = new Xogador("Manuel", 2);
        
        obx.setDato(x);
        System.out.println(obx.getDato());
        */
        /*    //ArrayList con xenericos(numeros int)
        ColeccionsXenericas<Integer> obxList = new ColeccionsXenericas();
        ArrayList<Integer> lista= new ArrayList();
        int num = PedirDatos.getInt("Teclee cantos numeros queres añadir");
        for(int i = 0;i<num;i++){
            obxList.engadir(PedirDatos.getInt("Teclee o "+ (i+1) + "º numero"), lista);
        }
        ColeccionsXenericas.amosar(lista);
        */
        
        /*     //ArrayList con xenericos(numeros float)
        ColeccionsXenericas<Float> obxList = new ColeccionsXenericas();
        ArrayList<Float> lista= new ArrayList();
        int num = PedirDatos.getInt("Teclee cantos numeros queres añadir");
        for(int i = 0;i<num;i++){
            obxList.engadir(PedirDatos.getFloat("Teclee o "+ (i+1) + "º numero"), lista);
        }
        ColeccionsXenericas.amosar(lista);
        */
        
             //ArrayList con xenericos(Xogadores)
        ColeccionsXenericas<Xogador> obxList = new ColeccionsXenericas<>();
        ArrayList<Xogador> lista= new ArrayList<>();
        int num = PedirDatos.getInt("Teclee cantos xogadores queres añadir");
        for(int i = 0;i<num;i++){
            /*Xogador x = new Xogador(PedirDatos.getString("Teclee o nombre do "+ (i+1) + "º Xogador"), PedirDatos.getInt("Teclee o dorsal do " + (i+1) + "º Xogador"));
            obxList.engadir(x, lista);*/
            
            obxList.engadir(new Xogador(PedirDatos.getString("Teclee o nombre do "+ (i+1) + "º Xogador"), PedirDatos.getInt("Teclee o dorsal do " + (i+1) + "º Xogador")), lista);            
        }

        
        obxList.ordenar(lista);

        
    }
    
}
