public abstract class DatosComunes {
    private int ps, ataque, defensa, velocidad;
    private String nome, tipo;

    public DatosComunes(String nome, int ps, int ataque, int defensa, int velocidad, String tipo) {
        this.nome = nome;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
    }

    abstract void verAtaques();

    abstract void atacar1();

    abstract void atacar2();

    abstract void atacar3();

    abstract void atacar4();

    public int getPs() {
        return ps;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}
