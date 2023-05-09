package eficheiros;

import com.nicosteuerberg.datos.PedirDatos;
import escritura.EscribirFicheiros;
import ficheroSerializado.LecEscrituraSerializados;
import java.io.File;
import javax.swing.JOptionPane;
import lectura.LerFicheiros;


public class EFicheiros {

    
    public static void main(String[] args) {
        /*
        File f = new File("ficheroNumeros.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerPalabras(f,",");
        //obx.lerLiñas(f);
        
        //ArrayList
        File n = new File("numeros2.txt");
        LerFicheiros obx = new LerFicheiros();
        obx.lerNumero(n);
        
        
        //arrayList teniendo fichero con comas
        File n = new File("numeros3.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerNumeroDelimitadores(n);
        */
        /*
        File al = new File("alumnos.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerObxecto(al);
        */
        /*
        File n = new File("/home/dam1/Documentos/ficherosProg/probaNumeros.txt");
        LerFicheiros obx = new LerFicheiros();
        
        obx.lerPalabras(n, " ");
        */
        /*
        EscribirFicheiros obxEs = new EscribirFicheiros();
        File n = new File("diaSemana.txt");
        //obxEs.escribir(n);
        obxEs.engadirRexistro(n);
        
        LerFicheiros obxLer = new LerFicheiros();
        obxLer.lerPalabras(n, "\n");
        */
        /*
        File f = new File("buffer");
        LerFicheiros obxL = new LerFicheiros();
        EscribirFicheiros obxE = new EscribirFicheiros();
        
        obxE.escribirBuffer(f);
        obxL.lerBuffer(f);
        */
        /*
        File f = new File("serializar.DAT");
        LecEscrituraSerializados obxS = new LecEscrituraSerializados();
        obxS.escribirSeri(f);
        obxS.lerSerializable(f);
        obxS.engadirSeri(f);
        obxS.lerSerializable(f);
*/
        
        
        
        
        
        
        
        
        JOptionPane.showMessageDialog(null, "Este es un mensaje");
        String titulo = JOptionPane.showInputDialog("Teclee el titulo");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Teclee el numero"));
        
        titulo = PedirDatos.getString("mensaje");
        numero = PedirDatos.getInt("mensaje");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
