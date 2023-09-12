public class BuilderPizzas {

    //utilizamos el guion bajo para remarcar que es un objeto de esta clase
    private Pizzas _pizza;

    //Constructor  -  crea la pizza para configurarla
    public BuilderPizzas(){
        _pizza = new Pizzas();
    }


    //métodos para la personalización de la pizza
    public BuilderPizzas setTipoMasa(int tipoMasa){
        _pizza.setTipoMasa(tipoMasa);
        return this;
    }

    public BuilderPizzas setSize(int size){
        _pizza.setSize(size);
        return this;
    }

    public BuilderPizzas setRelleno(boolean relleno) {
        _pizza.setRellena(relleno);
        return this;
    }

    public BuilderPizzas setCebolla(boolean cebolla) {
        _pizza.setCebolla(cebolla);
        return this;
    }

    public BuilderPizzas setSinGluten(boolean sinGluten){
        _pizza.setSinGluten(sinGluten);
        return this;
    }

    public BuilderPizzas setRecojida(int recojida) {
        _pizza.setRecojida(recojida);
        return this;
    }


    //metodo que devuelve el objeto terminado
    public Pizzas build(){
        return this._pizza;
    }

}
