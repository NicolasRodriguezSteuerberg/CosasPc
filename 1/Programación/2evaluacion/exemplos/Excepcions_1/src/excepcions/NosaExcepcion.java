/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepcions;

/**
 *
 * @author dam1
 */
public class NosaExcepcion extends Exception{
    
    public NosaExcepcion(){
        super();
    }
    
    public NosaExcepcion(String mensaxe){
        super(mensaxe);
    }
}
