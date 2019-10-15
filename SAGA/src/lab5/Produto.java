package lab5;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Representação do produto no sistema
 *
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public abstract class Produto implements Comparable<Produto> {
    /**
     * nome do produto
     */
    protected String nome;
    /**
     * descrição do produto
     */
    protected String descricao;
    /**
     * endereço composto do produto
     */
    protected ProdutoID id;

    /**
     * Construtor do produto
     * @param nome atribui valor ao nome do produto
     * @param descricao atribui valor a descrição do produto
     */
    Produto(String nome, String descricao){
        Validador.prefixoError = "Erro no cadastro de produto";
        this.nome = Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        this.descricao = Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        this.id = new ProdutoID(nome, descricao);
    }

    /**
     * Retorna o nome do produto
     * @return String com o nome do produto
     */
    public String getNome() {
    	return this.nome;
    }

    /**
     * Retorna a descricao do produto
     * @return String com a descricao do produto
     */
    public String getDescricao() {
    	return this.descricao;
    }

    /**
     * Retorna o identificador do produto
     * @return ProdutoID
     */
    public ProdutoID getID() {
    	return this.id;
    }


    @Override
    public String toString(){
        return this.nome + " - " + this.descricao;
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

    @Override
    public int compareTo(Produto p) {
    	return getID().toString().compareTo(
    	     p.getID().toString()
        );
    }
}
