
public class Hilo2 extends Thread {

	
	public Hilo2(){
		this.start();//ejecuatar , iniciar
	}
	
	// ejecuta lo su queremos que haga el hilo
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println("Hilo2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
