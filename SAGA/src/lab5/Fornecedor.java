package lab5;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private Map<CodProduto, Produto> produtos;

    Fornecedor(String nome, String email, String telefone) {
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        if (email == null || email.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        if (telefone == null || telefone.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

        this.nome = nome;
        this.email = email;
        this.telefone = email;
        this.produtos = new LinkedHashMap<>();
    }


    public void adicionarProduto(String nome, String descricao, double preco){
        if( this.produtos.containsKey(new CodProduto(nome, descricao) ) )
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.";
        this.produtos.put(new CodProduto(nome, descricao), new Produto(nome, descricao, preco));
    }


    public void edita(String atributo, String novoValor){
        if (atributo == null || atributo.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        if (atributo.equals("nome"))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        if (novoValor == null || novoValor.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

        switch (atributo) {
            case "email": {
                this.email = novoValor;
            }
            case "telefone": {
                this.telefone = novoValor;
            }
            default: throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.nome);
    }

    @Override
    public boolean equals(Object o){
        return true;
    }
}
