package clasesabstractas;


import javax.swing.JOptionPane;



public abstract class FigurasGeometricas {
    //atributos
    private float base;
    private float altura;
    
    //constructor

    public FigurasGeometricas(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }
    
    
    //métodos
    public abstract float calcularArea();
    
    public abstract float calcularPerimetro();
    
    //set-get
    public float getBase(){
        return base;
    }

    public float getAltura() {
        return altura;
    }
        
    
}
