public class Main {
    public static void main(String[] args) {
        //hacer pizza sin builder
        Pizzas pizzaDefault = new Pizzas();
        Pizzas pizaAmedida = new Pizzas(Pizzas.FINA,Pizzas.GRANDE,true,false,true,Pizzas.TIENDA);

        //utilizanodo el builder  y en concreto el metodo build
       /* BuilderPizzas miBuilder = new BuilderPizzas()
                .setCebolla(false);
        pizzaDefault = miBuilder.build();*/
        //mejor puesto
        Pizzas miBuilder = new BuilderPizzas()
                .setCebolla(true)
                .setSize(Pizzas.FINA)
                .build();
        System.out.println(miBuilder.toString());
    }
}
