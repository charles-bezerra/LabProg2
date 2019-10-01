package lab5;

import java.util.Objects;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private CodProduto cod;

    Produto(String nome, String descricao, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.cod = new CodProduto(nome, descricao);
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.descricao;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.cod);
    }
}
