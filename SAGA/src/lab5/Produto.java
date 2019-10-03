package lab5;

import java.util.Objects;

/**
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 * Representação do produto no sistema
 */
public class Produto {
    /**
     * nome do produto
     */
    private String nome;
    /**
     * descrição do produto
     */
    private String descricao;
    /**
     * preço do produto
     */
    private Double preco;
    /**
     * endereço composto do produto
     */
    private ProdutoID id;

    /**
     * Construtor do produto
     * @param nome atribui valor ao nome do produto
     * @param descricao atribui valor a descrição do produto
     * @param preco atribui valor ao preço do produto
     */
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

    /**
     * Altera o valor do preço
     * @param preco novo valor do preço
     */
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
