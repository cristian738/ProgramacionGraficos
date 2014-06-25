package mx.uabcs.javaswing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
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
	private JLabel nameLabel;
	private JLabel ocupationLabel;
	private JLabel nacionalityLabel;
	private JLabel edadLabel;
	private JLabel tipoEmpleadoLabel;
	private JLabel generoLabel;	
	private JLabel idLabel;
	
	private JTextField ocupationField;
	private JTextField nemeField;
	private JTextField nacionalidad;
	private JTextField edadField;	
	private JTextField idField;
	
	private EmployeeCategory  empCat;
	
	private DataBaseLayer b = new DataBaseLayer();
	

	private String accion = "Agregar persona";
	private String gender;
	private String name;
	private String occupation;
	private String contrato;
	private String n;
	
	
	private int edadd;
	private int id;	
	
	private JComboBox empComboBox;
	private JComboBox nacionComboBox;
	
	private JRadioButton maleRadio;
	private JRadioButton famaRadio;
	private JRadioButton otherRadio;
	
	private ButtonGroup genderGroup;	
	private JCheckBox checkBoxNacionalidad;
	private JCheckBox checkBoxEliminar;
	private JCheckBox checkBoxActualizar;

	
	private JButton okBtn;
	private JButton eliminar;
	private JButton actualizar;
	
	private JList ageList;
	
	
	ArrayList<FormEvent> lista = new ArrayList <FormEvent>();
	public ArrayList<FormEvent> getLista() {
		return lista;
	}
	private FormListener formListener;
	
	public FormPanel()
	{
		Dimension dim=getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		
		
		nameLabel = new JLabel("Nombre: ");
		ocupationLabel= new JLabel("Ocupacion: ");
		nacionalityLabel = new JLabel("Nacionalidad");		
		idLabel = new JLabel("ID: ");		
		edadLabel = new JLabel("Edad: ");
		tipoEmpleadoLabel = new JLabel("Tipo de empleado: ");
		generoLabel = new JLabel("Genero");
		
		
		
		ocupationField = new JTextField(10);//cajas de texto
		nemeField = new JTextField(10);
		nacionalidad = new JTextField(10);
		edadField = new JTextField(2);
		
		idField = new JTextField(2);
		
		
		
		
		
	
		
		ageList = new JList();		
		empComboBox = new JComboBox();
		
		maleRadio = new JRadioButton("Masculino");
		maleRadio.setActionCommand("Masculino");
		maleRadio.setSelected(true);	
		
		famaRadio = new JRadioButton("Femenino");
		famaRadio.setActionCommand("Femenino");
		
		otherRadio  = new JRadioButton("Otro");
		otherRadio.setActionCommand("Otro");
		
		genderGroup = new ButtonGroup();
		
		checkBoxNacionalidad = new JCheckBox("Mexicana",true);
		
		checkBoxEliminar = new JCheckBox("Eliminar",false);
		checkBoxActualizar = new JCheckBox("Actualizar",false); 
		
		
			
		
		genderGroup.add(famaRadio);
		genderGroup.add(maleRadio);
		genderGroup.add(otherRadio);	
		
		
		// bind // enlazar lo grafico con una base de datos, tener un identificador de lo grafico
		
		//sirve para dar valores predeterminados
		DefaultListModel ageModel = new DefaultListModel();
		
		ageModel.addElement(new AgeCategory(0,"18 -35"));
		ageModel.addElement(new AgeCategory(1,"36 - 55"));
		ageModel.addElement(new AgeCategory(2,"mas de 56"));
		
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize(new Dimension(110,70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);		
		
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		
		for(Empleado e: b.resultQueryExecEmpleado())
		{
			empModel.addElement(e);
		}
		
		empComboBox.setModel(empModel);
		
		
		nacionComboBox = new JComboBox();
		
		DefaultComboBoxModel empModell = new DefaultComboBoxModel();
		
		
		for(Nacionalidad c: b.resultQueryExecNacion())
		{			
		
			empModell.addElement(c);
		}		
		nacionComboBox.setModel(empModell);
		
		checkBoxNacionalidad.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(checkBoxNacionalidad.isSelected())					
					nacionalidad.setEnabled(false);				
				
				else
					nacionalidad.setEnabled(true);
				
			}});
		checkBoxEliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				if(checkBoxEliminar.isSelected()){					
					idField.setEnabled(true);				
					checkBoxActualizar.setEnabled(false);				
				}
				else{
					
					idField.setEnabled(false);
					
					checkBoxActualizar.setEnabled(true);
					
				}
					
				
			}});
		checkBoxActualizar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				eliminar.setEnabled(false);
				if(checkBoxActualizar.isSelected()){					
						
					idField.setEnabled(true);
					checkBoxEliminar.setEnabled(false);
					
					
				}
				else{
					
					idField.setEnabled(false);
					checkBoxEliminar.setEnabled(true);
				}
					
				
			}});
	
		eliminar = new JButton("Eliminar");
		actualizar = new JButton("Actualizar");
		okBtn = new JButton("OK");
		
		eliminar.setEnabled(false);
		idField.setEnabled(false);
		nacionalidad.setEnabled(false);		
		actualizar.setEnabled(false);
		
			
		
		
		
		okBtn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {				
				// TODO Auto-generated method stub			
				name = nemeField.getText();
				occupation = ocupationField.getText();	
				
				AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();//selecciona el id de la categorya que se selecciono
				
				Empleado tipo  = (Empleado)empComboBox.getSelectedItem(); 
				Nacionalidad nacion = (Nacionalidad)nacionComboBox.getSelectedItem();
				
				//contrato = empCat.toString();				
				gender = genderGroup.getSelection().getActionCommand();	
				
				if(checkBoxEliminar.isSelected()){
					
					id = Integer.parseInt(idField.getText());				
					if(b.isConnected())
						b.delete(id);					
				}
				else
				{					
					if(!checkBoxActualizar.isSelected()){						
						edadd = Integer.parseInt(edadField.getText());				
						
						FormEvent ev = new FormEvent(this, name, occupation, edadd,tipo.getId(), gender,nacion.getId(),0);	
					
						if(formListener != null){					
							formListener.formEventOcurred(ev);					
						}	
					}
					else
					{
						id = Integer.parseInt(idField.getText());
						
						if(b.isConnected())
							b.update(id, empComboBox.getSelectedIndex(), name, occupation, edadd, gender, nacionComboBox.getSelectedIndex());		
					}
				}
			
			}});		
		
		Border innerBorder = BorderFactory.createTitledBorder(accion);			
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		///////////Firts row ///////////////////
		gc.weightx = 1;//Este campo especifica c�mo distribuir el espacio vertical extra. El gestor de dise�o bolsa de rejilla calcula el peso de una 
					   //fila para ser el weightx m�ximo de todos los componentes en una fila. Si el dise�o resultante es m�s peque�a que el �rea 
					   //verticalmente que necesita para llenar , el espacio adicional se distribuye a cada fila en proporci�n a su peso . Una fila que tiene peso 0 recibe ning�n espacio extra.
		
		gc.weighty = 0.1;//Este campo especifica c�mo distribuir el espacio horizontal extra. El controlador de distribuci�n bolsa de rejilla calcula 
		                 //el peso de una columna a ser el peso m�ximo de todos los componentes en una fila . Si el dise�o resultante es m�s peque�a que el �rea 
		                 //horizontal que necesita para llenar , el espacio adicional se distribuye a cada columna en proporci�n a su peso . Una columna que tiene 
		                 //peso 0 recibe ning�n espacio extra. Si todos los pesos son cero , todo el espacio extra aparece entre las rejillas de la celda y los bordes derecho e izquierdo .
		
		gc.gridx = 0;//Especifica la celda a la izquierda del �rea de visualizaci�n del componente, donde la celda del extremo izquierdo tiene gridx = 0.
					 //El GridBagConstraints.RELATIVE valor especifica que el componente se coloca justo a la derecha del componente que se agrega al contenedor justo antes de a�adir este componente.
		
		gc.gridy = 0;//Especifica la celda en la parte superior del �rea de visualizaci�n del componente , donde la celda m�s alta tiene Gridy = 0.
		             //El GridBagConstraints.RELATIVE valor especifica que el componente se coloca justo debajo del componente que se agrega al contenedor justo antes de a�adir este componente.
		
		gc.fill= GridBagConstraints.NONE;// Este campo se usa cuando el �rea de visualizaci�n del componente es mayor que el tama�o requerido del componente.
										 //Se determinar� si se debe cambiar el tama�o del componente 
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(nameLabel,gc);//gc se le dice donde ponerlo
		
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0,0,0,0);//insets Este campo especifica el espaciado externo del componente,
										//la cantidad m�nima de espacio entre el componente y los bordes de su �rea de visualizaci�n .
		gc.anchor=GridBagConstraints.LINE_START;
		add(nemeField, gc);		
		
		//////////////////Secind rom /////////////	
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor=GridBagConstraints.LINE_END;
		add(ocupationLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor=GridBagConstraints.LINE_START;
		add(ocupationField,gc);		
		
		//////////////////// Third row ////////////////
		//////row//////
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 2;
		
		gc.fill= GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(edadLabel,gc);
		
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weighty = 0.1;
		gc.weightx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.LINE_START;
		add(edadField,gc);			
		
		
		///////row//////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 3;
		
		gc.fill= GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(tipoEmpleadoLabel,gc);
		
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(empComboBox,gc);
		
		///////////row///////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy  = 4;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(generoLabel,gc);
		
		
		///////row//////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 5;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(maleRadio,gc);
		
		///////row//////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 6;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(famaRadio,gc);
		
		///////row//////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 7;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(otherRadio,gc);
		
		///////row//////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 8;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(nacionalityLabel,gc);	
		
		
		///////row//////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 9;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(nacionComboBox,gc);	
		
		///////row//////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 10;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(okBtn,gc);	
		
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 11;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(checkBoxEliminar,gc);	
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 12;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(checkBoxActualizar,gc);	
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 13;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.LINE_END;
		add(idLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 13;
		gc.weighty = 0.1;
		gc.weightx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.LINE_START;
		add(idField,gc);	
		
	}
	public void setFormListener(FormListener Listener)
	{
		this.formListener=Listener;
	}
	
}
///////
//clase interna  
class AgeCategory
{
	private int id;
	private String text;
	
	public AgeCategory(int id,String text)
	{
		this.id=id;
		this.text=text;
	}
	public String toString(){
		return text;
	}
	public int getId() {
		return id;
	}
	
}
///
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
//
class Nacionality
{
	private int id;
	private String nacion;
	
	public Nacionality(int id,String nacion)
	{
		this.id=id;
		this.nacion=nacion;
	}
	public String toString(){
		return nacion;
	}
	public int getId() {
		return id;
	}
	
}





