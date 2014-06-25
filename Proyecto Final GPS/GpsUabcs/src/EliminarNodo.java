import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class EliminarNodo extends JFrame{
	private boolean f=false;
	private JLabel idnodo;
	private JTextField textnodo;
	private JButton eliminar;
	
	public EliminarNodo(){
		
		super("Eliminar Nodo");
		idnodo= new JLabel("idnodo:");
		textnodo=new JTextField(10);
		eliminar = new JButton("eliminar");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		/////crear jlabel y jtextfield de eliminar nodo
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(0,0,0,5);
		gc.anchor=GridBagConstraints.LINE_END;
		add(idnodo,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.insets=new Insets(0,0,0,5);
		gc.anchor=GridBagConstraints.LINE_START;
		add(textnodo,gc);
		//// crear boton jbutton eliminar
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=1;
		gc.gridy=5;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(eliminar,gc);
		
		
		
		
		
		
		this.setSize(300, 400);
		this.setVisible(true);
		setLocationRelativeTo(null);
		if(f==true){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}

}
