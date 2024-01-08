package ejercicio10;


public class Ejercicio10 {

    public static void main(String[] args) {
        Parking miParking = new Parking();
        for (int i = 0; i < 15; i++) {
            new MyThread((i+1), miParking).start();
        }
    }
    
}
