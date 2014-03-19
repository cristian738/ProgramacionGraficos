import java.awt.BorderLayout;
//import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;;


public class Texto extends JPanel
{
	private JTextArea text;
	
	public Texto()
	{
		text = new JTextArea(3,1);
		
		setLayout(new BorderLayout());
		
				//text.setPreferredSize(new Dimension (0,50));
				text.setFont(new Font( "ARIAL",Font.BOLD,20 ));
				//text.setEditable(true);

		add(text,BorderLayout.CENTER);//divide el cuadro
	}
	
	public void abrirText(String texto)//se implementa con la interfaz Stringlistener 
	{
		text.append(texto);
	}

}
