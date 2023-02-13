package xenericos;

/**
 *
 * @author NSteuerberg
 */
public class Xogador {
    //atributos
    private String nome;
    private int dorsal;
    
    //Constructores
    public Xogador(){}
    
    public Xogador(String nome, int dorsal) {
        this.nome = nome;
        this.dorsal = dorsal;
    }
    
    
    //Setters & getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    @Override
    public String toString() {
        return  nome + " ten o dorsal  " + dorsal;
    }
    
    
}
