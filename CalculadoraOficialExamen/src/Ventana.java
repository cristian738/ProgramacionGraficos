import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Ventana extends JFrame 
{
	
	private int altura=0;
	private int ancho=0;
	private String titulo=" ";
	
	private Texto text;
	private Teclado teclas;
	
	
	public Ventana(int altura, int ancho,String titulo)
	{
		
		setLayout(new BorderLayout());
		
		teclas = new Teclado();
		text = new Texto();
		
		teclas.setStringListener(new StringListener(){

			@Override
			public void MostrarTexto(String texto) //regresar un parametro y lo recive textpanel
			{
				// TODO Auto-generated method stub
				text.abrirText(texto);
				
			}

			
		});
		
		
		add(text,BorderLayout.NORTH);
		add(teclas,BorderLayout.CENTER);
		
		///////////////////////////////////////////
		this.setSize(ancho,altura);
		this.setTitle(titulo);
		this.setVisible(true);
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
