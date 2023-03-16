package transportes;

public interface ITransportes {
    public static final int CODIGO = 36500;

    public static final int PALET = 0;
    public static final int CAJA_CARTON = 1;
    public static final int CAJA_MADERA = 2;
    /**
     * Metodo para calcular el coste
     * @param cp -> dar un Codigo Postal
     * @return cuanto cuesta
     */
    Float costeTotal(Integer cp);

    /**
     * Método para calcular el tipo de embalaje
     * @param dimensionX -> las dimensiones ancho
     * @param dimensionY -> largo
     * @param dimensionZ -> alto
     * @param peso -> peso
     * @return numero para despues saber que tipo es
     */
    Integer tipoEmbalaje(Float dimensionX, Float dimensionY, Float dimensionZ, Float peso);

}
