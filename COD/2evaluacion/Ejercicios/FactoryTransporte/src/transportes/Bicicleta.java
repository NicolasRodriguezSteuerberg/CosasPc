package transportes;

import com.nicosteuerberg.datos.PedirDatos;

public class Bicicleta implements ITransportes {
    private Integer cp;
    private Float dimensionX;
    private Float dimensionY;
    private Float dimensionZ;
    private Float peso;

    public Bicicleta(Integer cp, Float dimensionX, Float dimensionY, Float dimensionZ, Float peso) {
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
        Float precio = null;
        precio = (float) ((CODIGO-cp)*0.02);
        if (precio == 0){
            precio = 0.2f;
        }
        return precio;
    }

    @Override
    public Integer tipoEmbalaje(Float dimensionX, Float dimensionY, Float dimensionZ, Float peso) {
        Integer numero = null;
        float suma = dimensionX+dimensionY+dimensionZ;

        if(suma <=150 && peso<=40){
            numero = 1;
        }
        else if(suma<=3000 && peso <=100){
            numero = 2;
        }
        else{
            numero = 0;
        }
        return numero;
    }
}
