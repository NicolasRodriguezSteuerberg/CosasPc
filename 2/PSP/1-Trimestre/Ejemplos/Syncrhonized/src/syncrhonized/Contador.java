/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syncrhonized;

/**
 *
 * @author dam2
 */
public class Contador{
    protected int contador=0;

    //Incrementar el valor actual del contador
    public synchronized int incContador(){
	this.contador+=1;
        try{
            Thread.sleep((long)(Math.random() * 100));
        }catch (InterruptedException e){
            System.out.println("Interrupción del hilo…");
        }
	return this.contador;
    }
}
/*
public class Contador {
	protected int contador=0;

	//Devuelve el valor actual del contador
	public int getContador(){
		return this.contador;
	}

	//Establece el valor actual del contador
	public void setContador(int val){
		this.contador=val;
        }
}
*/