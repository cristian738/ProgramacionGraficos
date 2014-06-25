import java.util.EventObject;


public class FormEvent extends EventObject//evento que va a suceder dentro del formulario
{
	//Nodo
	private int id;
	private String dato;
	private int liga;
	private double x;
	private double y;
	/////////////LUGARES/////////////
	private int idlugares;
	private String nombre;
	private String descripcion;
	private String imagen;
	////////////////////////////////
	public FormEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
		
	}
	//este utilizamos
	public FormEvent(Object sourse, int id,String dato, double x, double y)
	{
		super(sourse);
		
		this.id=id;
		this.dato=dato;
		this.x=x;
		this.y=y;		
		
	}
	public FormEvent(Object sourse,String nombre,String descripcion,String imagen  )
	{
		super(sourse);
		
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.imagen=imagen;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getLiga() {
		return liga;
	}

	public void setLiga(int liga) {
		this.liga = liga;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getIdlugares() {
		return idlugares;
	}

	public void setIdlugares(int idlugares) {
		this.idlugares = idlugares;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
