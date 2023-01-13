package clasesabstractas;

import javax.swing.JOptionPane;

public class ClasesAbstractas {

    public static void main(String[] args) {
        // TODO code application logic here
        /*JOptionPane.showMessageDialog(null, "Calculos rectangulo");
        Rectangulo re = new Rectangulo(Float.parseFloat(JOptionPane.showInputDialog("Teclee a base")),Float.parseFloat(JOptionPane.showInputDialog("Teclee a altura")));
        System.out.println("Area rectangulo = "+re.calcularArea());
        System.out.println("Perimetro rectangulo = " +re.calcularPerimetro());
        
        JOptionPane.showMessageDialog(null, "A continuacion calculos triangulo");
        Triangulo tri = new Triangulo(Float.parseFloat(JOptionPane.showInputDialog("Teclee a base")),Float.parseFloat(JOptionPane.showInputDialog("Teclee a altura")));
        System.out.println("\nArea triangulo = " + tri.calcularArea());
        System.out.println("Perimetro triangulo = " + tri.calcularPerimetro());
        */
        
        //da error por que es abstracto
        //FigurasGeometricas obxN = new FigurasGeometricas();
        
        Rectangulo obxRe = new Rectangulo(4, 2);
        System.out.println("\nArea rectangulo = "+obxRe.calcularArea());
        System.out.println("Perimetro rectangulo = " +obxRe.calcularPerimetro());
        obxRe.dibuxar();
        obxRe.rotar();
        
        Triangulo obxTri = new Triangulo(4,2);
        System.out.println("\nArea triangulo = " + obxTri.calcularArea());
        System.out.println("Perimetro triangulo = " + obxTri.calcularPerimetro());
        obxTri.dibuxar();
        obxTri.rotar();
        
        
        
    }
    
}
