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
	//private JButton actuButton;
	//private JButton borrarButton;
	//private TextPanel textPanel;
	
	private ArrayList<FormEvent> myList;
	
	private StringListener textListener; //componente se comuniquen con otro , puente
	private ArrayListener arrayListener;
	
	
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		mostrarinfo= new JButton("Desplegar");
		//actuButton= new JButton("Actualizar");
		//borrarButton= new JButton("Borrar");
		
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		mostrarinfo.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);
		add(mostrarinfo);
		
		
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
		else if(clicked == mostrarinfo)
		{
			//textPanel.appendText("Good Bye\n");
			if(arrayListener!=null)
			{
				arrayListener.arrayEminetted(this.myList);
			}
		}
		
		
		
	}
}
