import java.util.ArrayList;


public class Nodo {

	private int id;
	private String dato;
	private int lugar_id;
	private double x;
	private double y;
	private boolean visitado = false;
	
	
	
	public Nodo (int id,String dato, double x, double y)
	{
		this.id=id;
		this.dato=dato;
		this.x=x;
		this.y=y;
	}
	
	public Nodo(){
		ligas= new ArrayList<Liga>();
	}
	
	private ArrayList<Liga> ligas = new ArrayList<Liga>();

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

	public int getLugar_id() {
		return lugar_id;
	}

	public void setLugar_id(int lugar_id) {
		this.lugar_id = lugar_id;
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

	public ArrayList<Liga> getLigas() {
		return ligas;
	}

	public void setLigas(ArrayList<Liga> ligas) {
		this.ligas = ligas;
	}
	//
	public void addLiga(Liga n){
		ligas.add(n);
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	

	public String toString(){
		return dato;
	}
	
}
