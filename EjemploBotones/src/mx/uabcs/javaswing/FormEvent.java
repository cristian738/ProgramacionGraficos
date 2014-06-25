package mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject {//evento que va a suceder dentro del formulario

	private String name=null;
	private String occupation=null;
	private int edad=0;
	private int tipo_empleado_id;
	private String gender=null;
	private int nacionalidad_id;
	private int id;
	//////////////
	private String name2=null;
	private String tipo=null;
	private String nacion=null;
	/////////////
	
	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
		
	}
	public FormEvent(Object sourse, String name, String occupation, int edad, int tipo_empleado_id, String gender,int nacionalidad_id,int id)
	{
		super(sourse);
		this.name = name;
		this.occupation = occupation;	
		this.edad = edad;		
		this.tipo_empleado_id = tipo_empleado_id;
		this.gender = gender;
		this.nacionalidad_id = nacionalidad_id;
		this.id=id;
	}
	public FormEvent(Object sourse,String name2,String tipo,String nacion )
	{
		super(sourse);
		this.name2=name2;
		this.tipo=tipo;
		this.nacion=nacion;
	}
	
	public int getNacionalidad_id() {
		return nacionalidad_id;
	}
	public void setNacionalidad_id(int nacionalidad_id) {
		this.nacionalidad_id = nacionalidad_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTipo_empleado_id() {
		return tipo_empleado_id;
	}
	public void setTipo_empleado_id(int tipo_empleado_id) {
		this.tipo_empleado_id = tipo_empleado_id;
	}
	public String getName() {
		return name;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}
