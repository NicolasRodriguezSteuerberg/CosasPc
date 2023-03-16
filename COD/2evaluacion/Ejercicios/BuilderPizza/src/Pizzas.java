public class Pizzas {
    String masa;
    boolean relleno;
    int tamaño;
    boolean salsa;
    String tipoSalsa;
    boolean cebolla;
    boolean sinGluten;
    boolean extraQueso;
    boolean piña;
    boolean champiñones;
    boolean jamon;

    public static final int FAMILIAR=1;
    public static final int MEDIANA=2;
    public static final int PEQUEÑA=3;


    public Pizzas() {
        this.masa = "normal";
        this.relleno = true;
        this.tamaño = MEDIANA;
        this.salsa = false;
        this.tipoSalsa = null;
        this.cebolla = true;
        this.sinGluten = true;
        this.extraQueso = true;
        this.piña = false;
        this.champiñones = false;
        this.jamon = true;
    }

    public Pizzas(String masa, boolean relleno, int tamaño, boolean salsa, String tipoSalsa, boolean cebolla, boolean sinGluten, boolean extraQueso, boolean piña, boolean champiñones, boolean jamon) {
        this.masa = masa;
        this.relleno = relleno;
        this.tamaño = tamaño;
        this.salsa = salsa;
        this.tipoSalsa = tipoSalsa;
        this.cebolla = cebolla;
        this.sinGluten = sinGluten;
        this.extraQueso = extraQueso;
        this.piña = piña;
        this.champiñones = champiñones;
        this.jamon = jamon;
    }

    @Override
    public String toString() {
        return  "masa:" + masa +
                "\nrelleno:" + relleno +
                "\ntamaño=" + tamaño +
                "\nsalsa=" + salsa +
                "\ntipoSalsa='" + tipoSalsa +
                "\ncebolla=" + cebolla +
                "\nsinGluten=" + sinGluten +
                "\nextraQueso=" + extraQueso +
                "\npiña=" + piña +
                "\nchampiñones=" + champiñones +
                "\njamon=" + jamon;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isSalsa() {
        return salsa;
    }

    public void setSalsa(boolean salsa) {
        this.salsa = salsa;
    }

    public String getTipoSalsa() {
        return tipoSalsa;
    }

    public void setTipoSalsa(String tipoSalsa) {
        this.tipoSalsa = tipoSalsa;
    }

    public boolean isCebolla() {
        return cebolla;
    }

    public void setCebolla(boolean cebolla) {
        this.cebolla = cebolla;
    }

    public boolean isSinGluten() {
        return sinGluten;
    }

    public void setSinGluten(boolean sinGluten) {
        this.sinGluten = sinGluten;
    }

    public boolean isExtraQueso() {
        return extraQueso;
    }

    public void setExtraQueso(boolean extraQueso) {
        this.extraQueso = extraQueso;
    }

    public boolean isPiña() {
        return piña;
    }

    public void setPiña(boolean piña) {
        this.piña = piña;
    }

    public boolean isChampiñones() {
        return champiñones;
    }

    public void setChampiñones(boolean champiñones) {
        this.champiñones = champiñones;
    }

    public boolean isJamon() {
        return jamon;
    }

    public void setJamon(boolean jamon) {
        this.jamon = jamon;
    }
}
