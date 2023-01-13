package clasesabstractas;


public class Rectangulo extends FigurasGeometricas implements IDibuxable, IRotable{
    
    public Rectangulo(float base, float altura) {
        super(base, altura);
    }   
    
    public float calcularArea(){
        return super.getBase()*getAltura();
    }

    public float calcularPerimetro() {
       return 2*super.getBase()+2*getAltura();
    }


    public void dibuxar(){
        System.out.println("Dibuxamos o rectangulo :\n"
                + "*******\n*     *\n*******");
    }


    public void rotar(){
        System.out.println("Rotamos o rectangulo :\n"
                + "***\n* *\n* *\n* *\n* *\n* *\n***");
    }
    
    

}
