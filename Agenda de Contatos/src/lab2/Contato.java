package lab2;

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private String detalhes;

	Contato(String nome, String sobrenome, String telefone){
		this(nome, sobrenome, telefone, null);
	}
	
	Contato(String nome, String sobrenome, String telefone, String detalhes){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	public String exibirContato() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}
	
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}
	
}
