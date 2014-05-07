package mx.uabcs.javaswing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

//formulario
public class FormPanel extends JPanel 
{
	private JLabel nameLabel;//texto
	private JLabel occupationLabel;//texto editar
	private JLabel nacionLabel;
	private JTextField nameField;//e
	private JTextField occupationField;
	private JTextField otros;
	
	private JButton okBtn;
	private JButton actuBtn;
	private JButton borrarBtn;
	
	private JList ageList; //lista edades
	private JComboBox  empCombo;
	
	private JRadioButton maleRadio;
	private JRadioButton femalRadio;
	private JRadioButton otherRadio;//solo para cuando se escoge una opcion 
	private ButtonGroup genderGroup;//agrupar el contenido
	private JCheckBox mexBox;
	
	
	
	private FormListener formListener;
	
	
	
	public FormPanel()
	{
		Dimension dim=getPreferredSize();//obtiene el valor del panel,sobreescritura elementos
		dim.width=250;
		setPreferredSize(dim);
		
		nameLabel= new JLabel ("NOMBRE");
		occupationLabel=new JLabel("OCUPACION");
		nacionLabel=new JLabel("NACIONALIDAD");
		nameField = new JTextField(10);
		occupationField=new JTextField(10);
		otros=new JTextField(10);
		
		ageList=new JList();
		
		empCombo = new JComboBox();//instancia
		////////
		maleRadio = new JRadioButton("Masculino");
		maleRadio.setActionCommand("Masculino");//comando
		femalRadio = new JRadioButton("Femenino");
		femalRadio.setActionCommand("Femenino");
		otherRadio = new JRadioButton("Otro");
		otherRadio.setActionCommand("Otro");
		
		genderGroup = new ButtonGroup();
		maleRadio.setSelected(true);
		genderGroup.add(maleRadio);
		genderGroup.add(femalRadio);
		genderGroup.add(otherRadio);
		//////////
		mexBox=new JCheckBox("Mexicano");//JCheckBox
		
		
		///////
		//bind enlace de datos con grafico
		DefaultListModel ageModel = new DefaultListModel();//estrutra de datos rellenar 
		ageModel.addElement(new AgeCategory(18,"18 - 35"));//guardar el id
		ageModel.addElement(new AgeCategory(36,"36 - 55"));//enlazar los datos y el grafico
		ageModel.addElement(new AgeCategory(56,"56 - Mas "));
		
		ageList.setModel(ageModel);//enlace
		ageList.setPreferredSize(new Dimension(110,70));//tamano lista
		ageList.setBorder(BorderFactory.createEmptyBorder());//borde
		
		ageList.setSelectedIndex(0);//que empieze el primero
		
		
		///////
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement(new EmployeeCategory(23,"Empleado"));//agregando
		empModel.addElement(new EmployeeCategory(28,"Por Contrato"));
		empModel.addElement(new EmployeeCategory(31,"No es Empleado"));
		empCombo.setModel(empModel);//ligar
		empCombo.setSelectedIndex(0);//posicioar en la primera
		
		mexBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(mexBox.isSelected())
				{
					otros.setEnabled(false);
				}
				else
				{
					otros.setEnabled(true);
				}
			}
		});
		
		borrarBtn = new JButton("Borrar");
		actuBtn = new JButton("Actualizar");
		
		
		
		
		okBtn=new JButton("OK");
	
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton clicked=(JButton)e.getSource();
				if(clicked==okBtn)
				{
					String name=nameField.getText();
					String occupation=occupationField.getText();
					AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();//agregar a lista , convertiri un objecto
					EmployeeCategory empCat = (EmployeeCategory)empCombo.getSelectedItem();
					
					//String valor =(String)empCombo.getSelectedItem();
					//System.out.println(empCat.getId());//mostrar el id
					//System.out.println(ageCat.getId());
					
						
					
					String edad=ageCat.toString();
					String   empliado=empCat.toString();
					//System.out.println(empliado);
					
					String gender = genderGroup.getSelection().getActionCommand();//obtener el elemento selecionado 
					//System.out.println(gender);//imprimir en consola
					
					String mex=mexBox.getText();
					String nac=otros.getText();
					String nacion;
					int empId=(empCat.getId());
					//
					if(mexBox.isSelected()){
						nacion="Mexicano";
					}
					else{
						nacion=nacionLabel.getText();
					}
					//
					
					FormEvent ev = new FormEvent(this,name,occupation,edad,empId,empliado,gender,nac,mex);//insiastar un objecto es el new								
					
					
					if(formListener !=null)
					{
						formListener.formEventOcurred(ev);	
			
					}
					
					
					
				}
		
			}
		});
		
				//borde del panel
		Border innerBorder = BorderFactory.createTitledBorder("AGREGAR PERSONA");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		setLayout(new GridBagLayout());//sirve para ser hacer tablas pero con la difrenecia de los componenetes diferentes tamanos
		
		GridBagConstraints gc = new GridBagConstraints();//guarda información de cómo y dónde añadir el componente
		
		/////first row//
		gc.weightx=1;//determinan la forma en que se van a redimencionar
		gc.weighty=0.1;//determinan la forma en que se van a redimencionar
		
		gc.gridx=0;//fila donde se coloca el componente
		gc.gridy=0;//columna donde se coloca el componente
		gc.fill=GridBagConstraints.NONE;//fill determina la forma en que un Componente rellena el área//NONE El Componente es reducido a su tamaño ideal
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets=new Insets(0,0,0,5);//poner espacio entre el borde y el componente
		add(nameLabel,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.insets=new Insets (0,0,0,0);
		gc.anchor=GridBagConstraints.LINE_START;
		add(nameField,gc);
		
		////second row/////
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.gridy=1;
		gc.insets=new Insets(0,0,0,5);
		gc.anchor=GridBagConstraints.LINE_END;
		add(occupationLabel,gc);
		
		gc.gridx=1;
		gc.gridy=1;
		gc.insets=new Insets(0,0,0,5);
		gc.anchor=GridBagConstraints.LINE_START;
		add(occupationField,gc);
		//////third row//
	
		///cuarto boton//
		gc.weightx=1;
		gc.weighty=0.2;
		
		gc.gridx=1;
		gc.gridy=2;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(ageList,gc);
		
		////ComboBox dar opcioes
		gc.weightx=1;
		gc.weighty=2.0;
		
		gc.gridx=1;
		gc.gridy=3;//sepracion de letras de utra tras otra
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(empCombo,gc);
		//////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.05;
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(maleRadio,gc);
		/////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.05;
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(femalRadio,gc);
		///////
		gc.gridy++;
		
		gc.weightx=1;
		gc.weighty=0.05;
		gc.gridx=1;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(otherRadio,gc);
		
		///////////
		
		/////////
		gc.gridy++;//incrementa la fila
		gc.weightx=1;
		gc.weighty=0.05;//espacio entre fila
		
		gc.gridx=1;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,5);
		add(nacionLabel,gc);
		
		//////////
		/////////
		gc.gridy++;//incrementa la fila
		gc.weightx=1;
		gc.weighty=0.05;//espacio entre fila
		
		gc.gridx=1;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,5);
		add(mexBox,gc);
		
		//////////
		gc.gridy++;//incrementa la fila
		gc.weightx=1;
		gc.weighty=2.0;
		
		gc.gridx=1;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(otros,gc);
		//////////
		
		gc.gridy++;//incrementa la fila
		gc.weightx=1;
		gc.weighty=0.05;
		
		gc.gridx=1;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(okBtn,gc);
		////////
		gc.gridy++;//incrementa la fila
		gc.weightx=1;
		gc.weighty=0.05;
		
		gc.gridx=1;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(borrarBtn,gc);
		///////
		gc.gridy++;//incrementa la fila
		gc.weightx=1;
		gc.weighty=0.05;
		
		gc.gridx=1;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(actuBtn,gc);
		
	}
	public void setFormListener(FormListener listener)
	{
		this.formListener=listener;
	}
	
	
	
}
//clases internas
class AgeCategory//objecto guardar lista
{
		private int id;
		private String text;
		
		public AgeCategory (int id, String text){
			this.id=id;
			this.text=text;
		}
	
		public String toString(){//imprime el texto
			return text;
		}
	
		public int getId(){//imprime el id
			return id;
		} 
}
///////
class EmployeeCategory
{

	private int id;
	private String text;
	
	public EmployeeCategory (int id, String text){
		this.id=id;
		this.text=text;
	}

	public String toString(){//imprime el texto
		return text;
	}

	public int getId(){//imprime el id
		return id;
	}
	
}




