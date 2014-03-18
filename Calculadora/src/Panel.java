import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Panel extends JPanel 
{
	private JTextArea textArea;
	private JButton operacion;
	
	public Panel ()
	{
		setLayout (new BorderLayout());
		
		operacion=new JButton("Presione Aqui");//instanciarlo
		operacion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("");
			}	
		});
		
		//textArea=new JTextArea();
		add(operacion,BorderLayout.EAST);
		//add(new JScrollPane(textArea),BorderLayout.CENTER);
	}
	

}
