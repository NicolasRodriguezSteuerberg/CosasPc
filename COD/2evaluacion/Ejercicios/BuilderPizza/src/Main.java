public class Main {
    public static void main(String[] args) {
        Pizzas pizza1 = new BuilderPizzas().build();
        System.out.println(pizza1.toString() +"\n");
        Pizzas pizzaPsicopata = new BuilderPizzas().setPiña(true).build();
        System.out.println(pizzaPsicopata.toString() +"\n");
        Pizzas pizza3 = new BuilderPizzas()
                .setSalsa(true)
                .setTipoSalsa("tomate")
                .build();
        System.out.println(pizza3.toString() +"\n");
    }
}
