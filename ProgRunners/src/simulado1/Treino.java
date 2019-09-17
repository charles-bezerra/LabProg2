package simulado1;

public class Treino {
	private double distancia;
	private int tempoEsperado;
	private int tempoGasto;
	private String descricao;
	private String status;
	
	Treino(double distancia, int tempoEsperado, String descricao){
		this.distancia = distancia;
		this.tempoEsperado = tempoEsperado;
		this.tempoGasto = 0;
		this.descricao = descricao;
		this.status = "nao iniciado";
	}
	
	public void finalizarTreino(int tempoGasto) {
		this.tempoGasto = tempoGasto;
		this.status = "terminado";
	}
	
	public String toString() {
		return this.distancia + "Km - " + this.tempoEsperado + "min - " + this.descricao;  
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int getTempoGasto() {
		return this.tempoGasto;
	}
	
	public int getTempoEsperado() {
		return this.tempoEsperado;
	}
}
