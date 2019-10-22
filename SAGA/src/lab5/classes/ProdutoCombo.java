package lab5.classes;

import java.text.DecimalFormat;

public class ProdutoCombo extends Produto {
    private ProdutoSimples[] produtos;
    private Double fator;

    ProdutoCombo(String nome, String descricao, Double fator, Produto[] produtos){
        super(nome, descricao);

        if (fator < 0 && fator >= 1)
            throw new IllegalArgumentException(Validador.prefixoError + "fator invalido.");

        this.fator = fator;

        for (Produto item: produtos)
            if (item instanceof ProdutoCombo)
                throw new IllegalArgumentException(Validador.prefixoError + ": ");

        this.produtos = (ProdutoSimples[]) produtos;
    }

    public void setFator(Double novoFator){
        Validador.prefixoError="Erro na edicao do combo";
        Validador.validaDouble("fator nao pode ser vazio ou nulo.", novoFator);

        if ( novoFator < 0 && novoFator >= 1)
            throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");

        this.fator = novoFator;;
    }


    /**
     * Retorna o preco do combo com o desconto
     * @return Double
     */
    @Override
    public Double getPreco(){
        Double valor = new Double(0);

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
