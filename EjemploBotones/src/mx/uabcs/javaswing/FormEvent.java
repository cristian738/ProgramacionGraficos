package mx.uabcs.javaswing;

import java.util.EventObject;

public class FormEvent extends EventObject {//evento que va a suceder dentro del formulario

	private String name;
	private String occupation;
	private String ageCategory; 
	private String employeeCategory;
	private String genero;
	private String nacion;//pais
	private String defaNa;//edad
	private int id;
	
	
	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
		
	}
	public FormEvent(Object source,String name, String occupation,String ageCategory,int id,String employeeCategory,String genero ,String nacion,String defaNa  )
	{
		super(source);
		
		this.name=name;
		this.occupation=occupation;
		this.ageCategory=ageCategory;
		this.employeeCategory=employeeCategory;
		this.genero=genero;
		this.nacion=nacion;
		this.defaNa=defaNa;
		this.id=id;
	}
	
	
	public String getName() {
		return name;
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
	
	public String getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}
	public String getEmployeeCategory() {
		return employeeCategory;
	}
	public void setEmployeeCategory(String employeeCategory) {
		this.employeeCategory = employeeCategory;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNacion() {
		return nacion;
	}
	public void setNacion(String nacion) {
		this.nacion = nacion;
	}
	public String getDefaNa() {
		return defaNa;
	}
	public void setDefaNa(String defaNa) {
		this.defaNa = defaNa;
	}
	////
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
