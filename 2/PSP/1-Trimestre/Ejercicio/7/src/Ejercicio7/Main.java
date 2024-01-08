package Ejercicio7;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Buzon buz = new Buzon();
        MyThread hiloEsc = new MyThread("Enviar","Hola nico", buz);
        MyThread hiloLec = new MyThread("Lectura1",null, buz);
        MyThread hiloEsc2 = new MyThread("Enviar", "Hola gabriel", buz);
        MyThread hiloLec2 = new MyThread("Lectura2", null,buz);
        
        hiloLec.start();
        hiloLec2.start();
        hiloEsc.start();
        hiloEsc2.start();
    }
    
}
