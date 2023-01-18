public class Bulbasaur extends DatosComunes{
    private int daño;
    public Bulbasaur(String nome, int ps, int ataque, int defensa, int velocidad, String tipo) {
        super(nome, ps, ataque, defensa, velocidad, tipo);
    }

    void verAtaques() {
        System.out.println("1. Placaje, 2. Hoja afilada, 3. Latigo cepa, 4. Hoja aguda");
    }

    void atacar1(){
        System.out.println(super.getNome() + " ha usado Placaje");
        daño = super.getAtaque()*20;
    }

    @Override
    void atacar2() {
        System.out.println(super.getNome() + " ha usado Hoja afilada");
        daño = super.getAtaque()*30;
    }

    @Override
    void atacar3() {
        System.out.println(super.getNome() + " ha usado Latigo cepa");
        daño = super.getAtaque()*40;
    }

    @Override
    void atacar4() {
        System.out.println(super.getNome() + " ha usado Hoja aguda");
        daño = super.getAtaque()*45;
    }
}
