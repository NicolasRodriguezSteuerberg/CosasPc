import com.nicosteuerberg.datos.PedirDatos;
import transportes.Bicicleta;
import transportes.Camion;
import transportes.ITrasnportes;

/**
 * Fabrica encargada de devolver el producto
 * que elegimos según el tipo
 */
public class Factoria {
        public static final int CONSOLA = 1;
        public static final int VENTANA = 2;
        /**
         * Devuelve producto del tipo de la Interface
         * @param type 1: consola, 2:ventana
         * @param msg string a imprimir
         * @return producto segun el tipo
         */
        public static ITrasnportes getProducto(int type) {
            Integer cp = PedirDatos.getInt("Teclee tu CP");
            Float dimensionX = PedirDatos.getFloat("Teclee a dimensionX");
            Float dimensionY = PedirDatos.getFloat("Teclee a dimensionY");
            Float dimensionZ = PedirDatos.getFloat("Teclee a dimensionZ");
            Float peso = PedirDatos.getFloat("Teclee o peso");
            switch (type) {
                // tipo consola
                case CONSOLA:
                    return new Camion(cp, dimensionX, dimensionY, dimensionZ, peso);
                // tipo ventana
                case VENTANA:
                    return new Bicicleta(cp, dimensionX, dimensionY, dimensionZ, peso);;
                // otro tipo
                default:
                    return null;
            }
    }

}
