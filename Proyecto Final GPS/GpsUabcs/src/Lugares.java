
public class Lugares 
{
	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	
	
	public Lugares(int id,String nombre,String descripcion,String imagen){
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.imagen=imagen;
	}
	
	public Lugares(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String toString(){
		return nombre;
	}
	

}
