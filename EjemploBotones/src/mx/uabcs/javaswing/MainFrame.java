package mx.uabcs.javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private JButton btn;//boton
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel borde;//personas
	private ArrayList<FormEvent> myList;//coleccion(arreglo)
	/////
	private DataBaseLayer dbl; //intancia con la base de datos,crear conection base de datos
	
	public MainFrame()
	{
		super("Ejemplos en Clases");
		
		setLayout(new BorderLayout());
		
		myList = new ArrayList<FormEvent>();
		toolbar = new Toolbar();
		btn = new JButton("Click me");
		textPanel = new TextPanel();
		borde =  new FormPanel();
		dbl = new DataBaseLayer();
		
		toolbar.setArrayListener(myList);//pasar la lista del otro lado
		
		//insertar base de datos
		
		
		//toolbar.setTextPanel(textPanel);
		toolbar.setStringListener(new StringListener(){//este mandan una cadena

			@Override
			public void textEmitted(String text) {//regresar un parametro y lo recive textpanel
				// TODO Auto-generated method stub
			textPanel.appendText(text);	
			}
			
		});
		
		toolbar.setArrayListener(new ArrayListener(){//regresava valores

			@Override
			public void arrayEminetted(ArrayList<FormEvent> lista) {
				// TODO Auto-generated method stub
				if(dbl.isConnected()){
					ArrayList<FormEvent> list = dbl.resultQueryExec("select * from trabajador");
					for(FormEvent f: list)//desplegar todo
					{
					//System.out.println(f.getName()+" "+f.getOccupation());
						textPanel.appendText("ID: "+f.getId()+"\n"+"Nombre: "+f.getName()+"\n"+"Ocupacion: "+f.getOccupation()+"\n"+
									"Edad: "+f.getEdad()+"\n"+"Categoria: "+f.getTipo_empleado_id()+"\n"+"Genero: "+f.getGender()+"\n"+
									"Nacionalidad: "+f.getNacionalidad_id()+"\n"+"**********************************************"+"\n");	
					}

				}
				
								
			}
			
		});
		
		borde.setFormListener(new FormListener(){//nueva instancia
			
			@Override
			public void formEventOcurred(FormEvent e) {
				// TODO Auto-generated method stub
				myList.add(e);//guardalo en la lista para desplegar en el panel
				int edad=20;
				//String name=e.getName();
				//String occupation=e.getOccupation();
				//textPanel.appendText(name + " : "+ occupation + "\n");//meterlo en el panel
				if(dbl.isConnected())
				{
					String sql="INSERT INTO trabajador" + "(tipo_empleado_id,nombre,ocupacion,edad,genero,nacionalidad_id)"+
							"VAlUES('" +e.getTipo_empleado_id()+"','"+e.getName()+"','"+e.getOccupation()+"','"+e.getEdad()+"','"+e.getGender()+"','"+e.getNacionalidad_id()+"')";
					
				dbl.queryExect(sql);//Guardalo en la base datos
				}
				
				
				
			}
			
		
			
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello\n");
			}
		});
		
		add(borde,BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		
		setSize(800, 700);//tamano de la ventana
		setLocation(350,50);//posicionar ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
