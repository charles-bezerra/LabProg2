package prova1;

public class Corrida {
	private String nome;
	private ChipCorredor[] chipsCorredores;
	private String estado;
	private String data;
	private int index;
	
	Corrida(String nome, String data, int quantidadeMaximaCorredores){
		this.nome = nome;
		this.data = data;
		this.chipsCorredores = new ChipCorredor[quantidadeMaximaCorredores];
		this.estado = "NAO_CONCLUIDA";
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getData() {
		return this.data;
	}
	
	public int cadastrarChip() {
		index++;
		this.chipsCorredores[index] = new ChipCorredor(index);
		return index;
	}
	
	public String listarChipsCadastrados() {
		String r = "";
		int cont = 0;
		for(ChipCorredor chip: this.chipsCorredores)
			if(chip != null) { r +=  chip.toString() + "\n"; cont++; }
		if(cont == 0)
			return "";
		return r;
	}
	
	
	public int contarChips() {
		int qtd = 0;
		for(int i = 0; i < this.chipsCorredores.length; i++) {
			if(this.chipsCorredores[i] == null) break;
			else qtd++;
		}
		return qtd;
	}
	
	public String exibirCorredor(int codigoChip) {
		return this.chipsCorredores[codigoChip].toString();
	}
	
	
	public void atualizarChipDistanciaTempo(int codigoChip, int distanciaKm, int tempoMin) {
		this.chipsCorredores[codigoChip].setDistancia(distanciaKm);
		this.chipsCorredores[codigoChip].setTempo(tempoMin);
	}
	
	
	public void finalizaCorrida() {
		this.estado = "CONCLUIDO";
	}
	
	
	public int velocidadeMedia() {
		int cont = 0;
		int media = 0;
		for(ChipCorredor corredor: this.chipsCorredores) {
			if(corredor == null) break;
			media += corredor.velocidadeMedia();
			cont++;
		}
		return (int) media/cont;
	}
	
	public int menorTempo() {
		int menor = (this.chipsCorredores[0] != null) ? this.chipsCorredores[0].getTempo() : 0;
		for(ChipCorredor corredor: this.chipsCorredores) {
			if(corredor == null) break;
			if(corredor.getTempo() < menor) {
				menor = corredor.getTempo();
			}
		}
		return menor;
	}
	
	public int vencedorCorrida() {
		int menor = (this.chipsCorredores[0] != null) ? this.chipsCorredores[0].getTempo() : 0;
		int i = 0;
		int vencedor = 0;
		for(ChipCorredor corredor: this.chipsCorredores) {
			if(corredor == null) break;
			if(corredor.getTempo() < menor) {
				menor = corredor.getTempo();
				vencedor = i;
			}
			i++;
		}
		if(this.estado != "CONCLUIDO")
			return -1;
		return vencedor;
	}
	
	public String toString() {
		return this.nome + " - " + this.data + " - " + this.estado;
	}
	
	
}
