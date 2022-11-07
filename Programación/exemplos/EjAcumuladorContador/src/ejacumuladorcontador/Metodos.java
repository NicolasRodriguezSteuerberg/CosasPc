/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejacumuladorcontador;

/**
 *
 * @author dam1
 */
public class Metodos {
    public void calcularParesImpares(){
        //declaración atributos
        int i=1, par=0, impar=1, sw=0; //switch 0=par
        //metodos
        while(i<=10){
            if (sw!=0){
                par=par+i;
                sw=0;
            }
            else{
                impar=impar*i;
                sw=1;
            }
            i++;
        }
        System.out.println("A suma dos pares é "+par+"\nO produto dos impares é "+impar);
    }
}
