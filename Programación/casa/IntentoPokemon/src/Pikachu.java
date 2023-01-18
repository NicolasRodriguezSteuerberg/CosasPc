public class Pikachu extends DatosComunes{

    private int daño;

    public Pikachu(String nome, int ps, int ataque, int defensa, int velocidad, String tipo) {
        super(nome, ps, ataque, defensa, velocidad, tipo);
    }

    void verAtaques() {
        System.out.println("1. Placaje\t2. Impactrueno\t3. Rayo\4. Puño trueno\n");
    }

    void atacar1(){
        System.out.println(super.getNome() + " ha usado Placaje");
        daño = super.getAtaque()*20;
    }

    void atacar2() {
        System.out.println(super.getNome() + " ha usado Impactrueno");
        daño = super.getAtaque()*30;
    }


    void atacar3() {
        System.out.println(super.getNome() + " ha usado Rayo");
        daño = super.getAtaque()*40;
    }


    void atacar4() {
        System.out.println(super.getNome() + " ha usado Puño trueno");
        daño = super.getAtaque()*45;
    }
}
