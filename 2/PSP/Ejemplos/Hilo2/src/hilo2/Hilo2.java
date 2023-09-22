/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilo2;

/**
 *
 * @author dam2
 */
public class Hilo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ThreadEjemplo("Pepe").start();
        new ThreadEjemplo("Juan").start();
        new ThreadFibonacci("13").start();
        System.out.println("Termina thread main");
    }
}
    
    
class ThreadEjemplo extends Thread{
    public ThreadEjemplo(String str){
        super(str);
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
        }
        System.out.println("Termina thread " + getName());
    }
}

class ThreadFibonacci extends Thread{
    public ThreadFibonacci(String numero){
        super(numero);
    }
    
    public void run(){
        /*
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
        int stop = Integer.parseInt(getName());
        int []numeros = new int[stop];
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

    

