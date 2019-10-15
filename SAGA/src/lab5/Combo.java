package lab5;

import java.text.DecimalFormat;

public class Combo extends Produto {
    private Produto[] produtos;
    private Double fator;

    Combo(String nome, String descricao, Double fator, Produto[] produtos){
        super(nome, descricao, 0.0);
        this.fator = fator;

        if (fator < 0 && fator >= 1)
            throw new IllegalArgumentException(Validador.prefixoError + "fator invalido.");

        this.produtos = produtos;
        this.preco = this.getPreco();
    }

    public void setFator(Double novoFator){
        Validador.prefixoError="Erro na edicao do combo";
        Validador.validaDouble("fator nao pode ser vazio ou nulo.", novoFator);

        if ( novoFator < 0 && novoFator >= 1)
            throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");

        this.fator = novoFator;;
    }

    @Override
    public Double getPreco(){
        Double valor = 0.0;
        for (Produto produto: this.produtos)
            valor += produto.getPreco();
        return valor - (valor*this.fator);
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        return this.nome + " - " + this.descricao + " - R$" + df.format( this.preco );
    }
}
