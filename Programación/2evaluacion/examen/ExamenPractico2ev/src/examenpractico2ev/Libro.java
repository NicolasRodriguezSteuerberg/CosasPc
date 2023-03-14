package examenpractico2ev;

/**
 *
 * @author NicolasRodriguezSteuerberg
 */
public class Libro {
    String titulo;
    int numPaxinas;

    public Libro(String titulo, int numPaxinas) {
        this.titulo = titulo;
        this.numPaxinas = numPaxinas;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumPaxinas() {
        return numPaxinas;
    }

    public void setNumPaxinas(int numPaxinas) {
        this.numPaxinas = numPaxinas;
    }

    @Override
    public String toString() {
        return "titulo=" + titulo + ", numPaxinas=" + numPaxinas;
    }
    
    
}
