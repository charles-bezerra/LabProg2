package lab5;

import java.util.Objects;

public class Produto {
    private String nome;
    private String descricao;
    private Double preco;
    private ProdutoID id;

    Produto(String nome, String descricao, Double preco){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do produto: nome nao pode ser vazio ou nulo.");
        if (descricao == null || descricao.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do produto: descricao nao pode ser vazio ou nulo.");
        if (preco == null || preco < 0)
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.id = new ProdutoID(nome, descricao);
    }

    public void setPreco(Double preco){
        if (preco == null || preco < 0)
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        this.preco = preco;
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.descricao + " - " + this.preco;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;

        Produto p = (Produto) o;
        return this.hashCode() == p.hashCode();
    }

}