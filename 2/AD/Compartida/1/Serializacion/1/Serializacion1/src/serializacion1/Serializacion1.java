/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializacion1;

/**
 *
 * @author postgres
 */
public class Serializacion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MClase objeto1 = new MClase("ola", -7, 2.7E10);
        MClase objeto2 = new MClase();
        
        Metodos obxM = new Metodos();
        String ruta = "/media/sf_Compartida/Serializacion/1/texto.txt";
        obxM.escribir(ruta, objeto1);
        objeto2 = obxM.leer(ruta, objeto2);
        System.out.println(objeto2.toString());
        
    }
    
}
