import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextPanel extends JPanel 
{
	private JTextArea textArea;
	private JButton btn;
	
	public TextPanel ()
	{
		setLayout (new BorderLayout());
		btn=new JButton("Presione Aqui");//instanciarlo
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.append("Hola\n");
			}	
		});
		
		textArea=new JTextArea();
		add(btn,BorderLayout.SOUTH);
		add(new JScrollPane(textArea),BorderLayout.CENTER);
	}
	
	//JScrollPane barra deslizadora

}
