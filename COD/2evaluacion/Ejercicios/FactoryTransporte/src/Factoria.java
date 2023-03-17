import com.nicosteuerberg.datos.PedirDatos;
import transportes.Barco;
import transportes.Bicicleta;
import transportes.Camion;
import transportes.ITransportes;

/**
 * Fabrica encargada de devolver el producto
 * que elegimos según el tipo
 */
public class Factoria {
        public static final int CAMION = 1;
        public static final int BICICLETA = 2;
        public static final int BARCO = 3;
        public static Integer cp = null;
        public static Float dimensionX = null;
        public static Float dimensionY = null;
        public static Float dimensionZ = null;
        public static Float peso = null;
        /**
         * Devuelve producto del tipo de la Interface
         * @param type 1: camion, 2:bicicleta, 3: barco
         * @return producto segun el tipo
         */
        public static ITransportes getProducto(int type) {
            cp = PedirDatos.getInt("Teclee tu CP");
            dimensionX = PedirDatos.getFloat("Teclee a dimensionX");
            dimensionY = PedirDatos.getFloat("Teclee a dimensionY");
            dimensionZ = PedirDatos.getFloat("Teclee a dimensionZ");
            peso = PedirDatos.getFloat("Teclee o peso");
            switch (type) {
                // tipo camion
                case CAMION:
                    return new Camion(cp, dimensionX, dimensionY, dimensionZ, peso);
                // tipo bicicleta
                case BICICLETA:
                    return new Bicicleta(cp, dimensionX, dimensionY, dimensionZ, peso);
                case BARCO:
                    return new Barco(cp, dimensionX, dimensionY, dimensionZ, peso);
                // otro tipo
                default:
                    return null;
            }
        }


}
