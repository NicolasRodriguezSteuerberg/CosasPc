import javax.swing.*;
import java.util.Scanner;

public class EntradaSalida {

    static final int SALIDA_CONSOLA = 1;
    static final int SALIDA_WINDOW = 2;

    /**
     * Salida por ventana o consala de un mensaje
     * @param msj cadena que queremos imprimir
     * @param device dispositivo de salida, consola (SALIDA_CONSOLA) o ventana (SALIDA_VENTANA)
     * @return si es true: correcto si no false
     */
    static boolean salida(String msj, int device) {
        switch (device) {
            case SALIDA_CONSOLA:
                try {
                    System.out.println("Consola: " + msj);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            case SALIDA_WINDOW:
                try {
                    JOptionPane.showMessageDialog(null,"Sale por un ventana " + msj.toCharArray()[10]);
                    return true;
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }

            default:
                return false;
        }
    }

    //TODO entrada

    /**
     * Introducción por consola de una cadena de texto
     * @param comentario = comentario para que el usuario sepa que tiene que escribir
     * @return Cadena de texto introducida por el usuario
     */
    public static String entradaString(String comentario){
        Scanner obx = new Scanner(System.in);
        String dato;
        System.out.println(comentario);
        dato = obx.next();
        return dato;
        }

    /**
     * Entrada por consola
     * @param comentario = comentario que queremos que salga
     * @return numero, 0 si es un dato nulo
     */
    public static int entradaInt(String comentario){
        int num = 0;
        boolean validacion = false;
        do {
            try {
                Scanner obx = new Scanner(System.in);
                System.out.println(comentario);
                num = obx.nextInt();
                validacion = true;
            } catch (Exception e) {
                System.out.println("DATO NO VÁLIDO, INTENTELO DE NUEVO");
                validacion = false;
            }
        }while(validacion == false);
        return num;
    }
}
