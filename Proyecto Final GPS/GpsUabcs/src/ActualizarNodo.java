

import javax.swing.JFrame;

public class ActualizarNodo extends JFrame{
	private boolean f=false;
	
	ActualizarNodo(){

		this.setSize(300, 400);
		this.setVisible(true);
		setLocationRelativeTo(null);
		if(f==true){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

}
