
public class Liga {

	private int peso;
	private Nodo origen;
	private Nodo destino;
	
	
	public Liga(Nodo origen, int peso){
		this.origen=origen;
		this.peso=peso;
		
	}

	public Liga(Nodo origen,Nodo destino,int peso){
		this.origen=origen;
		this.destino=destino;
		this.peso=peso;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public Nodo getOrigen() {
		return origen;
	}


	public void setOrigen(Nodo origen) {
		this.origen = origen;
	}


	public Nodo getDestino() {
		return destino;
	}


	public void setDestino(Nodo destino) {
		this.destino = destino;
	}
	
	
	
	
}
