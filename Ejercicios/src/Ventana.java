import java.awt.BorderLayout;

import javax.swing.JButton; //libreria botones
import javax.swing.JFrame; //libreria ventana
import javax.swing.JTextArea;


public class Ventana extends JFrame
{
	private int altura=0;
	private int ancho=0;
	private String titulo=" ";
	JButton btn; 					 //BOTON
	
	
	public Ventana(int altura, int ancho, String titulo)
	{
		this.setSize(ancho,altura);
		this.setTitle(titulo);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//layout posicionar boton
		btn=new JButton("HOLA MUNDO GRAFICOS");
		setLayout (new BorderLayout());  //como se va a comportar
		this.add(btn,BorderLayout.NORTH);//donde lo vas a posicionar
	    add(new JButton("Sur"),BorderLayout.SOUTH);
	    add(new JButton("Oeste"),BorderLayout.WEST);
	    add(new JButton("Este"),BorderLayout.EAST);
	    add(new TextPanel(),BorderLayout.CENTER);
		
	}
	public Ventana()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
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
