import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JPanel;




public class Teclado extends JPanel implements ActionListener,Operaciones
{
	private JButton num7;
	private JButton num8;
	private JButton num9;
	private JButton div;
	private JButton num4;
	private JButton num5;
	private JButton num6;
	private JButton mul;
	private JButton num1;
	private JButton num2;
	private JButton num3;
	private JButton res;
	private JButton num0;
	private JButton punto;
	private JButton igual;
	private JButton suma;
	
	String array[] = new  String[10];
	private String opcion=" ";
	private int indice=0;
	
	
	private StringListener textOperador; //hacer un puente de comunicacion teclado stringlistener a caja de texto
	
	private String operacion;
	
	
	public Teclado()
	{
		this.setLayout(new GridLayout(4,4,3,2));//hacer una tabla //poner espacio en los botones
		//////////////////////que se mostrara
		num7=new JButton("7");
		num8=new JButton("8");
		num9=new JButton("9");
		div=new JButton("/");
		num4=new JButton("4");
		num5=new JButton("5");
		num6=new JButton("6");
		mul=new JButton("*");
		num1=new JButton("1");
		num2=new JButton("2");
		num3=new JButton("3");
		res=new JButton("-");
		num0=new JButton("0");
		punto=new JButton(".");
		igual=new JButton("=");
		suma=new JButton("+");
		//////////////////////////////Implementando actionlistener
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		div.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		mul.addActionListener(this);
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		res.addActionListener(this);
		num0.addActionListener(this);
		punto.addActionListener(this);
		igual.addActionListener(this);
		suma.addActionListener(this);
		///////////////////////////agregando
		this.add(num7);
		this.add(num8);
		this.add(num9);
		this.add(div);
		this.add(num4);
		this.add(num5);
		this.add(num6);
		this.add(mul);
		this.add(num1);
		this.add(num2);
		this.add(num3);
		this.add(res);
		this.add(num0);
		this.add(punto);
		this.add(igual);
		this.add(suma);
		
	}
	
	///////////
	//comunicacion de la interfaz 
	public void setStringListener(StringListener listener)
	{
		this.textOperador=listener;
	}
	////////////

	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		JButton click=(JButton)evento.getSource();
		
		if(click == num7)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("7");
				opcion +=num7.getText();
			}
		}
		
		if(click == num8)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("8");
				opcion +=num8.getText();

			}
		}
		if(click == num9)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("9");
				opcion+=num9.getText();
			}
		}
		if(click == div)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("/");
				array[indice]=opcion;
				indice++;
				array[indice]="/";
				indice++;	
				opcion="";
			}
		}
		if(click == num4)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("4");
				opcion+=num4.getText();
			}
		}
		if(click == num5)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("5");
				opcion+=num5.getText();				
			}
		}
		if(click == num6)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("6");
				opcion+=num6.getText();
			}
		}
		if(click == mul)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("*");
				array[indice]=opcion;
				indice++;
				array[indice]="*";
				indice++;	
				opcion="";
			}
		}
		if(click == num1)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("1");
				opcion+=num1.getText();

			}
		}
		if(click == num2)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("2");
				opcion+=num2.getText();
			}
		}
		if(click == num3)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("3");
				opcion+=num3.getText();
			}
		}
		if(click == res)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("-");
				array[indice]=opcion;
				indice++;
				array[indice]="-";
				indice++;	
				opcion="";
			}
		}
		
		if(click == num0)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("0");
				opcion+=num0.getText();

			}
		}
		if(click == punto)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto(".");
				opcion+=punto.getText();
			}
		}
		
	
		
		if(click == igual)
		{
			array[indice]=opcion;
			int resultado=0;
			
			for(indice=0;indice<array.length;indice++)
			{
				double a=0.0;
				double b=0.0;
				////////////
				int auxiliar=1;//Busca la posicion de los operadores
				int buscarMul=0,buscarDiv=0,buscarSuma=0,buscarResta=0;
				
				while(buscarMul<array.length && array[buscarMul]!="*")
					buscarMul++;
	    		while(buscarDiv<array.length && array[buscarDiv]!="/")
	    			buscarDiv++;
	    		while(buscarSuma<array.length && array[buscarSuma]!="+")
	    			buscarSuma++;
	    		while(buscarResta<array.length && array[buscarResta]!="-")
	    			buscarResta++;
	    		///////////
	    		//Jerarquia de operaciones
	    		if(buscarMul<buscarDiv)
	    		{
	    			indice=buscarMul;
	    			
	    		}
	    		else
	    			if(buscarMul>buscarDiv)
	    			{
	    				indice=buscarDiv;
	    				
	    			}
	    			else
						if(buscarSuma<buscarResta){
							indice=buscarSuma;
							
						}
			    		else
			    		{
							indice=buscarResta;
							
			    		}	
				
				if(indice<array.length)
			    	while(array[indice+auxiliar]==null)
			    	{
			    		auxiliar++;
			    	}
				
				if(indice<array.length && indice!=0 )//Busca el operador del arreglo
				{
					int entrada=0;
		    		
		    		if(array[indice]=="*")
		    			entrada +=1;
		    		if(array[indice]=="/")
		    			entrada+=2;
		    		if(array[indice]=="+")
		    			entrada +=3;
		    		if(array[indice]=="-")
		    			entrada+=4;
		    		
		    		switch(entrada)
		    		{
		    			case 1:						
		    				a=Double.parseDouble(array[indice-1]); 			 
							b=Double.parseDouble(array[indice+auxiliar]); 
							
							array[indice-1]=null;
							array[indice+auxiliar]=null;
							array[indice]=null;
							array[indice+auxiliar]=String.valueOf(multiplicacion(a,b));//convertir de double a string
							buscarMul=0;	
							resultado=indice+auxiliar;
							break;
		    			case 2:	  				
		    				a=Double.parseDouble(array[indice-1]);
							b=Double.parseDouble(array[indice+auxiliar]); 
							
							array[indice-1]=null;
							array[indice+auxiliar]=null;
							array[indice]=null;
							array[indice+auxiliar]=String.valueOf(division(a, b));							
							buscarDiv=0;
							resultado=indice+auxiliar;
							break;
		    			case 3:
		    				a=Double.parseDouble(array[indice-1]);	    				
							b=Double.parseDouble(array[indice+auxiliar]); 

							array[indice-1]=null;
							array[indice+auxiliar]=null;
							array[indice]=null;
							array[indice+auxiliar]=String.valueOf(suma(a, b));	
							buscarSuma=0;
							resultado=indice+auxiliar;
							break;
		    			case 4:
		    				a=Double.parseDouble(array[indice-1]);		    				
							b=Double.parseDouble(array[indice+auxiliar]); 

							array[indice-1]=null;
							array[indice+auxiliar]=null;
							array[indice]=null;
							array[indice+auxiliar]=String.valueOf(resta(a, b));								
							buscarResta=0;					
							resultado=indice+auxiliar;
							break;
						default:
						break;
		    		}		    		
					
					
				}
			}
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("="+array[resultado]);		
			}	
				
				
				
		}
				
	
		
		if(click == suma)
		{
			if(textOperador!=null)
			{
				textOperador.MostrarTexto("+");
				array[indice]=opcion;
				indice++;
				array[indice]="+";
				indice++;	
				opcion="";
				
			}
		}
		
	}
	@Override
	public double suma(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	@Override
	public double resta(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}
	@Override
	public double multiplicacion(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}
	@Override
	public double division(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	


	
}