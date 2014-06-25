import java.util.ArrayList;


public class Grafo {

	//private ArrayList<Nodo> listaNodo;//nodos
	private  ArrayList<Liga> ligas; //para ligas
	
	Nodo n;
	Nodo m;
	
	public Grafo (){
		ligas = new ArrayList<Liga>();//ligas
		//listaNodo = new ArrayList<Nodo>();//nodos

	}
	
	public void start(String g){
		
	}
	
	public void addLiga(Liga n){
		ligas.add(n);
	}
	//////
	public void inicio(String dato){//ponerte al incio
		for(Liga i:ligas ){//selecion de inicio
			//System.out.println(n.getDato());
			//dibujarLiga(n);
			if(n ==  null && i.getOrigen().getDato() == dato)
			{
				
				n = i.getOrigen();
				
			}
		}
	}
	////////
	public void fin(String dato){
		for(Liga i: ligas ){
			if(m== null && i.getDestino().getDato() == dato )
			{
				m = i.getDestino();
			}
		}
		
	}
	////////
	public void recorrer(){
		System.out.println("\t" +"Recorrido");
		ArrayList<Liga> adyacentes = new ArrayList<Liga>();
		
		for(Liga i:ligas ){//recorrer ligas y poner las adyacentes
			
			//dibujarLiga(n);
			if(i.getOrigen().getDato() == n.getDato() && !i.getDestino().isVisitado())
			{
				adyacentes.add(i);
			}
			

		}
		System.out.println("\t" + n.getDato());
		
		n = pesoMenor(adyacentes);
		if(adyacentes.size() > 0 && n!=null){
			//adyacentes = null;
			this.recorrer();
		}
	}
	
	public Nodo pesoMenor(ArrayList<Liga> colecion){
		
		Liga auxl = null;
		
		for(Liga i :colecion ){
			
			if(auxl == null){auxl = i;}//colecion de adyacendias
			if(i.getPeso() < auxl.getPeso()){
				auxl = i;	
			}	
		}
		
		if(auxl!=null)
		{
			System.out.println("Peso");
			System.out.println(auxl.getPeso());//pintar el numero de nodo peso
			
			auxl.getOrigen().setVisitado(true);
			/*
			for(Liga l : ligas){
				if(l.getOrigen().getDato() == auxl.getOrigen().getDato()){
					System.out.println(l.getOrigen().isVisitado());
				}
			}
			*/
			return auxl.getDestino();
		}
		else{
			return null;
		}
		
	}
	/*
	public void dibujarLiga(Liga n){//evaluacion
		if(n.getLigas().size() > 0)
		{
			for(Liga n2: n.getLigas()){
				dibujarNodo(n2);
			}
		}
		System.out.println(n.getDato());
	}
	*/
	
	public void dibujarLiga(Liga i){
		
	}
	
}
