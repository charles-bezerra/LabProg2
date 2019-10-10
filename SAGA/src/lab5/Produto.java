package lab5;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Representação do produto no sistema
 *
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
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
        Validador.prefixoError = "Erro no cadastro de produto";
        this.nome = Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        this.descricao = Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        this.preco = Validador.validaDouble("preco nao pode ser vazio ou nulo.", preco);
        if (preco < 0)
        	throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        this.id = new ProdutoID(nome, descricao);
    }

    /**
     * Altera o valor do preço
     * @param preco novo valor do preço
     */
    public void setPreco(Double preco){
        this.preco = preco;
    }

    @Override
    public String toString(){
    	DecimalFormat df = new DecimalFormat("###,##0.00");
    	String preco = df.format(this.preco).toString();
        return this.nome + " - " + this.descricao + " - R$" + preco.replace('.', ',');
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
