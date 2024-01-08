/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propuestohilo1;

/**
 *
 * @author dam2
 */
public class ThreadFibonacci extends Thread{
    public ThreadFibonacci(String numero){
        super(numero);
    }
    
    public void run(){
        /* Sin arrays
        int stop = Integer.parseInt(getName()) - 2;
        int numero1 = 1;
        int numero2 = 1;
        int suma;
        System.out.println(numero1 + "\n" + numero2);
        for(int i = 0; i < stop;i++){
            suma = numero1 + numero2;
            numero1 = numero2;
            numero2 = suma;
            System.out.println(suma);
        }
        */
        //Con arrays
        int stop = Integer.parseInt(getName());
        int []numeros = new int[stop];
        
        //Creacion de los 1, si el stop es 1 solo esté el numero 1
        //y si el stop 2 solo esten los 2 unos
        if(stop >= 1){
            int numeroStop = (stop==1)? 1 : 2;
            for (int i = 0; i < numeroStop; i++) {
                numeros[i] = 1;
                System.out.println(numeros[i]);
            }
        }
    
        for (int i = 2; i < stop; i++) {
            numeros[i] = numeros[i - 2] + numeros[i - 1];
            System.out.println(numeros[i]);
        }
    }
}
