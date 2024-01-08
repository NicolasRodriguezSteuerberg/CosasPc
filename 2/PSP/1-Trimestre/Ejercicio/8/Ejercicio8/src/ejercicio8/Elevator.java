package ejercicio8;


public class Elevator {
    int floor = 0;
    boolean elevatorMoving = false;
    String state = null;
    
    public synchronized void callElevator(int floorCall, String persona) throws InterruptedException{
        int diference;
        
        while(elevatorMoving==true){
            wait();
        }
        elevatorMoving = true;
        if (floorCall!=floor){
            if(floor < floorCall){
                state = "Subiendo";
                movingElevator(floorCall, persona);
            } else{
                state = "Bajando";
                movingElevator(floorCall, persona);
            }
        } else{
            System.out.println("Ascensor abierto ya que está en el mismo piso");
        }
        elevatorMoving = false;
        notifyAll();
    }
    
    public void movingElevator(int floorDestination, String persona) throws InterruptedException{
        if(state.equals("Subiendo")){
            for (int i = floor; i <= floorDestination; i++) {
                if(floorDestination==i){
                    System.out.println("Ascensor ha llegado a su destino: " + i + "\n");
                }else{
                    System.out.println("Ascensor en el piso: " + i + " " + state + " hasta el piso " + floorDestination + " por orden de " + persona);
                }
                floor = i;
                Thread.sleep(100);
            }
        }else{
            for (int i = floor; i >= floorDestination; i--) {
                if(floorDestination==i){
                    System.out.println("Ascensor ha llegado a su destino: " + i + "\n");
                }else{
                    System.out.println("Ascensor en el piso: " + i + " " + state + " hasta el piso " + floorDestination + " por orden de " + persona);
                }
                floor = i;
                Thread.sleep(100);
            }
        }
    }
    
    
}
