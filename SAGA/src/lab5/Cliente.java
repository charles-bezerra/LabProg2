package lab5;

import java.util.Objects;

/**
 * Classe que representa e quarda valores de um cliente do sistema
 * 
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 */
public class Cliente {
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
        this.cpf = Validador.validaString("cpf", cpf);
        this.nome = Validador.validaString("nome", nome);
        this.email = Validador.validaString( "email", email);
        this.localizacao = Validador.validaString( "localizacao", localizacao);
    }

    /**
<<<<<<< HEAD
     * Edita um atributo do cliente
     * @param atributo atributo a ser alterado
     * @param novoValor novo valor
=======
     * Edita o valor de um atributo do cliente
     * @param atributo atributo a ser editado
     * @param novoValor novo valor do atributo
>>>>>>> 5ce340fb888c830c0017eeeecac80da72f7c4ffd
     */
    public void edita(String atributo, String novoValor){
        Validador.prefixoError = "Erro na edicao do cliente";
        Validador.validaString( "atributo", atributo);
        Validador.validaString( "novo valor", novoValor);

        if ( !(atributo.equals("nome") || atributo.equals("email") || atributo.equals("localizacao")) )
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
}
