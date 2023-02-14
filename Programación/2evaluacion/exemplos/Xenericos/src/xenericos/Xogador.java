package xenericos;

/**
 *
 * @author NSteuerberg
 */
public class Xogador implements Comparable{
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
    
    /*      Ordenar por dorsal*/
    public int compareTo(Object o){
        Xogador x = (Xogador)o;
        if(this.dorsal > x.dorsal){
            return 1;
        }
        else if(this.dorsal < x.dorsal){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    
    //Ordenar por nombre
    /*public int compareTo(Object o){
        Xogador x = (Xogador)o;
        if(this.nome.compareToIgnoreCase(x.nome)>0){
            return 1;
        }
        else if(this.nome.compareToIgnoreCase(x.nome)<0){
            return -1;
        }
        else{
            return 0;
        }
    }*/
    
}
