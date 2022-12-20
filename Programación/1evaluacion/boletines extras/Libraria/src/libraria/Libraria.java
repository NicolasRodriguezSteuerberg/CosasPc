package libraria;

/**
 *
 * @author Nico
 */
public class Libraria {
    //declaro atributos
    private Libro lib;
    private String nome;
    
    //constructor por defecto y parametrizado
    public Libraria (){}
    
    public Libraria (Libro lib, String nome){
        this.lib = lib;
        this.nome = nome;
    }
     
    //metodos
    //mudar prezo
    public void mudarPrezo(float prez){
        lib.setPrezo(prez);
    }
    //toString
    @Override
    public String toString() {
        return lib.toString() + "\tnome=" + nome;
    }
    
    
}
