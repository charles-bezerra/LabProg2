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
        if (cpf == null || cpf.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        if (email == null || email.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        if (localizacao == null || localizacao.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.");

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    public void edita(String atributo, String novoValor){
        if (atributo == null || atributo.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        if (atributo.equals("cpf"))
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
        if ( novoValor == null || novoValor.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
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
