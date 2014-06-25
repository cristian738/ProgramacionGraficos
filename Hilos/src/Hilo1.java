import java.awt.Color;
import java.awt.Graphics;


public class Hilo1 extends Thread {

	Graphics g;
	
	public Hilo1(Graphics g){
		this.g=g;
		this.start();//ejecuatar , iniciar
	}
	
	// ejecuta lo su queremos que haga el hilo
	public void run()
	{	
		this.paint(g);
	}
	
	public void paint (Graphics g){
		
	}
	
	
	
}
