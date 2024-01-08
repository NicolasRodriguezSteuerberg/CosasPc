package syncrhonized;

/**
 *
 * @author dam2
 */
class ContadorHilo extends Thread
{
	Contador cont;
        
	public ContadorHilo(String p_nombre, Contador p_cont){
		super(p_nombre);
		this.cont=p_cont;
	}
        
        public void run(){
            for (int i=0;i<4;i++){
                System.out.println(getName() + " - contador: " + cont.incContador());
            }
		System.out.println("Fin "+getName()+"...");
	}

	//Método para incrementar el contador
        /*
	public void run()
	{
		for (int i=0;i<4;i++)
		{
			try
			{
				int a = cont.getContador();
				sleep((long)(Math.random()*10));
				cont.setContador(a+1);
				System.out.println(getName()+" - contador: "+cont.getContador());

				sleep((long)(Math.random()*10));
			}catch (InterruptedException e)
			{
				System.out.println("Interrupción del hilo…");
}
		}
		System.out.println("Fin "+getName()+"...");
	}
*/
}

