package ejercicio8;


public class Ejercicio8 {

    public static void main(String[] args) {
        // TODO code application logic here
        Elevator elv = new Elevator();
        new MyThread(0, 5, elv, "nico").start();
        new MyThread(1, 15, elv, "gabriel").start();
        new MyThread(15, 2, elv, "lidier").start();
        new MyThread(1, 0, elv, "marcos").start();
        new MyThread(20, 1, elv, "gonzalo").start();
    }
    
}
