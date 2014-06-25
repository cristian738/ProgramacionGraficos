import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Main extends JFrame implements ActionListener {
	
	private Logo toolbar;
	private TextPanel textPanel;
	private DatosUabcs datosUabcs;
	private FormPanel formpanel; 
	private Mapa mapa;
	private MenuFrame toolbar2;
	///////////////////
	private JMenuBar mb;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu departamentos,horariosoficina,telefonos;
    private JMenuItem gps,informacion;
    private JMenu area1,area2,area3,area4,area5,area6,area7,area8,area9;
    private JMenuItem mi1,mi2,mi3;
    private JMenuItem depa,depa2,depa3,depa4,depa5,depa6,depa7,depa8,depa9,depa10,depa11,depa12,depa13,depa14,depa15,depa16,depa17,depa18,
    depa19,depa20,depa21,depa22,depa23;
	////////////////////
	private ArrayList<Lugares> myList;//coleccion(arreglo)
	private ArrayList<FormEvent> myList2;
	private ArrayList<Nodo> listanodo = new ArrayList();
	private ArrayListNodo mundo;
	private DataBaseLayer dbl; //intancia con la base de datos,crear conection base de datos
	//textArea.setFont(new Font("ARIAL",Font.BOLD,20));
	
	public  Main()
	{
		super("                                                                                                     ********GPS UABCS********");
		
		// logo
		Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logouabcs.png"));
		setIconImage(icono);
		///
		mb=new JMenuBar();
        setJMenuBar(mb);
        //////////
        menu1=new JMenu("Opciones");
        mb.add(menu1);
        menu1.setLayout(new GridLayout(3,3));
        
        mi1=new JMenuItem("crear nodo");
        mi1.addActionListener(this);
        menu1.add(mi1);
        mi2=new JMenuItem("eliminar nodo");
        mi2.addActionListener(this);
        menu1.add(mi2);
        mi3=new JMenuItem("actualizar nodo");
        mi3.addActionListener(this);
        menu1.add(mi3);
        ///////
        menu2=new JMenu ("Informacion Estudiantil");
        mb.add(menu2);
        departamentos= new JMenu("Departamentos Academicos");
        departamentos.addActionListener(this);
        menu2.add(departamentos);
        /////
        horariosoficina= new JMenu("Horarios Oficina");
        horariosoficina.addActionListener(this);
        menu2.add(horariosoficina);
        //////
        telefonos= new JMenu("Telefonos");
        telefonos.addActionListener(this);
        menu2.add(telefonos);
        //////
        area1= new JMenu("Departamento Académico de Agronomía");
        area1.addActionListener(this);
        departamentos.add(area1);
        depa=new JMenuItem("Ingeniero Agrónomo");
        depa.addActionListener(this);
        area1.add(depa);
        depa2=new JMenuItem("Licenciatura en Administración de Agronegocios");
        depa2.addActionListener(this);
        area1.add(depa2);
        ////
        area2= new JMenu("Departamento Académico de Zootecnia");
        area2.addActionListener(this);
        departamentos.add(area2);
        depa3=new JMenuItem("Ingeniería en Producción Animal");
        depa3.addActionListener(this);
        area2.add(depa3);
        depa4=new JMenuItem("Médico Veterinario Zootecnista");
        depa4.addActionListener(this);
        area2.add(depa4);
        ////
        area3= new JMenu("Departamento Académico de Biología Marina");
        area3.addActionListener(this);
        departamentos.add(area3);
        depa5=new JMenuItem("Biología Marina 2003");
        depa5.addActionListener(this);
        area3.add(depa5);
        depa6=new JMenuItem("Biología Marina 2011");
        depa6.addActionListener(this);
        area3.add(depa6);
        //////
        area4= new JMenu("Departamento Académico de Geología Marina");
        area4.addActionListener(this);
        departamentos.add(area4);
        depa7=new JMenuItem("Geología");
        depa7.addActionListener(this);
        area4.add(depa7);
        depa8=new JMenuItem("Licenciatura en Agua");
        depa8.addActionListener(this);
        area4.add(depa8);
        ////////
        area5= new JMenu("Departamento Académico de Ingeniería en Pesquerías");
        area5.addActionListener(this);
        departamentos.add(area5);
        depa9=new JMenuItem("Ingeniería en Fuentes de Energía Renovables");
        depa9.addActionListener(this);
        area5.add(depa9);
        depa10=new JMenuItem("Ingeniería en Pesquerías");
        depa10.addActionListener(this);
        area5.add(depa10);
        ////////
        area6= new JMenu("Departamento Académico Sistemas Computacionales");
        area6.addActionListener(this);
        departamentos.add(area6);
        depa11=new JMenuItem("Ingeniería en Tecnología Computacional");
        depa11.addActionListener(this);
        area6.add(depa10);
        depa12=new JMenuItem("Licenciatura en Computación");
        depa12.addActionListener(this);
        area6.add(depa12);
        ///////
        area7= new JMenu("Departamento Académico de Ciencias Políticas y Administración Pública");
        area7.addActionListener(this);
        departamentos.add(area7);
        depa13=new JMenuItem("Licenciatura en Ciencias Políticas y Administración Pública");
        depa13.addActionListener(this);
        area7.add(depa13);
        depa14=new JMenuItem("Licenciatura en Comunicación");
        depa14.addActionListener(this);
        area7.add(depa14);
        depa15=new JMenuItem("Licenciatura en Derecho");
        depa15.addActionListener(this);
        area7.add(depa15);
        //////////
        area8= new JMenu("Departamento Académico de Economía");
        area8.addActionListener(this);
        departamentos.add(area8);
        depa16=new JMenuItem("Licenciatura en Comercio Exterior");
        depa16.addActionListener(this);
        area8.add(depa16);
        depa17=new JMenuItem("Licenciatura en Economía");
        depa17.addActionListener(this);
        area8.add(depa17);
        depa18=new JMenuItem("Turismo Alternativo");
        depa18.addActionListener(this);
        area8.add(depa18);
        ////////
        area9= new JMenu("Departamento Académico de Humanidades");
        area9.addActionListener(this);
        departamentos.add(area9);
        depa19=new JMenuItem("Licenciatura en Filosofía");
        depa19.addActionListener(this);
        area9.add(depa19);
        depa20=new JMenuItem("Licenciatura en Historia (2002)");
        depa20.addActionListener(this);
        area9.add(depa20);
        depa21=new JMenuItem("Licenciatura en Historia (2010)");
        depa21.addActionListener(this);
        area9.add(depa21);
        depa22=new JMenuItem("Licenciatura en Lengua y Literatura");
        depa22.addActionListener(this);
        area9.add(depa22);
        depa23=new JMenuItem("Licenciatura en Lenguas Modernas");
        depa23.addActionListener(this);
        area9.add(depa23);
        /////////////
        menu3=new JMenu("Ayuda");
        mb.add(menu3);
        menu3.setLayout(new GridLayout(4,3));
        gps=new JMenuItem("Informacion GPS");
        gps.addActionListener(this);
        menu3.add(gps);
        informacion=new JMenuItem("Informacion del Programa");
        informacion.addActionListener(this);
        menu3.add(informacion);
		//

		setLayout(new BorderLayout());
		
		myList = new ArrayList<Lugares>();
		dbl = new DataBaseLayer();
		toolbar = new Logo();
		//toolbar2 = new MenuFrame();
		textPanel = new TextPanel();		
		datosUabcs = new DatosUabcs();
		formpanel  = new FormPanel();
		
		mapa = new Mapa();
		DataBaseLayer con=new DataBaseLayer();
		
		
		formpanel.setArrayListNodo(new ArrayListNodo() {
			
			@Override
			public void arrayEminetted(ArrayList<Nodo> lista) {
				// TODO Auto-generated method stub
				mapa.setListanodo(lista);
				mapa.repaint();
			}
		});
		/*
		toolbar2.setArrayListener(myList2);//pasar la lista del otro lado
		
		toolbar2.setStringListener(new StringListener(){//este mandan una cadena

			@Override
			public void textEmitted(String text) {//regresar un parametro y lo recive textpanel
				// TODO Auto-generated method stub
			textPanel.appendText(text);	
			}
			
		});
		/*
		formpanel.setArrayListener(new ArrayListener(){//regresava valores

			@Override
			public void arrayEminetted(ArrayList<FormEvent> lista) {
				// TODO Auto-generated method stub
				if(dbl.isConnected()){
					ArrayList<FormEvent> list2 = dbl.resultQueryExec("select * from nodo");
					for(FormEvent f: lista)//desplegar todo
					{
					//System.out.println(f.getName()+" "+f.getOccupation());
						formpanel.appendText("ID: "+f.getId()+"\n"+"dato: "+f.getDato()+"\n"+
									"X: "+f.getX()+"\n"+"Y: "+f.getY()+"******************"+"\n");
						System.out.println(f.getId());
					}

				}
				
								
			}
			
		});*/
	/*
		formpanel.setStringListener(new FormListener(){//nueva instancia
			
			@Override
			public void formEventOcurred(FormEvent e) {
				// TODO Auto-generated method stub
				myList2.add(e);//guardalo en la lista para desplegar en el panel
				
				if(dbl.isConnected())
				{
					String sql="INSERT INTO nodo" + "(id,dato,x,y)"+
							"VAlUES('" +e.getId()+"','"+e.getDato()+"','"+e.getX()+"','"+e.getY()+"')";
					
				dbl.queryExect(sql);//Guardalo en la base datos
				}
				
				
				
			}
			
		
			
		});
		*/
		
		add(toolbar, BorderLayout.NORTH);
		add(mapa, BorderLayout.CENTER);
		add(datosUabcs, BorderLayout.SOUTH);
		add(formpanel,BorderLayout.WEST);
		//add(mapa,BorderLayout.EAST);
		setSize(900, 700);//tamano de la ventana
		setLocation(180,30);//posicionar ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);//poner la ventana
		this.setResizable(false);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Container f=this.getContentPane();
        if (e.getSource()==mi1) {
        	
        	MenuFrame menuventana = new MenuFrame();
        }
        if (e.getSource()==mi2) {
        	//EliminarNodo ventanodo= new EliminarNodo(); 
        }
        if (e.getSource()==mi3) {
            ActualizarNodo ventaActualizar= new ActualizarNodo(); 
        } 
        if(e.getSource()==area1){
        	FrameHorarios menuhorarios = new FrameHorarios();
        }
        if(e.getSource()==informacion){
        	
        	ventaInfor info = new ventaInfor();
        	
        }
        if(e.getSource()==gps){
        	
        	//ventaInfor info = new ventaInfor();
        	
        }
		
	}
	
}
