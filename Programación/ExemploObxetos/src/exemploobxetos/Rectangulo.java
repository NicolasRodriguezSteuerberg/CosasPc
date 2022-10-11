package exemploobxetos;

public class Rectangulo {
    //declaro atributos
    private float base, altura;
    
    //constructores
    public Rectangulo(float b, float h){ //constructor parametrizado
        base=b;
        altura=h;
    }
    public Rectangulo(){ //constructor por defecto
    
    }
    //deefinir métodos de acceso (getters e setters)
    public void darValorAltura(float h){ //corresponde a setAltura
        altura=h;
    }
    public float devolverValorAltura(){ //equivale a getAltura
        return altura;
    }
    public void setBase(float b){
        base=b;
    }
    /*public void setBase(float base){       //para cuando haya conflicto de nomes utilízase o this
        this.base=base;
    }*/
    public float getBase(){
        return base;
    }    
    
    //defino metodos
    public float calcularArea (float b, float h){//base, altura
        float area = b*h;
        return area;
    }
    public void calcularPerimetro (float b, float h){
        float perimetro=2*b+2*h;
        System.out.println("Perímetro é de "+perimetro);
        //System.out.println("peri="+ (2*b+2*a)); é o mesmo ca as 2 de arriba
    }
    
}
