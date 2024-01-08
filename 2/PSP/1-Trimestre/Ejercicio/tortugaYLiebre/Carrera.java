package tortugaYLiebre;
import java.util.Random;

/**
 * carrera
 */
public class Carrera  extends Thread{
    public static final int linea = 70;
    public static boolean finCarrera = false;
    public static void main(String[] args) {
        Animal turtle = new Animal("Tartaruga", new int[]{3, -6, 1}, new int[]{50, 20, 30});
        Animal hare = new Animal("Lebre", new int[]{0, 9, -12, 1, -2}, new int[]{20, 20, 10, 30, 20});
        turtle.start();
        hare.start();
    }
}