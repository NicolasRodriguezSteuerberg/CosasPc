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
                    JOptionPane.showMessageDialog(null,msj);
                    return true;
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
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
     * @return numero hasta que devuelva un valor válido
     */
    public static int entradaInt(String comentario){
        int num = 0;
        boolean validacion = false;
        do {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog(comentario));
                validacion = true;
            } catch (Exception e) {
               EntradaSalida.salida("DATO NO VÁLIDO, INTENTELO DE NUEVO", SALIDA_WINDOW);
                validacion = false;
            }
        }while(validacion == false);
        return num;
    }

    /**
     * Entrada por consola
     * @param comentario = comentario que queremos que salga
     * @return numero hasta que se devuelva un valor válido
     */
    public static float entradaFloat(String comentario){
        float num = 0;
        boolean validacion = false;
        do {
            try {
                num = Float.parseFloat(JOptionPane.showInputDialog(comentario));
                validacion = true;
            } catch (Exception e) {
                EntradaSalida.salida("DATO NO VÁLIDO, INTENTELO DE NUEVO",SALIDA_CONSOLA);
                validacion = false;
            }
        }while(validacion == false);
        return num;
    }
}
