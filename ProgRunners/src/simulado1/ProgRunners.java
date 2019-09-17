package simulado1;

import java.util.ArrayList;

public class ProgRunners {
	private ArrayList<Corredor> corredores;
	
	ProgRunners() {
		this.corredores = new ArrayList<Corredor>();
	}
	
	public void cadastrarCorredor(String nome, String cpf, int anoNascimento) {
		this.corredores.add( new Corredor(nome,cpf,anoNascimento) );
	}
	
	public String listarCorredores() {
		String r = "";
		for(Corredor corredor: this.corredores) {
			r += corredor.toString() + "\n";
		}
		return r;
	}
	
	
	private int pesquisarCorredor(String cpf) {
		for(int i = 0; i < this.corredores.size(); i++) {
			if(this.corredores.get(i).getCPF() == cpf) return i;
		}
		return -1;
	}
	
	public String exibirCotegoriaCorredor(String cpf) {
		return this.corredores.get(pesquisarCorredor(cpf)).getCategoria();
	}
	
	public void cadastrarTreinoCorredor(String cpf, double distancia, int tempoEsperado, String descricao){
		this.corredores.get(pesquisarCorredor(cpf)).cadastrarTreino(distancia, tempoEsperado, descricao);
	}
	
	public void finalizarTreino(String cpf, int indice, int tempoGasto) {
		this.corredores.get(pesquisarCorredor(cpf)).finalizarTreino(indice, tempoGasto);
	}
	
	public int contarTreinosFinalizadosCorredor(String cpf) {
		return this.corredores.get(pesquisarCorredor(cpf)).contarTreinosFinalizados();
	}
	
	public double resistenciaCorredor(String cpf){
		return this.corredores.get(pesquisarCorredor(cpf)).resistencia();
	}

}
