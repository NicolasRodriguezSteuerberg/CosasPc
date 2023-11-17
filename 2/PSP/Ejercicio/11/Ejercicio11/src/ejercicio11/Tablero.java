package ejercicio11;


public class Tablero {
    
    boolean terminado = false;
    
    int posicionTortuga = 1;
    int posicionLiebre = 1;
    
    int tiradaTortuga;
    int tiradaLiebre;
    
    public void movimientoTortuga(){
        tiradaTortuga = getNumeroRandom();
        if (tiradaTortuga > 0 && tiradaTortuga<=50){
            posicionTortuga += 3;
            
            if(posicionTortuga>70){
                posicionTortuga = 70;
            }
            
            System.out.println("Tortuga ha usado avance rápido, avanzó hasta la posicion " + posicionTortuga);
            
        } else if(tiradaTortuga > 50 && tiradaTortuga <= 70){ //esvarou
            posicionTortuga -= 6;
            
            if (posicionTortuga < 1){
                posicionTortuga = 1;
            }
            
            System.out.println("Tortuga se ha resvalado, retrocedió hasta la posicion " + posicionTortuga);
            
        } else{ //avance lento
            posicionTortuga ++;
            System.out.println("Tortuga ha usado avance lento, avanzó hasta la posicion " + posicionTortuga);
        }
    }
    
    public void movimientoLiebre(){
        tiradaLiebre = getNumeroRandom();
        
        if(tiradaLiebre > 0 && tiradaLiebre <= 20){
            System.out.println("Liebre durmiendo");
            
        } else if (tiradaLiebre > 20 && tiradaLiebre <= 40){
            tiradaLiebre += 9;
            System.out.println("");
        }
        
    }
    
    public int getNumeroRandom(){
        return (int) (Math.random()*101);// no coge ni el 0 ni el 101 (en teoria)
    }
    
    public boolean comprobación(){
        if(posicionTortuga == 70 || posicionLiebre == 70){
            terminado = true;
            if(posicionTortuga == 70 && posicionLiebre != 70){
                System.out.println("Tortuga ha ganado");
            } else if (posicionTortuga != 70 && posicionLiebre == 70){
                System.out.println("");
            } else {
                System.out.println("Empate");
            }
        }
        return terminado;
    }
}
