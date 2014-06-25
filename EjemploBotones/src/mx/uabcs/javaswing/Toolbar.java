package mx.uabcs.javaswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel  implements ActionListener{
	private JButton helloButton;
	private JButton goodbyeButton;
	private JButton mostrarinfo;
	private JButton actualizar;
	private JButton eliminar;
	//private TextPanel textPanel;
	private int accion=0;	
	private ArrayList<FormEvent> myList;
	
	private StringListener textListener; //componente se comuniquen con otro , puente
	private ArrayListener arrayListener;
	
	
	public Toolbar() {
		//helloButton = new JButton("Hello");
		//goodbyeButton = new JButton("Goodbye");
		mostrarinfo= new JButton("Desplegar");
		actualizar= new JButton("Actualizar");
		eliminar= new JButton("Borrar");
		
		//helloButton.addActionListener(this);
		//goodbyeButton.addActionListener(this);
		mostrarinfo.addActionListener(this);
		actualizar.addActionListener(this);
		eliminar.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//add(helloButton);
		//add(goodbyeButton);
		add(mostrarinfo);
		//add(actualizar);
		//add(eliminar);
		
		
	}
	
	//pasasr text panel
	/*public void setTextPanel(TextPanel textPanel ){
		this.textPanel=textPanel;
	}
	*/
	public void setStringListener(StringListener listener)
	{
		this.textListener=listener;
	}
	
	public void setArrayListener(ArrayListener listener){
		this.arrayListener=listener;
	}
	
	public void setArrayListener(ArrayList<FormEvent> list)
	{
		this.myList=list;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		JButton clicked=(JButton)evento.getSource();
		/*
		if(clicked == helloButton)
		{
			if(textListener!=null)
			{
			//textPanel.appendText("Hello\n");
			textListener.textEmitted("Hello\n");
			}
		}
		else if(clicked == goodbyeButton)
		{
			//textPanel.appendText("Good Bye\n");
			if(textListener!=null)
			{
				textListener.textEmitted("Good bye\n");
			}
		}
		*/
		if(clicked == mostrarinfo)
		{
			//textPanel.appendText("Good Bye\n");
			if(arrayListener!=null)
			{
				arrayListener.arrayEminetted(this.myList);
			}
			
		}
		else if(clicked == actualizar){
			//textPanel.appendText("goodbyeButton\n");	
			if(textListener != null){
				textListener.textEmitted("Actualizar\n");
				
			}
		}
		else if(clicked == eliminar){						
			if(textListener != null){
				textListener.textEmitted("Eliminar\n");	
				
			}
			
		}
		
		
	}
	public int getAccion() {
		return accion;
	}	
}
