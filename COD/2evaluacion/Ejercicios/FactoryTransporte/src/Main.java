import com.nicosteuerberg.datos.PedirDatos;
import transportes.ITransportes;

public class Main{

    static ITransportes obxT;//es objeto, despues se iguala con un new NombreClase

    public static void main(String[] args) {
        Float coste = null;
        String tipo = null;
        Integer nTipo = null;

        int numero = PedirDatos.getInt("Como quieres que te lo entregen:\n1->Camion\n2->Bicicleta");
        switch (numero){
            case 1:
                obxT = Factoria.getProducto(Factoria.CAMION);
                break;
            case 2:
                obxT = Factoria.getProducto(Factoria.BICICLETA);
                break;
        }
        coste = obxT.costeTotal(Factoria.cp);
        nTipo = obxT.tipoEmbalaje(Factoria.dimensionX,Factoria.dimensionY,Factoria.dimensionZ,Factoria.peso);

        if(nTipo==null && coste==null){
            System.out.println("Opcion incorrecta, saliendo del programa");
        }

        else {
            if (nTipo == obxT.PALET) {
                tipo = "palet";
            }
            else if (nTipo == obxT.CAJA_MADERA) {
                tipo = "caja de madera";
            }
            else {
                tipo = "caja de carton";
            }
            System.out.println("Coste de envio: " + coste + " tipo de embalaje: " + tipo);
        }

    }
}
