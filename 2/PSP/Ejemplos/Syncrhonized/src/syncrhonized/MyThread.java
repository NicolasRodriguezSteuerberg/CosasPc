package syncrhonized;

/**
 *
 * @author dam2
 */
public class MyThread extends Thread{
    
    private String name;
    
    public MyThread(String name){
        this.name = name;
    }
    
    public void run(){
        for(int i = 0; i < 4; i++){
            Contador.cuenta(name);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
