

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Mapa extends JPanel implements MouseListener
{
	private BufferedImage fondoMapa;
	private int  c,x1,y1,x2,y2;
	private ArrayListNodo mundo;

	ArrayList<Nodo> listanodo = new 	ArrayList<Nodo>(); 
	public Mapa()
	{
		
		
		//imagenes
		try {
			fondoMapa=ImageIO.read(Panel.class.getResource("/Imagenes/uabcs completa.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dimension de pantalla
		Dimension dim = getPreferredSize();
		dim.height = 100;
		setPreferredSize(dim);
		
		addMouseListener(this);	
		//Border innerBorder = BorderFactory.createTitledBorder("Mapa");
		//Border outerBorder = BorderFactory.createEmptyBorder(2,2,2,2);
		//setBorder(BorderFactory.createCompoundBorder(outerBorder,null));


		
		
	}
	public void setArrayListNodo(ArrayListNodo listener){//nodo
		this.mundo=listener;
	}
	
	public ArrayList<Nodo> getListanodo() {
		return listanodo;
	}


	public void setListanodo(ArrayList<Nodo> listanodo) {
		this.listanodo = listanodo;
	}


	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawLine(50,50,150,150);

		
		g.drawImage(fondoMapa,0,0,720,500,null);
		System.out.println(listanodo.size());
		g.setColor(Color.yellow);
		for(int f=0; f<listanodo.size()-1;f++ ){
			x1=((int)listanodo.get(f).getX());
			x2=((int)listanodo.get(f+1).getX());
			y1=((int)listanodo.get(f).getY());
			y2=((int)listanodo.get(f+1).getY());
			
			
			
			g.drawLine(x1+1,y1+1,x2+1,y2+1);
			g.drawLine(x1-1,y1-1,x2-1,y2-1);
			g.drawLine(x1,y1,x2,y2);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX()+ " \n");
		System.out.println(e.getY());
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		

	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}	

	
}
