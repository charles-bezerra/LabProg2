package lab5.comparetors.classes;

import lab5.abstracts.Produto;
import lab5.util.Validador;

import java.text.DecimalFormat;

public class ProdutoSimples extends Produto {
    /**
     * preço do produto
     */
    private double preco;

    public ProdutoSimples(String nome, String descricao, double preco){
        super(nome, descricao);
        this.preco = Validador.validaPreco(preco);
    }

    /**
     * Altera o valor do preço
     * @param preco novo valor do preço
     */
    public void setPreco(double preco){
        Validador.prefixoError="Erro na edicao do produto";
        Validador.validaPreco(preco);
        this.preco = preco;
    }

    /**
     * Retorna o preco do produto
     * @return double
     */
    @Override
    public double getPreco(){
        return this.preco;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String preco = df.format(this.preco);
        return this.nome + " - " + this.descricao + " - R$" + preco.replace('.', ',');
    }
}
