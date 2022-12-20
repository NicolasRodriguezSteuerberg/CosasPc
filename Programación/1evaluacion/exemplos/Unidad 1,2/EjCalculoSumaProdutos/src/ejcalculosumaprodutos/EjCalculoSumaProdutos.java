/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejcalculosumaprodutos;

/**
 *
 * @author dam1
 */
public class EjCalculoSumaProdutos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declaración atributos
        int cont=0;
        int sum=0;
        int mult=1;
        int imp=1;
        int par=2;
        
        //métodos
        while(cont<5){
            sum=sum+par; //sumamos los numeros pares
            par=par+2; //hacemos un incremento de los numeros pares
            mult=mult*imp; //multiplicamos los números impares
            imp=imp+2; //incrementamos los números impares
            cont++; //incrementamos en 1 el contador
        }
        System.out.println("O sumatorio é "+sum+"\n" +"O resultado das multiplicacións é "+ mult);
    }
    
}
