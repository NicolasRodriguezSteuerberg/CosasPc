package xenericos;

/**
 * @author NSteuerberg
 */
public class ClaseXenerica <T>{
    //atributo
    private T dato;
    
    //constructor
    public ClaseXenerica(){};
    
    
    //setters & getters
    public void setDato(T valor){
        dato = valor;
    }
    
    public T getDato(){
        return dato;
    }
}
