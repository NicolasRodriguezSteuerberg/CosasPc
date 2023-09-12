public class Pizzas {
    private int tipoMasa;
    private int size;
    private boolean rellena;
    private boolean cebolla;
    private  boolean sinGluten;
    private int recojida;

    //tipo masa
    public static final int FINA = 0;
    public static final int NORMAL = 1;

    //tamaño
    public static final int SMALL = 0;
    public static final int MEDIANA = 1;
    public static final int GRANDE = 2;

    //recojida
    public static final int TIENDA = 0;
    public static final int PARALLEVAR = 1;

    public Pizzas() {
        this.cebolla = true;
        this.recojida = TIENDA;
        this.rellena = false;
        this.sinGluten = false;
        this.size = MEDIANA;
        this.tipoMasa = FINA;
    }
    /**
     * Constructor con todoa los parametros
     * @param tipoMasa espesor de la masa
     * @param size tamaño de la pizza
     * @param rellena si el borde esta relleno de queso
     * @param cebolla lleva o no lleva
     * @param sinGluten para celíacos
     * @param recojida como lo va a recoger el cliente
     */
    public Pizzas(int tipoMasa, int size, boolean rellena, boolean cebolla,boolean sinGluten, int recojida) {
        this.tipoMasa = tipoMasa;
        this.size = size;
        this.rellena = rellena;
        this.cebolla = cebolla;
        this.sinGluten = sinGluten;
        this.recojida = recojida;
    }

    public int getTipoMasa() {
        return tipoMasa;
    }

    public void setTipoMasa(int tipoMasa) {
        this.tipoMasa = tipoMasa;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isRellena() {
        return rellena;
    }

    public boolean isCebolla() {
        return cebolla;
    }

    public void setCebolla(boolean cebolla) {
        this.cebolla = cebolla;
    }

    public void setRellena(boolean rellena) {
        this.rellena = rellena;
    }

    public boolean isSinGluten() {
        return sinGluten;
    }

    public void setSinGluten(boolean sinGluten) {
        this.sinGluten = sinGluten;
    }

    public int getRecojida() {
        return recojida;
    }

    public void setRecojida(int recojida) {
        this.recojida = recojida;
    }

    @Override
    public String toString() {
        return
                "tipoMasa:" + tipoMasa +
                "\nsize:" + size +
                "\nrellena:" + rellena +
                "\ncebolla:" + cebolla +
                "\nsinGluten:" + sinGluten +
                "\nrecojida:" + recojida;
    }
}
