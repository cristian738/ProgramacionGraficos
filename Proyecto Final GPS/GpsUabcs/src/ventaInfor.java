import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ventaInfor extends JFrame{
	
	public boolean f=false;
	
	private Otros otros;
	
	public ventaInfor(){
		super("Informacion del Programa");
		////
		otros = new Otros();
		Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logouabcs.png"));
		setIconImage(icono);
		////
		this.setSize(300, 400);
		this.setVisible(true);
		this.setResizable(false);
		setLocationRelativeTo(null);
		if(f==true){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		add(otros);
		
	}
	
}

class Otros extends JPanel
{
	private JLabel info;
	private JLabel info2;
	private JLabel info3;
	private JLabel info4;
	private JLabel info5;
	private JLabel info6;
	private JLabel info7;
	private JLabel info8;
	private JLabel info9;
	private JLabel info10;
	private BufferedImage imagenes;
	private BufferedImage logo;

	public Otros()
	{
		
		JLabel info = new JLabel("Trabajo de Final de Lic. Computacion");
		info.setForeground (Color.white);
		info.setFont (new Font ("Serif", Font.BOLD, 15));
		info.setBounds(5, 2, 0, 0);
		add(info);
		JLabel info2 = new JLabel("Turno Vespertino Tercer Semestre");
		info2.setForeground (Color.white);
		info2.setBounds(5, 6, 0, 0);
		add(info2);
		JLabel info3 = new JLabel("Materia: Programacion 3");
		info3.setForeground (Color.white);
		info3.setBounds(5, 7, 0, 0);
		add(info3);
		JLabel info4 = new JLabel("Proyecto: GPS");
		info4.setForeground (Color.white);
		info4.setBounds(5, 8, 0, 0);
		add(info4);
		JLabel info5 = new JLabel("Integrantes:");
		info5.setForeground (Color.white);
		info5.setBounds(5, 8, 0, 0);
		add(info5);
		
		JLabel info7 = new JLabel("Cristian Manuel Rosas Gonzalez");
		info7.setForeground (Color.white);
		info7.setBounds(5, 11, 0, 0);
		add(info7);
		JLabel info8 = new JLabel("Diego Eduardo Castro Jacinto");
		info8.setForeground (Color.white);
		info8.setBounds(5, 12, 0, 0);
		add(info8);
		JLabel info6 = new JLabel("Juan Angel Ruiz Flores");
		info6.setForeground (Color.white);
		info6.setBounds(5, 11, 0, 0);
		add(info6);
		JLabel info9 = new JLabel("Nestor Alvarez");
		info9.setForeground (Color.white);
		info9.setBounds(5, 13, 0, 0);
		add(info9);
		
		try {
			imagenes=ImageIO.read(Panel.class.getResource("/Imagenes/azulmarino.jpg"));
			logo=ImageIO.read(Panel.class.getResource("/Imagenes/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		
		g.drawImage(imagenes,0,0,500,500,null);
		g.drawImage(logo,10,140,265,200,null);
		
		
	}
	
}


