import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;




public class Frame  extends JFrame implements Runnable   {

	public static Graphics g2;//acceso apropiedades sintener un aestancia del metodo
	
	private int x=50;
	private int y=50;
	
	public Frame()
	{
		this.setSize(400,400);
		this.setLocation(400,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread h = new Thread(this);
		
		h.start();
	}
	
	public void paint(Graphics g)
	{
		g.drawLine(50, 50, x, y);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int p=50; p<=200; p+=10)
			{
				x=p;
				y=p;
				System.out.println(p);
				Thread.sleep(30);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
		
		

	
}
