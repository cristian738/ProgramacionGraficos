import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class MenuFrame extends JFrame  implements ActionListener{
	private boolean f=false;
	private JLabel idnodo;
	private JLabel dato;
	//private JLabel liga;
	private JLabel x;
	private JLabel y;
	private JButton crear;
	private JButton mostrarinfo;
	
	private JTextField textnodo;
	private JTextField textdato;
	//private JTextField textliga;
	private JTextField textx;
	private JTextField texty;
	private JCheckBox checkBoxEliminar;
	private JCheckBox checkBoxActualizar;
	
	//private MapaAgregar mapa =new  MapaAgregar();
	
	private BufferedImage fondo;
	private DataBaseLayer b = new DataBaseLayer();
	
	private FormListener formListener;
	private ArrayListener arrayListener;
	private StringListener textListener;//componente se comuniquen con otro , puente
	
	private String accion = "Agregar dato";
	private String datod;
	private String xd;
	private String yd;
	private String n;
	
	private int id;	
	private ArrayList<FormEvent> myList;
	public MenuFrame(){
		super("Crear Nodo");
		
		idnodo = new JLabel("idnodo:");
		
		dato = new JLabel("dato:");
	//	liga = new JLabel("liga:");
		x = new JLabel("x:");
		y = new JLabel("y:");
		crear = new JButton("crear");
		mostrarinfo= new JButton("Desplegar");
		mostrarinfo.addActionListener(this);
		textnodo= new JTextField(10);
		textdato= new JTextField(10);
	//	textliga= new JTextField(5);
		textx= new JTextField(5);
		texty= new JTextField(5);
		checkBoxEliminar = new JCheckBox("Eliminar",false);
		checkBoxActualizar = new JCheckBox("Actualizar",false); 
		
		checkBoxEliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				if(checkBoxEliminar.isSelected()){					
					textnodo.setEnabled(true);
					
					
					checkBoxActualizar.setEnabled(false);				
				}
				else{
					
					textnodo.setEnabled(false);
					
					checkBoxActualizar.setEnabled(true);
					
				}
					
				
			}});
		checkBoxActualizar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//eliminar.setEnabled(false);
				if(checkBoxActualizar.isSelected()){					
						
					textnodo.setEnabled(true);
					checkBoxEliminar.setEnabled(false);
					
					
				}
				else{
					
					textnodo.setEnabled(false);
					checkBoxEliminar.setEnabled(true);
				}
					
				
			}});
		textnodo.setEnabled(false);
		
		crear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				datod = textnodo.getText();
				xd =textx.getText();
				yd =texty.getText();
				

				if(checkBoxEliminar.isSelected()){
					
					id = Integer.parseInt(textnodo.getText());				
					if(b.isConnected())
						b.delete(id);					
				}
				else
				{					
					if(!checkBoxActualizar.isSelected()){						
						
						FormEvent ev = new FormEvent(this, datod, xd,yd);	
					
						if(formListener != null){					
							formListener.formEventOcurred(ev);					
						}	
					}
					else
					{
						id = Integer.parseInt(textnodo.getText());
						
						if(b.isConnected())
							b.update(id, datod, xd, yd);		
					}
				}	
			}
			
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		///// crear el boton de idnodo
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
		/// crear el boton dato
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=0;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(dato,gc);
		
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=1;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(textdato,gc);
		////// crear el boton liga
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=0;
		gc.gridy=2;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(checkBoxEliminar,gc);
		
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=1;
		gc.gridy=2;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(checkBoxActualizar,gc);
		////// crear el boton x
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=0;
		gc.gridy=3;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(x,gc);
		
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=1;
		gc.gridy=3;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(textx,gc);
		///// crear el boton y
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=0;
		gc.gridy=4;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(y,gc);
		
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=1;
		gc.gridy=4;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(texty,gc);
		///// crear el boton crear
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx++;
		gc.gridy=5;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(crear,gc);
		
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=4;
		gc.gridy=5;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(mostrarinfo,gc);
		
		
		gc.weightx=1;
		gc.weighty=0.2;
				
		gc.gridx=5;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_START;
		gc.insets=new Insets(0,0,0,0);
		//add(mapa,gc);
		
		
		this.setSize(400, 500);
		this.setVisible(true);
		setLocationRelativeTo(null);
		if(f==true){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked=(JButton)e.getSource();
		if(clicked == mostrarinfo)
		{
			//textPanel.appendText("Good Bye\n");
			if(arrayListener!=null)
			{
				arrayListener.arrayEminetted(this.myList);
			}
			
		}
		
	}
	
}
