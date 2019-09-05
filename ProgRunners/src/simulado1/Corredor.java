package simulado1;
import java.util.ArrayList;

public class Corredor {
	private String nome;
	private String cpf;
	private int anoNascimento;
	private int anoAtual;
	private ArrayList<Treino> treinos;

	Corredor(String nome, String cpf, int anoNascimento){
		this.nome = nome;
		this.cpf = cpf;
		this.anoNascimento = anoNascimento;
		this.anoAtual = 2019;
		this.treinos = new ArrayList<Treino>();
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public String getCategoria() {
		int dif = this.anoAtual - this.anoNascimento;
		
		if(dif >= 15 && dif < 25) return "JOVEM";
		else if(dif >= 25 && dif < 41) return "ADULTO";
		else if(dif >= 41 && dif < 65) return "SUPER_ADULTO";
		else if(dif >= 65) return "MELHOR_IDADE";
		else return "IDADE INVÁLIDA";
	}
	
	public String toString() {
		return this.nome + " - " + this.cpf + " - " + this.anoNascimento;
	}
	
	public boolean equals(Object outro) {
		if(outro == null)
			return false;
		
		Corredor outroCorredor = (Corredor) outro;
		
		if(this.cpf == outroCorredor.getCPF())
			return true;
		return false;
	}
	
	
	public void cadastrarTreino(double distancia, int tempoEsperado, String descricao){
		this.treinos.add( new Treino(distancia,tempoEsperado,descricao) );
	}
	

	public void finalizarTreino(int indice, int tempoGasto) {
		this.treinos.get(indice - 1).finalizarTreino(tempoGasto);
	}

	public int contarTreinosFinalizados() {
		int contador = 0;
		for(Treino treino: this.treinos) {
			if(treino.getStatus() == "finalizado") contador++;
		}
		return contador;
	}
	
	public double resistencia() {
		double media = 0;
		int cont = 0;
		for(Treino treino: this.treinos) {
			if(treino.getStatus() == "finalizado") {
				if( treino.getTempoEsperado() - treino.getTempoGasto() > 0) media += 1;
				else if(treino.getTempoEsperado() - treino.getTempoGasto() < 0) media -= 1;
				else media += 0; 
				cont++;
			}
		}
		if(cont > 0) media /= cont;
		return media;
	}

}
