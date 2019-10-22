package lab5.classes;

import lab5.IDs.ProdutoID;

import java.util.Objects;

public class Compra {
    private String data;
    private ProdutoID idProduto;
    private Double preco;

    public Compra(String data, String nomeProduto, String descricaoProduto, Double preco){
        Validador.prefixoError = "Erro ao cadastrar compra";
        this.data = Validador.validaData(data);
        this.idProduto = new ProdutoID(
                Validador.validaString("nome do produto nao pode ser vazio ou nulo.", nomeProduto),
                Validador.validaString("nome do produto nao pode ser vazio ou nulo.", descricaoProduto)
        );
        this.preco = Validador.validaPreco(preco);
    }

    public Double getPreco(){
        return this.preco;
    }

    public ProdutoID getProdutoID(){
        return this.idProduto;
    }

    public String getData(){
        return this.data;
    }

    public void setPreco(Double novoPreco){
        Validador.prefixoError="Erro na edicao de compra";
        Validador.validaPreco(novoPreco);

        this.preco = novoPreco;
    }

    @Override
    public String toString(){
        return this.idProduto.getNome() + " - " + this.data.replace("/", "-");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra)) return false;
        Compra compra = (Compra) o;
        return getData().equals(compra.getData()) &&
                idProduto.equals(compra.idProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), idProduto);
    }
}
