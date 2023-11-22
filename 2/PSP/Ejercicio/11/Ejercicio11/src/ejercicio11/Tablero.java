package ejercicio11;


public class Tablero {
    private boolean tortugaMovida = false;
    private boolean liebreMovida = false;
    boolean terminado = false;
    boolean vistoSiTermino = false;
    static int posicionFinal = 70;
    int posicionTortuga = 1;
    int posicionLiebre = 1;
    
    int tiradaTortuga;
    int tiradaLiebre;
    
    public void movimientoTortuga() throws InterruptedException {

        tortugaMovida = true;
        tiradaTortuga = getNumeroRandom();
        if (tiradaTortuga > 0 && tiradaTortuga<=50){
            posicionTortuga += 3;
            
            if(posicionTortuga > posicionFinal){
                posicionTortuga = posicionFinal;
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
    
    public void movimientoLiebre() throws InterruptedException {

        liebreMovida = true;
        tiradaLiebre = getNumeroRandom();
        
        if(tiradaLiebre > 0 && tiradaLiebre <= 20){
            System.out.println("Liebre durmiendo");
            
        } else if (tiradaLiebre > 20 && tiradaLiebre <= 40){
            posicionLiebre += 9;
            if (posicionLiebre > posicionFinal){
                posicionLiebre = posicionFinal;
            }
            System.out.println("Liebre ha dado un gran salto, avanzó hasta la posicion " + posicionLiebre);
        } else if (tiradaLiebre > 40 && tiradaLiebre <= 50){
            posicionLiebre -= 12;
            if (posicionLiebre < 1){
                posicionLiebre = 1;
            }
            System.out.println("Liebre ha dado un gran resbalón, retrocedió hasta la posicion " + posicionLiebre);
        } else if (tiradaLiebre > 50 && tiradaLiebre <= 80){
            posicionLiebre ++;
            if (posicionLiebre > posicionFinal){
                posicionLiebre = posicionFinal;
            }
            System.out.println("Liebre ha dado un pequeño salto, avanzó hasta la posicion " + posicionLiebre);
        } else{
            posicionLiebre -= 2;
            if (posicionLiebre < 1){
                posicionLiebre = 1;
            }
            System.out.println("Liebre ha dado un pequeño resbalón, retrocedió hasta la posicion " + posicionLiebre);
        }

    }
    
    public int getNumeroRandom(){
        return (int) (Math.random()*101);// no coge ni el 0 ni el 101 (en teoria)
    }
    
    public  boolean comprobación() throws InterruptedException {

        if (posicionTortuga == posicionFinal || posicionLiebre == posicionFinal) {
            terminado = true;
            if (!vistoSiTermino) {
                if (posicionTortuga == posicionFinal && posicionLiebre != posicionFinal) {
                    System.out.println("Tortuga ha ganado");
                } else if (posicionTortuga != posicionFinal && posicionLiebre == posicionFinal) {
                    System.out.println("Liebre ha ganado");
                } else {
                    System.out.println("Empate");
                }
            }
            vistoSiTermino = true;
        }
        tortugaMovida = false;
        liebreMovida = false;

        return terminado;
    }
}
