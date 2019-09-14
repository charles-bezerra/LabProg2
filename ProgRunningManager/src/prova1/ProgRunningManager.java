package prova1;

public class ProgRunningManager {
	private Corrida[] corridas;
	private int index;
	
	ProgRunningManager(){
		this.corridas = new Corrida[50];
	}
	
	
	public void cadastrarCorrida(String nomeCorrida, String data, int qtdParticipantes) {
		this.corridas[index++] = new Corrida(nomeCorrida,data,qtdParticipantes);
	}
	
	public int cadastrarChipCorrida(String nomeCorrida) {
		return this.corridas[pesquisarCorrida(nomeCorrida)].cadastrarChip();
	} 
	
	public int pesquisarCorrida(String nomeCorrida) {
		for(int i = 0; i < this.corridas.length; i++) {
			if(this.corridas[i] == null) break;
			if(this.corridas[i].getNome() == nomeCorrida) return i;
		}
		return -1;
	}
	
	public String listarCorrida(String nomeCorrida) {
		int i = pesquisarCorrida(nomeCorrida);
		if(i != -1) {
			return this.corridas[i].toString();
		}
		return "CORRIDA_NAO_ENCONTRADA";
	}
	
	public int contarChipsCorrida(String nomeCorrida) {
		int i = pesquisarCorrida(nomeCorrida);
		if(i != -1) {
			return this.corridas[i].contarChips();
		}
		return 0;
	}
	
	public String exibirCorredor(String nomeCorrida, int codigoChip) {
		int i = pesquisarCorrida(nomeCorrida);
		if(i != -1) {
			return this.corridas[i].exibirCorredor(codigoChip);
		}
		return "CHIP_NAO_ENCONTRADO";
	}
	
	public void atualizaChipDistanciaTempo(String nomeCorrida, int codigoChip, int distanciaKm, int tempoMin) {
		this.corridas[ pesquisarCorrida(nomeCorrida) ].atualizarChipDistanciaTempo(codigoChip, distanciaKm, tempoMin);
	}
	
	public void finalizaCorrida(String nomeCorrida) {
		this.corridas[pesquisarCorrida(nomeCorrida)].finalizaCorrida();
	}

	
	public int velocidadeMediaCorrida(String nomeCorrida) {
		return this.corridas[pesquisarCorrida(nomeCorrida)].velocidadeMedia();
	}
	
	public int menorTempoCorrida(String nomeCorrida) {
		return this.corridas[pesquisarCorrida(nomeCorrida)].menorTempo();
	}
	
	public int vencedorCorrida(String nomeCorrida) {
		return this.corridas[pesquisarCorrida(nomeCorrida)].vencedorCorrida();
	} 


}
