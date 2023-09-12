public class BuilderPizzas {

    private Pizzas _pizzas;

    public BuilderPizzas(){
        _pizzas = new Pizzas();
    }

    public BuilderPizzas setMasa(String masa){
        _pizzas.setMasa(masa);
        return this;
    }

    public BuilderPizzas setCebolla(boolean x){
        _pizzas.setCebolla(x);
        return this;
    }

    public BuilderPizzas setChampiñones(boolean x){
        _pizzas.setChampiñones(x);
        return this;
    }

    public BuilderPizzas setPiña(boolean x){
        _pizzas.setPiña(x);
        return this;
    }

    public BuilderPizzas setJamon(boolean x){
        _pizzas.setJamon(x);
        return this;
    }

    public BuilderPizzas setExtraQueso(boolean x){
        _pizzas.setExtraQueso(x);
        return this;
    }

    public BuilderPizzas setRelleno(boolean x){
        _pizzas.setRelleno(x);
        return this;
    }

    public BuilderPizzas setSalsa(boolean x){
        _pizzas.setSalsa(x);
        return this;
    }

    public BuilderPizzas setSinGluten(boolean x){
        _pizzas.setSinGluten(x);
        return this;
    }

    public BuilderPizzas setTamaño(int tamaño){
        _pizzas.setTamaño(tamaño);
        return this;
    }

    public BuilderPizzas setTipoSalsa(String salsa){
        _pizzas.setTipoSalsa(salsa);
        return this;
    }

    public Pizzas build(){
        return this._pizzas;
    }
}
