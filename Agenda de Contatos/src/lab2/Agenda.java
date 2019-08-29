package lab2;

/**
 *  Classe responsável em controlar e representar
 *  uma lista de contatos contendo métodos que
 *  possibilitam adicionar, listar e pesquisar contatos.
 * */

public class Agenda {
	/**
	 * Variável contendo o nome da Agenda
	 * */
	private String nomeAgenda;

	/**
	 * Array contendo Objetos do tipo Contato
	 * */
	private Contato[] contatos;

	/**
	 * Construtor que atribui valores à nomeAgenda e contatos[]
	 *
	 * @param nomeAgenda nome que será atribuido como o nome da agenda.
	 * */
	Agenda(String nomeAgenda){
		this.contatos = new Contato[100];
		this.nomeAgenda = nomeAgenda;
	}

	/**
	 * Método que retorna um texto contendo todos os contatos
	 * cadastrados.
	 *
	 * @return resultados um String com todos os contatos válidos
	 * */
	public String listarContatos() {
		String resultados = "";
		for(int i = 0; i < this.contatos.length; i++) 
			if(this.contatos[i] != null)
				resultados += i + " " + this.contatos[i].toString() + "\n";
		return resultados;
	}

	/**
	 * Método que procura e retorna um contato
	 *
	 * @param posicao inteiro contendo a posição do contato de 1...100
	 * @return retorna a representação de um contato na forma "nome sobrenome telefone" ou "POSIÇÂO INVÁLIDA!".
	 * */
	public String exibirContato(int posicao) {
		return this.contatos != null ? this.contatos[posicao].exibirContato() : "POSIÇÃO INVÁLIDA!";
	}

	/**
	 * Cadastra um contato no Array contatos[]
	 *
	 * @param posicao inteiro com a posição a ser cadastrado o contato
	 * @param nome nome do contato
	 * @param sobrenome do contato
	 * @param telefone telefone do contato
	 * */
	public void cadastrarContato( int posicao ,String nome, String sobrenome, String telefone) {
		contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}
}