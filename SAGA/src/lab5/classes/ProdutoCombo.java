package lab5.classes;

import lab5.abstracts.Produto;
import lab5.util.Validador;

import java.text.DecimalFormat;

/**
 * Classe de um produto do tipo combo
 * @author Charles Bezerra de Oliveira Junior - 119110595
 */
public class ProdutoCombo extends Produto {
    /**
     * Produtos simples que o combo guarda
     */
    private ProdutoSimples[] produtos;
    /**
     * Porcentagem de desconto do combo
     */
    private double fator;

    /**
     * Construtor de combo
     * @param nome nome do combo
     * @param descricao descrição do combo
     * @param fator porcentagem de desconto do combo
     * @param produtos
     */
    public ProdutoCombo(String nome, String descricao, double fator, Produto[] produtos){
        super(nome, descricao);

        if (fator < 0 && fator >= 1)
            throw new IllegalArgumentException(Validador.prefixoError + "fator invalido.");

        this.fator = fator;

        for (Produto item: produtos)
            if (item instanceof ProdutoCombo)
                throw new IllegalArgumentException(Validador.prefixoError + ": ");

        this.produtos = (ProdutoSimples[]) produtos;
    }

    /**
     * Altera o fator de desconto do combo
     * @param novoFator novo valor do fator
     */
    public void setFator(double novoFator){
        Validador.prefixoError="Erro na edicao do combo";
        Validador.validaDouble("fator nao pode ser vazio ou nulo.", novoFator);

        if ( novoFator < 0 && novoFator >= 1)
            throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");

        this.fator = novoFator;;
    }


    /**
     * Retorna o preco do combo com o desconto
     * @retur double[]
     */
    @Override
    public double getPreco(){
        double valor = 0.0;

        for (ProdutoSimples produto: this.produtos)
            valor += produto.getPreco();

        return valor - (valor*this.fator);
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return this.nome + " - " + this.descricao + " - R$" + df.format(this.getPreco()).replace(".",",");
    }
}
