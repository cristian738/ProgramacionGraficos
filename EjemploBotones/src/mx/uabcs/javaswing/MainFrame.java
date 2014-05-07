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
		toolbar.setStringListener(new StringListener(){

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
					textPanel.appendText("Id"+ f.getId()+":"+"Nombre: "+f.getName()+" : "+"Ocupacion: "+ f.getOccupation()+" : "+"Edad: "+f.getAgeCategory()+" Tipo Empleado: "+ f.getEmployeeCategory()+" "+f.getGenero()+" "+"Nacionalidad"+" : "+f.getNacion()+f.getDefaNa()+"\n");
					}

				}
				
								
			}
			
		});
		
		borde.setFormListener(new FormListener(){//nueva instancia
			
			@Override
			public void formEventOcurred(FormEvent e) {
				// TODO Auto-generated method stub
				//myList.add(e);//guardalo en la lista para desplegar en el panel
				int edad=20;
				//String name=e.getName();
				//String occupation=e.getOccupation();
				//textPanel.appendText(name + " : "+ occupation + "\n");//meterlo en el panel
				if(dbl.isConnected())
				{
					
					System.out.println(e.getNacion());
				String sql="INSERT INTO trabajador(tipo_empleado,nombre,ocupacion,edad,genero,pais)"+
						"VALUES('" + e.getEmployeeCategory() +"','"+e.getName()+"','"+e.getOccupation() + "','" +edad+ "','"+e.getGenero()+"','"+e.getNacion()+"')";
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
		
		
		setSize(600, 500);//tamano de la ventana
		setLocation(350,50);//posicionar ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
