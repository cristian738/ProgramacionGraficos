import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class FormPanel extends JPanel 
{
	private JButton formBtn;
	private JButton okBtn;
	private JButton irBtn;
	private JLabel origen;
	private JLabel destino;
	private JLabel ver;
	private TextArea area;
	////
	private JComboBox origencombo;
	private JComboBox destinocombo;
	private JComboBox vercombo;
	private String i="",cadena="";
	private int contador,auxSig=0;
	private Grafo grafo;
	private int auxMenor;
	private int sumapeso;
	private ArrayListNodo mundo  ;
	
	public ArrayListener setArrayListNodo() {
		return arrayListener;
	}
	
	public ArrayListener getArrayListener() {
		return arrayListener;
	}

	//
	//private JTextField buscarfield;
	//
	private BufferedImage fondo;
	
	//private JList ageList;
	
	private DataBaseLayer b = new DataBaseLayer();
	
	
	ArrayList<FormEvent> lista = new ArrayList <FormEvent>();
	ArrayList<Nodo> nodos = new ArrayList <Nodo>();//listas nodos
	ArrayList<Nodo> nodosFinales = new ArrayList <Nodo>();
	
	ArrayList<Liga> Ligas = new ArrayList <Liga>();//listas nodos
	
	ArrayList<Lugares> lugar = new ArrayList <Lugares>();

	
	private ArrayList<FormEvent> myList;
	
	private StringListener textListener; //componente se comuniquen con otro , puente
	private ArrayListener arrayListener;
	private String n;

	private Imagen imagen;//clase interna para las imagenes
	
	
	public ArrayList<FormEvent> getLista() {
		return lista;
	}
	
	private FormListener formListener;
	
			public FormPanel()
			{
				Dimension dim=getPreferredSize();
				dim.width = 250;
				setPreferredSize(dim);
				/////
				
				
				formBtn = new JButton("FORMULARIO");
				okBtn = new  JButton("OK");
				irBtn = new  JButton("IR");
				//
				origen = new JLabel("Origen");
				destino= new JLabel("Destino");
				ver =  new JLabel("Ver");
				area = new TextArea(20,23);
				//
				origencombo = new JComboBox();
				destinocombo = new JComboBox();
				vercombo = new JComboBox();
				grafo= new Grafo();//grafo
				
				//
				//vercombo.addActionListener(this);//desplegar
				//
				/////
				/////btnorigen
				DefaultComboBoxModel modelorigen = new DefaultComboBoxModel();
				if(b.isConnected()){
					for(Nodo c: b.resultQueryExecNodo())
					{			
						modelorigen.addElement(c);
						nodos.add(c);
						
						
						
						
					}	
					
					
					
				}
				for(Nodo c: nodos)
				{			
					System.out.println(c.getDato());
					
					
					
				}	
				
				
				
				Ligas=b.resultQueryExecLiga(nodos);
				
				Nodo n = new Nodo();
				Liga l1 = new Liga();
				
				n.addLiga(l1);
				
				for(Nodo e :nodos)
				{
					
					for(Liga l : Ligas){
					//System.out.println(l);
						if(e.getId()==l.getOrigen().getId()){
							e.addLiga(l);
							
						}
					}
					
				}
				
				
									
				origencombo.setModel(modelorigen);
				/////btndestino
				DefaultComboBoxModel modeldestino = new DefaultComboBoxModel();
				if(b.isConnected()){
					for(Nodo c: b.resultQueryExecNodo())
					{			
						modeldestino.addElement(c);
					}		
				}
				destinocombo.setModel(modeldestino);
				//////
				DefaultComboBoxModel modelver = new DefaultComboBoxModel();
				if(b.isConnected()){
					for(Lugares c: b.resultQueryExecLugares())
					{			
						modelver.addElement(c);
						
					}
					
				}
				vercombo.setModel(modelver);
				///
				/*okBtn.addActionListener(new ActionListener(){
		
					private ArrayList<FormEvent> myList;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						recorrer((((Nodo)origencombo.getSelectedItem())));

						//JButton clicked=(JButton)e.getSource();
						
						//i=((Lugares)vercombo.getSelectedItem()).getImagen();
						//System.out.println(i);
						//imagen = new Imagen();
						//imagenpa = new Panel(((Lugares)vercombo.getSelectedItem()).getImagen());
						//area.append("NOMBRE : "+" "+((Lugares)vercombo.getSelectedItem()).getNombre()+"\n" +"DESCRIPCION :"+" "+ ((Lugares)vercombo.getSelectedItem()).getDescripcion()+"\n");
						 
						
						//System.out.println(((Nodo)origencombo.getSelectedItem()).getDato());
						//area.append("El Origen fue: "+((Nodo)origencombo.getSelectedItem()).getDato()+"\n");
						//area.append("El Destino fue: "+((Nodo)destinocombo.getSelectedItem()).getDato());
						//grafo.inicio(((Nodo)origencombo.getSelectedItem()).getDato());
						
						//recorrer((((Nodo)origencombo.getSelectedItem())));
						
						
						
						
					
					

						
					}
					
				});*/
				irBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println(((Lugares)vercombo.getSelectedItem()).getImagen());
					 new Imagen(((Lugares)vercombo.getSelectedItem()).getImagen(),((Lugares)vercombo.getSelectedItem()).getNombre());
					area.append("NOMBRE : "+" "+((Lugares)vercombo.getSelectedItem()).getNombre()+"\n" +"DESCRIPCION :"+" "+ ((Lugares)vercombo.getSelectedItem()).getDescripcion()+"\n");

						
					}
				});
				
				okBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						area.setText("");
						
						nodosFinales.clear();
					
						recorrer((((Nodo)origencombo.getSelectedItem())),(((Nodo)destinocombo.getSelectedItem())));//pasarle lo que recibe del combobox
						
					}
				});
				
				
				
			////////////////////
				
				
				
				try {
					fondo= ImageIO.read(Panel.class.getResource("/Imagenes/colorazul.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/////
				
				//add(formBtn);
				
			
		
				
				
				
				/////////
				Border innerBorder = BorderFactory.createTitledBorder("Gps Ubicacion");			
				Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
				setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
				////////
				setLayout(new GridBagLayout());
				GridBagConstraints gc = new GridBagConstraints();
				
				gc.weightx =1;
				gc.weighty =0.1;
				gc.gridx =0;
				gc.gridy = 0;
				gc.fill= GridBagConstraints.NONE;
				gc.anchor=GridBagConstraints.LINE_END;
				gc.insets = new Insets(0,0,0,5);
				add(origen,gc);
				/////
				gc.gridx = 1;
				gc.gridy = 0;
				gc.insets = new Insets(0,0,0,0);
				gc.anchor=GridBagConstraints.LINE_START;
				add(origencombo,gc);//
				//////////
				gc.gridy =1;
				gc.weightx = 1;
				gc.weighty = 0.01;
				gc.gridx = 0;
				gc.anchor=GridBagConstraints.LINE_END;
				gc.insets = new Insets(0,0,0,0);
				add(destino,gc);
				///
				gc.gridx = 1;
				gc.gridy = 1;
				gc.insets = new Insets(0,0,0,0);
				gc.anchor=GridBagConstraints.LINE_START;
				add(destinocombo,gc);//
				///
				gc.gridy =2;
				gc.weightx = 0;
				gc.weighty = 0.05;
				gc.gridx = 0;
				gc.fill= GridBagConstraints.NONE;
				gc.anchor=GridBagConstraints.LINE_END;
				gc.insets = new Insets(0,0,0,5);
				add(ver,gc);
				///
				gc.weightx = 0.05;
				gc.weighty = 0.05;
				gc.gridx = 1;
				gc.gridy =2;
				gc.insets = new Insets(0,0,0,0);
				gc.anchor=GridBagConstraints.LINE_START;
				add(vercombo,gc);//
				////////
				gc.gridy =3;
				gc.weightx = 0.05;
				gc.weighty = 0;
				gc.gridx = 1;
				gc.anchor=GridBagConstraints.FIRST_LINE_START;
				gc.insets = new Insets(0,0,0,0);
				add(area,gc);
				///////
				gc.gridy =4;
				gc.weightx = 3;
				gc.weighty = 0;
				gc.gridx = 1;
				gc.anchor=GridBagConstraints.LINE_END;
				gc.insets = new Insets(0,0,0,0);
				add(okBtn,gc);
				///
				gc.gridy =4;
				gc.weightx = 3;
				gc.weighty = 0;
				gc.gridx = 0;
				gc.anchor=GridBagConstraints.FIRST_LINE_START;
				gc.insets = new Insets(0,0,0,0);
				add(irBtn,gc);
				
				
			}
			////
			
			
			public void setStringListener(FormListener formListener2)
			{
				this.textListener=(StringListener) formListener2;
			}
			
			public void setArrayListener(ArrayListener listener){
				this.arrayListener=listener;
			}
			
			public void setArrayListNodo(ArrayListNodo listener){//nodo
				this.mundo=listener;
			}
			
			public void setArrayListener(ArrayList<FormEvent> list)
			{
				this.myList=list;
			}
			
			public void paintComponent(Graphics g){
				super.paintComponents(g);
				
				
				g.drawImage(fondo,0,0,null);
				
			}

			public void appendText(String text) {
				area.append(text);
			}
			//inicia el recorrrido
			public void recorrer(Nodo origen, Nodo destino){
				
				int n=b.resultQueryExecNodo().size();//numeros de nodos tamano de la lista
				//creo una matriz
				int matriz  [][]=new int[n][4];
				
				Nodo aux = origen;//no perder el nodo origen
				
				
				//rellena la matriz con ceros
				for(int i=0;i<n;i++){
					
					for(int x=0;x<4;x++){
						matriz[i][x]=0;
					}
				}
				
				//analizar los adayacentes del origen 
				matriz[aux.getId()-1][0]=aux.getId();
				matriz[aux.getId()-1][1]=1;
				matriz[aux.getId()-1][2]=0;
				matriz[aux.getId()-1][3]=-1;
				
				do
				{
					//for para recorrer las ligas 
					for(Liga e:aux.getLigas()){
						if(matriz[e.getDestino().getId()-1][1]!=1){
						matriz[e.getDestino().getId()-1][0]=e.getDestino().getId();//pararse en el renglon y esribir el id buscado
						matriz[e.getDestino().getId()-1][2]=e.getPeso();//posicionar el peso.
						matriz[e.getDestino().getId()-1][3]=aux.getId();//escrivo de donde vengo
						}
					}
					///comparar los menores
					 auxMenor=5000;
					 // para mover el auxiliar del auxiliar
					Nodo auxMen=null;

					//busca la liga con menor peso
					for(Liga e: aux.getLigas()){
						if(e.getPeso()<auxMenor&&matriz[e.getDestino().getId()-1][1]!=1){
							auxMenor=e.getPeso();
							auxMen=e.getDestino();
						}
					}
					//si es igual a 5000 quiere decir que no encontro un adyacente no marcado
						if(auxMenor!=5000){
							aux=auxMen;
						}
						//no encontro adyacentes no marcados
						if(auxMenor==5000){
							
							for(int i=0;i<n;i++){
								
								//busca el siguientre nodo a nalizar
								if(matriz[i][1]==0 && matriz[i][2]!=0 && matriz[i][2]<auxMenor){
									
									for(Nodo r: nodos){
										
										if(r.getId()==matriz[i][0]){
											aux=r;
											auxMenor=matriz[i][2];
										}
									}
								}
							}
						}
						//aqui lo marca
						matriz[aux.getId()-1][1]=1;
						//imprime la matriz 
					for(int i=0;i<n;i++){
						
						for(int x=0;x<4;x++){
							System.out.print(matriz[i][x]+" ");
						}
						
						System.out.println(" ");
					}
					
					// juan le dice a pancho que cree una list
					mundo.arrayEminetted(nodosFinales);
					
					
					contador=0;
					///checando que todos los n0dos esten marcados en la matriz
					for (int y=0;y<n;y++){
						if (matriz[y][1]==1){
							contador++;
						}
					}
					//la condicion de salida todos los nodos estan marcados
				}while(contador!=n);
				//sacando el recorrido de la matriz
				auxSig=matriz[destino.getId()-1][3];
				for(Nodo p: nodos){
					if(p.getId()==matriz[destino.getId()-1][0]){
						sumapeso+=matriz[p.getId()-1][2];
						nodosFinales.add(p);
						
						
						
					}
				}
				
				
				do{
					//agregando el recorrido final
					for(Nodo p: nodos){
						if(auxSig!=-1){
							if(p.getId()==matriz[auxSig-1][0]){
								sumapeso+=matriz[p.getId()-1][2];
								nodosFinales.add(p);
								auxSig=matriz[p.getId()-1][3];
								
								
							}
						}
					
					
				}
					
				}while(auxSig!=-1);
			
				
				//imprime la lista al reves
				ListIterator iter = nodosFinales.listIterator(nodosFinales.size());
				while (iter.hasPrevious())
					
				     cadena+=iter.previous()+" \n";
				
				//imprime la distrancia
				cadena+="Con Una Distancia De: "+String.valueOf(sumapeso) +" Metros ";
				appendText(cadena);
				//resetea el peso
				sumapeso=0;
				
			}
			
			
			
		}

///////////////////////////////////////////////
class Imagen extends JFrame
{
	//private FormPanel n;
	private boolean f=true;
	private Panel otros;
	
	public Imagen(String n,String titulo)
	{
		
		super ("Imagen Del Departamento");
	
		otros = new Panel(n);
		
		// logo
		Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logouabcs.png"));
		setIconImage(icono);
		
		setSize(500, 500);//tamano de la ventana
		setLocation(500,130);//posicionar ventana
		setVisible(true);//poner la ventana
		if(f==false)
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		setTitle(titulo);
		this.setResizable(false);
		
	add(otros);
	}
	

}


class Panel extends JPanel
{
	private BufferedImage imagenes;
	
	public Panel(String n){
		
		try {
			imagenes=ImageIO.read(Panel.class.getResource(n));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		
		
		g.drawImage(imagenes,0,0,500,500,null);
		
	}
}