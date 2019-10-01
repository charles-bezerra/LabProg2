package lab5;

import java.util.Objects;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    Cliente(String cpf, String nome, String email, String localizacao){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    public void editar(String atributo, String novoValor){
        if (atributo == null || atributo.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        if (atributo.toLowerCase().equals("cpf"))
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
        if ( novoValor == null || novoValor.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        if ( !(atributo.toLowerCase().equals("nome") || atributo.toLowerCase().equals("email") || atributo.toLowerCase().equals("localizacao")) )
            throw new  IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");

        if (atributo.equals("nome")) this.nome = novoValor;
        else if (atributo.equals("email")) this.email = novoValor;
        else if (atributo.equals("localizacao")) this.localizacao = localizacao;
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

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
