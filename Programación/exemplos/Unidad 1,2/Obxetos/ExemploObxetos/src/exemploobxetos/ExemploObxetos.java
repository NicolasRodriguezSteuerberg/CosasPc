package exemploobxetos;

import java.util.Scanner;






public class ExemploObxetos {


    public static void main(String[] args) {
        
        Rectangulo obxRec1=new Rectangulo();
        float resultado = obxRec1.calcularArea(2, 3.0f);
        System.out.println("area é "+resultado);
        obxRec1.calcularPerimetro(2, 3);
        
        //Instancio obxecto tipo rectangulo co constructor parametrizado
        Rectangulo obxRec2=new Rectangulo (5,8);
        float base=obxRec2.getBase();
        float altura=obxRec2.devolverValorAltura();
                
        float re = obxRec2.calcularArea(base, altura);
            System.out.println("nova area=" + re);
        
        //calcular perímetro pidiendo os valores a traves del scanner
        Scanner obxScanner=new Scanner(System.in);
        float baseP, alturaP;
        System.out.println("Introduzca o valor da base");
        baseP=obxScanner.nextFloat();
        System.out.println("Introduzca o valor da altura");
        alturaP=obxScanner.nextFloat();
        
        Rectangulo obxRec3=new Rectangulo(baseP, alturaP);
        float basePed3=obxRec3.getBase();
        float alturaPed3=obxRec3.devolverValorAltura();
        obxRec3.calcularPerimetro(basePed3, alturaPed3);
        
        

    }
        
        
        
        
        
        
        
}