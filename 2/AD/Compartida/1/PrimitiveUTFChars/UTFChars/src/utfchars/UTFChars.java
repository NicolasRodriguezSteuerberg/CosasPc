package utfchars;

/**
 *
 * @author postgres
 */
public class UTFChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos obx = new Metodos();
        String ruta = "/media/sf_Compartida/PrimitiveUTFChars/text6.dat";
        obx.escritura(ruta);
        System.out.println();
        obx.leer(ruta);
    }
    
}
