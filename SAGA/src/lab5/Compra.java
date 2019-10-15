package lab5;

public class Compra {
    private String data;
    private ProdutoID idProduto;
    private Double preco;

    Compra(String data, String nomeProduto, String descricaoProduto, Double preco){
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

    public void setPreco(Double novoPreco){
        Validador.prefixoError="Erro na edicao de compra";
        Validador.validaPreco(novoPreco);

        this.preco = novoPreco;
    }

    @Override
    public String toString(){
        return this.idProduto.getNome() + " - " + this.data;
    }
}
