import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class DatosUabcs extends JPanel  {
	
//private JButton Datosuabcs;
	private JLabel dato;
	private JLabel dato2;
	private JLabel dato3;
	private JLabel dato4;
	private JLabel dato5;
	//
	private BufferedImage fondo;
	
	
	public DatosUabcs()
	{
		dato = new JLabel("Universidad Autónoma de Baja California Sur, ");
		dato2 = new JLabel("Carretera al Sur km 5.5, ");
		dato3 = new JLabel(" La Paz, Baja California Sur, ");
		dato4 = new JLabel("Codigo Postal 23080, ");
		dato5 = new JLabel("Tel 612 123 8800, uabcs.mx");
		
		Dimension dim = getPreferredSize();
		dim.height = 60;
		setPreferredSize(dim);
		
		Border innerBorder = BorderFactory.createTitledBorder("DATOS UABCS");			
		Border outerBorder = BorderFactory.createEmptyBorder(2,2,2,2);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		try {
			fondo= ImageIO.read(Panel.class.getResource("/Imagenes/colorabajo.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gc.weightx =0;
		gc.weighty =0;
		
		gc.gridx =0;
		gc.gridy = 0;
		
		gc.fill= GridBagConstraints.NONE;
		
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(dato,gc);
		///
		gc.weightx =0;
		gc.weighty =0;
		
		gc.gridx =1;
		gc.gridy = 0;
		
		
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(dato2,gc);
		//////
		gc.weightx =0;
		gc.weighty =0;
		
		gc.gridx =2;
		gc.gridy = 0;
		
		
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(dato3,gc);
		/////
		gc.weightx =0;
		gc.weighty =0;
		
		gc.gridx =3;
		gc.gridy = 0;
		
		
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(dato4,gc);
		/////
		gc.weightx =0;
		gc.weighty =0;
		
		gc.gridx =4;
		gc.gridy = 0;
		
		
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,0);
		add(dato5,gc);
		
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		
		g.drawImage(fondo,0,0,null);//imprime imagen
		
}

}
