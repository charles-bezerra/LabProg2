package lab3;

/**
 *
 * Representação de um Contato no sistema.
 *
 * @author Charles Bezerra de Oliveira Júnior-119110595 (Lab3)
 **/

public class Contato {
	/**
	 * Atributo contendo o primeiro nome do contato
	 * */
	private String nome;

	/**
	 * Atributo contendo o sobrenome do contato
	 * */
	private String sobrenome;

	/**
	 * Atributo contendo o telefone do contato
	 * */
	private String telefone;

	/**
	 * Atributo contendo o detalhes sobre o contato
	 * */
	private String detalhes;

	/**
	 * Construtor padrão do contato
	 *
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato no formato "(XX) XXXXX-XXXX
	 * */
	Contato(String nome, String sobrenome, String telefone) {
		this(nome, sobrenome, telefone, null);
	}

	/**
	 * Construtor adicional do contato
	 *
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato no formato "(XX) XXXXX-XXXX"
	 * @param detalhes detalhes sobre o contato
	 * */
	Contato(String nome, String sobrenome, String telefone, String detalhes) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * Método que retorna o nome do contato
	 *
	 * @return nome do contato
	 * */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Método que retorna o sobrenome do contato
	 *
	 * @return sobrenome do contato
	 * */
	public String getSobrenome() {
		return this.sobrenome;
	}

	/**
	 * Método que retorna o telefone do contato
	 *
	 * @return telefone do contato no formato (XX) XXXXX-XXXX
	 * */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Método que retorna os detalhes do contato
	 *
	 * @return os detalhes do contato
	 * */
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	/**
	 * Método que retorna a represenção de contato com seu telefone
	 *
	 * @return nome a representação de contatos no formato "nome sobrenome - (XX) XXXXX-XXXX"
	 * */
	public String exibirContato() {
		return this.toString() + " - " + this.telefone;
	}

	/**
	 * Método que retorna a represenção de contato
	 *
	 * @return nome a representação de contatos no formato "nome sobrenome"
	 * */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}

	/**
	 * Método que retorna um booleno que afirma contato é igual a outro objeto do tipo contato
	 *
	 * @return um booleano que afirma se contato é igual a outro objeto do tipo contato
	 * */
	@Override
	public boolean equals(Object outroContato) {
        Contato outro;
        if (outroContato != null)
            outro = (Contato) outroContato;
        else
            return false;
        return ( this.nome.equals(outro.nome) && this.sobrenome.equals(outro.sobrenome) ) ? true : false;
    }
}
