/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calendario;

/**
 *
 * @author marcosfa
 */
public class Calendario2 {
   //atributos
   int dia;
   int mes;
   int ano;
   
   //constructores
   public Calendario2(){};  //por defecto
   
   public Calendario2(int d, int m, int a){ //parametrizado
       if (d > 0 && d <=31){
           dia = d;
       }
       else if (d > 31){
           dia = 1;
           m++;
       }
       
       if (m > 0 && m <= 12){
           mes = m;
       }
       else if (m > 12){
           mes = 1;
           a++;
       }
       if (a > 0){
           ano = a;
       }
   }
   
   //setters && getters
   public void setDia(int d){
       dia = d;
   }
   
   public int getDia(){
       return dia;
   }
   
   public void setMes(int m){
       mes = m;
   }
   public int getMes(){
       return mes;
   }
   
   public void setAno(int a){
       ano = a;
   }
   public int setAno(){
       return ano;
   }
      
   public void mostrar(){
       if (dia > 0 && mes > 0 && ano > 0){
        System.out.println("Dia = " + dia +"\nMes = " + mes + "\nAno = " + ano + "\n");
       }
       else{
           System.out.println("Esa data non existe");
       }
   }
}
