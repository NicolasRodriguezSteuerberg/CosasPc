package ejercicio9;


public class Ejercicio9 {


    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread("Hilo 1");
        MyThread thread2 = new MyThread("Hilo 2");
        MyThread thread3 = new MyThread("Hilo 3");
        
        thread3.start();
        thread3.join();
        thread2.start();
        thread2.join();
        thread1.start();
    }
    
}
