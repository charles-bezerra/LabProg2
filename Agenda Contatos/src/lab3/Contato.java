package lab3;

/**
 *
 * */

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private String detalhes;

	Contato(String nome, String sobrenome, String telefone) {
		this(nome, sobrenome, telefone, null);
	}

	Contato(String nome, String sobrenome, String telefone, String detalhes) {
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
		return this.toString() + " - " + this.telefone;
	}

	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}

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
