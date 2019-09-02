package classes;

/* Comecando com objetos: DiarioDeBordo e Anotacao?
 * 
 * Por: Lívia Sampaio Campos
 * Observacao: Esse codigo é uma prova de conceito,
 * portanto, pode estar incompleto ou com algumas 
 * simplificações.
 */
public class Anotacao {
	//atributos
	private String texto;
	private String data;
	
	//construtor
	public Anotacao(String texto, String data) {
		this.data = data;
		this.texto = texto;
		
	}
	
	//metodos
	public String getTexto() {
		return texto;
	}
	
	public String getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return getTexto() + "-" + getData();
	}

}
