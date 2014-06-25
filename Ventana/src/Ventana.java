import javax.swing.JButton; //libreria botones
import javax.swing.JFrame; //libreria ventana


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
		btn=new JButton("HOLA MUNDO GRAFICOS");
		this.add(btn);
		
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
