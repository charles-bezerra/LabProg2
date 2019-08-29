package lab2;

public class Agenda {
	private String nomeAgenda;
	private Contato[] contatos;
	
	Agenda(String nomeAgenda){
		this.contatos = new Contato[100];
		this.nomeAgenda = nomeAgenda;
	}
	
	public String listarContatos() {
		String resultados = "";
		for(int i = 0; i < this.contatos.length; i++) 
			if(this.contatos[i] != null)
				resultados += i + " " + this.contatos[i].toString() + "\n";
		return resultados;
	}
	
	public String exibirContato(int posicao) {
		if(this.contatos != null)
			return this.contatos[posicao].exibirContato();
		else
			return "POSIÇÃO INVÁLIDA!";
	}
	
	public void cadastrarContato( int posicao ,String nome, String sobrenome, String telefone) {
		contatos[posicao-1] = new Contato(nome,sobrenome,telefone);
	}
}