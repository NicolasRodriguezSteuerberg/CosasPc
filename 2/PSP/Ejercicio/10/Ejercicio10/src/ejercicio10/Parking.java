package ejercicio10;


public class Parking {
    int []plazas = new int[5];
    // 0 -> vacio
    int flag = 1;
    int plazasLibres = 5;
    
    public Parking(){
        for (int i = 0; i < plazas.length; i++) {
            plazas[i] = 0;
        }
    }
    
    public synchronized void entrada(int numCoche) throws InterruptedException{
        while(plazasLibres==0){
            wait();
        }
        for (int i = 0; i < plazas.length; i++) {
            if(plazas[i] == 0){
                plazas[i] = numCoche;
                System.out.println("Entrada Coche " + numCoche + ", aparca en " + (i+1));
                plazasLibres--;
                System.out.println("Plazas libres: " + plazasLibres);
                break;
            }
        }
        verPlazas();
        notifyAll();
    }
    
    public synchronized void salida(int numCoche){
        for (int i = 0; i < plazas.length; i++) {
            if(plazas[i] == numCoche){
                System.out.println("Salida Coche " + numCoche);
                plazasLibres++;
                plazas[i] = 0;
            }
        }
        verPlazas();
        notifyAll();
    }
    
    public void verPlazas(){
        System.out.print("Parking: ");
        for (int i = 0; i < plazas.length; i++) {
            System.out.print("[" + plazas[i] + "] ");
        }
        System.out.println("");
    }
}
