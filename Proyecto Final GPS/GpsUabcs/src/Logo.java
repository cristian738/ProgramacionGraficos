import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Logo  extends JPanel implements ActionListener
{
	//private JButton Gps;
	private BufferedImage fondo;
	//private BufferedImage logo;
	
	
	
	
	public Logo()
	{
		//menu bar
		
		
		try {
			fondo= ImageIO.read(Panel.class.getResource("/Imagenes/portada dos.png"));
			//logo= ImageIO.read(Panel.class.getResource("/Imagenes/logouabcs.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		Dimension dim = getPreferredSize();
		dim.height = 100;
		setPreferredSize(dim);
		
		Border innerBorder = BorderFactory.createTitledBorder("LOGO UABCS");			
		//Border outerBorder = BorderFactory.createEmptyBorder(2,2,2,2);
		//setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		
		
		//Gps= new JButton("lOGO UABCS");
		
		//add(Gps);
		
	}
	
	

	public void paintComponent(Graphics g){
			super.paintComponents(g);
			
			
			g.drawImage(fondo,0,0,1000,100,null);
			//g.drawImage(logo,10,10,85,85,null);
			
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
