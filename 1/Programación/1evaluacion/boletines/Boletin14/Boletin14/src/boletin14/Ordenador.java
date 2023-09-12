/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin14;
import com.nico.partes.*;
/**
 *
 * @author dam1
 */
public class Ordenador {
    
    private float precio;
    
    private Monitor obxMo = new Monitor();
    private Teclado obxTe = new Teclado();
    private Cpu obxCpu = new Cpu();
    
    
    public Ordenador(){}
    
    public Ordenador(float mo, String te, int pro, float preci){
        obxMo.setPulgadas(mo);
        obxTe.setMarca(te);
        obxCpu.setVelocidade(pro);
        precio = preci;
    }

    @Override
    public String toString() {
        return "O precio do teu ordenador é de " + precio + "\n"+
               obxMo+"''" + "\n" + obxTe + "\n" + obxCpu + " MHz\n";
    }
    
    public Monitor getMonitor(){
        return obxMo;
    }
 
    public Teclado getTeclado(){
        return obxTe;
    }
    
    public Cpu getCpu(){
        return obxCpu;
    }
    
    public float getPrecio(){
        return precio;
    }
    
}
