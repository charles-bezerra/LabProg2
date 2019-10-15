package lab5;

import java.text.DecimalFormat;

public class ProdutoSimples extends Produto {
    /**
     * preço do produto
     */
    protected Double preco;

    ProdutoSimples(String nome, String descricao, Double preco){
        super(nome, descricao);
        this.preco = Validador.validaPreco(preco);
    }

    /**
     * Altera o valor do preço
     * @param preco novo valor do preço
     */
    public void setPreco(Double preco){
        this.preco = preco;
    }

    /**
     * Retorna o preco do produto
     * @return Double
     */
    public Double getPreco(){
        return this.preco;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String preco = df.format(this.preco);
        return this.nome + " - " + this.descricao + " - R$" + preco.replace('.', ',');
    }
}
