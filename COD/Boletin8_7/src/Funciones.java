import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Funciones {
    public void mostrarMenu(){
        System.out.println("Muestro menu");
    }
    public int introducirOpcion(){
        Scanner obxS=new Scanner(System.in);
        System.out.println("Introduzca una opcion\n1 cuadrado\n2 triangulo\n3 circunferencia");
        int n=obxS.nextInt();
        return n;
    }
    public int introducirNumero(){
        int n= Integer.parseInt(JOptionPane.showInputDialog("Introduzca numero"));
        return n;
    }
    public int calcularAreaCuadrado(int l){
        int area=l*l;
        return area;
    }
    public int calcularAreaTriangulo(int b, int h){
        int area=b*h;
        return area;
    }
    public int calcularAreaCircunferencia(int r, int p){
        int area=r*r*p;
        return area;
    }
    public void mostrarArea(int a){
        System.out.println(a);
    }
}
