package ejercicio11;


public class Ejercicio11 {

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        new MyThread("Tortuga", tablero).start();
        new MyThread("Liebre", tablero).start();
    }
    
}
