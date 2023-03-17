package transportes;

import com.nicosteuerberg.datos.PedirDatos;

public class Barco implements ITransportes{
    private Integer cp;
    private Float dimensionX;
    private Float dimensionY;
    private Float dimensionZ;
    private Float peso;

    public Barco(Integer cp, Float dimensionX, Float dimensionY, Float dimensionZ, Float peso) {
        this.cp = cp;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.dimensionZ = dimensionZ;
        this.peso = peso;
    }

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
        precio = (float) (diferencia*0.06);
        if (precio == 0){
            precio = 0.6f;
        }
        return precio;
    }

    @Override
    public Integer tipoEmbalaje(Float dimensionX, Float dimensionY, Float dimensionZ, Float peso) {
        Integer numero = null;
        float suma = dimensionX+dimensionY+dimensionZ;

        if(suma <=170 && peso<=60){
            numero = CAJA_CARTON;
        }
        else if(suma<=3020 && peso <=120){
            numero = CAJA_MADERA;
        }
        else{
            numero = PALET;
        }
        return numero;
    }
}
