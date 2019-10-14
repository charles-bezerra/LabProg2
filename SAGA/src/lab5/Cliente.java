package lab5;

import java.util.Objects;

/**
 * Classe que representa e quarda valores de um cliente do sistema
 * 
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 */
public class Cliente implements Comparable<Cliente> {
    /**
     * Identificador único do cliente, quarda o CPF
     */
    private String cpf;
    /**
     * Quarda o nome do cliente
     */
    private String nome;
    /**
     * Quarda o email do cliente
     */
    private String email;
    /**
     * Quarda o local do cliente que consiste em um laboratorio
     */
    private String localizacao;

    /**
     * Construtor de cliente inicializa os seuas atributos
     * @param cpf é atribuido ao CPF do Cliente
     * @param nome é atribuido ao nome do Cliente
     * @param email é atribuido ao email do Cliente
     * @param localizacao é atribuido a localizacao do Cliente
     */
    Cliente(String cpf, String nome, String email, String localizacao){
        Validador.prefixoError = "Erro no cadastro do cliente";
        this.cpf = Validador.validaCPF(cpf);
        this.nome = Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        this.email = Validador.validaString( "email nao pode ser vazio ou nulo.", email);
        this.localizacao = Validador.validaString( "localizacao nao pode ser vazia ou nula.", localizacao);
    }
    
    public String getCPF() {
    	return this.cpf;
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    public String getEmail() {
    	return this.email;
    }

    public String getLocalizacoa() {
    	return this.localizacao;
    }
    
    /**
     * Edita o valor de um atributo do cliente
     * @param atributo atributo a ser editado
     * @param novoValor novo valor do atributo
     */
    public void edita(String atributo, String novoValor){
        Validador.prefixoError = "Erro na edicao do cliente";
        Validador.validaString("atributo nao pode ser vazio ou nulo.", atributo);
        Validador.validaString("novo valor nao pode ser vazio ou nulo.", novoValor);
        
        if ( atributo.equals("cpf") )
            throw new  IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
        if ( !atributo.equals("nome") && !atributo.equals("email") && !atributo.equals("localizacao") )
            throw new  IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");

        if (atributo.equals("nome")) this.nome = novoValor;
        else if (atributo.equals("email")) this.email = novoValor;
        else if (atributo.equals("localizacao")) this.localizacao = novoValor;
    }

    @Override
    public String toString(){ return this.nome + " - " + this.localizacao + " - " + this.email; }

    @Override
    public int hashCode(){
        return Objects.hash(this.cpf);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Cliente outroCliente = (Cliente) obj;
        return outroCliente.hashCode() == this.hashCode();
    }
    
    @Override
    public int compareTo(Cliente c) {
    	return this.getNome().compareTo(c.getNome());
    }
}
