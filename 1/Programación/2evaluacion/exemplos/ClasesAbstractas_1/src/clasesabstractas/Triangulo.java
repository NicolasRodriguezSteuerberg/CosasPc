package clasesabstractas;


public class Triangulo extends FigurasGeometricas implements IDibuxable, IRotable{

    public Triangulo(float base, float altura) {
        super(base, altura);
    }
    
    public float calcularArea() {
        return super.getBase()*getAltura()/2;
    }

    public float calcularPerimetro() {
        return super.getBase()+getAltura()+((float)Math.sqrt(Math.pow(super.getBase(), 2)+Math.pow(super.getAltura(), 2)));
    }

    public void dibuxar() {
        System.out.println("Dibuxo triangulo");
        
    }

    public void rotar() {
        System.out.println("Roto triangulo");
        
    }
    
    
    
}
