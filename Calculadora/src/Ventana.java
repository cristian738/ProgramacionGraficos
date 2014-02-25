import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Ventana extends JFrame
{
	private int altura=0;
	private int ancho=0;
	private String titulo=" ";
	JButton sum; 					 //BOTONES
	JButton res;
	JButton mul;
	JButton div;
	JButton total;
	
	private JButton num1,num2,num3,num4,num5,num6,num7,num8,num9,num0;
	private JTextArea area;
	private JTextArea area2;

	
	public Ventana(int altura, int ancho, String titulo)
	{
		this.setSize(ancho,altura);
		this.setTitle(titulo);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		////////////////////////////////////////
		sum=new JButton("+");
		res=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		total=new JButton("=");
		////////////////////////
		num0 = new JButton("0");
		
		num1 = new JButton("1");
	    
		num2 = new JButton("2");	
		
		num3 = new JButton("3");	    
       	num4 = new JButton("4");     
       	num5 = new JButton("5");	     
       	num6 = new JButton("6");  
       	num7 = new JButton("7");
       	num8 = new JButton("8"); 
       	num9 = new JButton("9");
		///////////
    	area = new JTextArea("0");
    	area2 = new JTextArea("0");
       	///////
		setLayout (new BorderLayout());
		//////
		
		this.add(sum,BorderLayout.NORTH);
		this.add(res,BorderLayout.WEST);
		this.add(mul,BorderLayout.EAST);
		this.add(div,BorderLayout.SOUTH);
		this.add(total,BorderLayout.CENTER);
		add(new Panel(),BorderLayout.EAST);
		
	
      
			
		
		
	}
	
	
	////////////////////////////////////////
	public void setaltura(int altura)
	{
		this.altura=altura;
	}
	
	public void setancho(int ancho)
	{
		this.ancho=ancho;
	}
	public void setitulo(String titulo)
	{
		this.titulo=titulo;
	}
	
	public void mostrar()
	{
		this.setVisible(true);
		this.setSize(ancho,altura);
		this.setTitle(titulo);
	}
	

}
