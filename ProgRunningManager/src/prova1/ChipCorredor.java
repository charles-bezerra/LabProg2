package prova1;

public class ChipCorredor {
	private int codigo;
	private int tempoGasto;
	private int distanciaPercorrida;
	
	ChipCorredor(int codigo){
		this.codigo = codigo;
		this.tempoGasto = 0;
		this.distanciaPercorrida = 0;
	}
	
	public int velocidadeMedia() {
		return this.distanciaPercorrida / this.tempoGasto;
	}
	
	public void setDistancia(int distanciaKm) {
		this.distanciaPercorrida = distanciaKm;
	}
	
	public void setTempo(int tempoMin) {
		this.tempoGasto = tempoMin;
	}
	
	public int getTempo() {
		return this.tempoGasto;
	}
	
	
	public String toString() { 
		return this.codigo + " - " + this.tempoGasto + "km - " + this.tempoGasto + "min"; 
	}
	
}

