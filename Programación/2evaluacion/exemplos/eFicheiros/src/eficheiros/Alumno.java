package eficheiros;


public class Alumno {
    private String nome;
    private int nota;
    
    public Alumno(String nome, int nota){
        this.nome = nome;
        this.nota = nota;
    }
    
    public Alumno(){}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nome + ", " + nota;
    }
    
    
}
