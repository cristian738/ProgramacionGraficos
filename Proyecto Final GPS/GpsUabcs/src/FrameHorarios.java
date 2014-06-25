import javax.swing.JFrame;


public class FrameHorarios extends JFrame {
	
	
	private boolean v=false;
	public FrameHorarios(){
		this.setSize(500, 400);
		this.setVisible(true);
		setLocationRelativeTo(null);
		if(v==true ){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}

}
