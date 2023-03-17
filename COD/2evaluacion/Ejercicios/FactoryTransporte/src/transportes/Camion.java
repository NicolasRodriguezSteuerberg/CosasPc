package transportes;

import com.nicosteuerberg.datos.PedirDatos;

public class Camion implements ITransportes {
    private Integer cp;
    private Float dimensionX;
    private Float dimensionY;
    private Float dimensionZ;
    private Float peso;

    /**
     * @param cp codigo postal a donde hay que enviar el paquete
     * @param dimensionX -> ancho del paquete
     * @param dimensionY -> largo del paquete
     * @param dimensionZ -> alto del paquete
     * @param peso -> peso del paquete
     */
    public Camion(Integer cp, Float dimensionX, Float dimensionY, Float dimensionZ, Float peso) {
        this.cp = cp;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.dimensionZ = dimensionZ;
        this.peso = peso;
    }

    /**
     * @param cp -> codigo postal de donde hay que entregar el paquete
     * @return precio del envio
     */
    @Override
    public Float costeTotal(Integer cp) {
        while (cp > 37000 || cp < 36000){
            cp = PedirDatos.getInt("A este codigo postal non chegamos, ten que ser maior que 36000 e menor que 37000");
        }
        Integer diferencia = null;
        if(CODIGO>cp){
            diferencia = CODIGO-cp;
        }
        else{
            diferencia = cp-CODIGO;
        }
        Float precio = null;
        precio = (float) (diferencia*0.04);
        if (precio == 0){
            precio = 0.4f;
        }
        return precio;
    }

    /**
     * @param dimensionX -> ancho del paquete
     * @param dimensionY -> largo del paquete
     * @param dimensionZ -> alto del paquete
     * @param peso -> peso del paquete
     * @return tipo de embalaje: 0-Palet, 1-Caja de carton, 2-Caja de madera
     */
    @Override
    public Integer tipoEmbalaje(Float dimensionX, Float dimensionY, Float dimensionZ, Float peso) {
        Integer numero = null;
        float suma = dimensionX+dimensionY+dimensionZ;

        if(suma <=150 && peso<=40){
            numero = CAJA_CARTON;
        }
        else if(suma<=3000 && peso <=100){
            numero = CAJA_MADERA;
        }
        else{
            numero = PALET;
        }
        return numero;
    }
}
