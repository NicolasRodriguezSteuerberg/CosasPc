package transportes;

public interface ITrasnportes {
    public static final Integer CODIGO = 36500;
    /**
     * Metodo para calcular el coste
     * @param CP -> dar un Codigo Postal
     * @return cuanto cuesta
     */
    Float costeTotal(Integer cp);

    /**
     *
     * @param dimensionX -> las dimensiones ancho
     * @param dimensionY -> largo
     * @param dimensionZ -> alto
     * @param peso -> peso
     * @return
     */
    Integer tipoEmbalaje(Float dimensionX, Float dimensionY, Float dimensionZ, Float peso);

}
