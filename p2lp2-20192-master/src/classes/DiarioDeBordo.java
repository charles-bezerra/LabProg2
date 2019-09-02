package classes;
/* Comecando com objetos: como transformar esse codigo procedural
 * em um codigo Orientado a Objetos?
 * 
 * Por: Lívia Sampaio Campos
 * Observacao: Esse codigo é uma prova de conceito,
 * portanto, pode estar incompleto ou com algumas 
 * simplificações.
 */
public class DiarioDeBordo {
	private Anotacao[] anotacoes;
	private int qtdEntradas;
	
	public DiarioDeBordo(int tamanho) {
		anotacoes = new Anotacao[tamanho];
	}
	
	public void anotar(String texto, String data) {
		if(temEspaco()) {
			anotacoes[qtdEntradas++] = new Anotacao(texto, data);
		}
	}
	
	public boolean temEspaco() {
		return qtdEntradas < anotacoes.length;
	}
	
	public String listar() {
		String resultado = "";
		for (int i = 0; i < qtdEntradas; i++) {
			resultado += anotacoes[i].toString() + System.lineSeparator();
		}
		return resultado;
	}
	public String pesquisar(int index) {
		return anotacoes[index].getTexto();
	}
}
