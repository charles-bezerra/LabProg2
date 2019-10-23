package lab5.classes;

import lab5.ids.ProdutoID;
import lab5.util.Validador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Compra {
    private LocalDate data;
    private ProdutoID idProduto;
    private double preco;
    private Cliente cliente;
    private Fornecedor fornecedor;

    public Compra(String data,
                  String nomeProduto,
                  String descricaoProduto,
                  double preco,
                  Cliente cliente,
                  Fornecedor fornecedor)
    {

        Validador.prefixoError = "Erro ao cadastrar compra";

        this.data = Validador.validaData(data);
        this.idProduto = new ProdutoID(
                Validador.validaString("nome do produto nao pode ser vazio ou nulo.", nomeProduto),
                Validador.validaString("nome do produto nao pode ser vazio ou nulo.", descricaoProduto) );
        this.preco = Validador.validaPreco(preco);
        this.cliente = cliente;
        this.fornecedor = fornecedor;
    }

    public double getPreco(){
        return this.preco;
    }

    public ProdutoID getProdutoID(){
        return this.idProduto;
    }

    public String getData(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formato.format(this.data);
    }

    public void setPreco(double novoPreco){
        Validador.prefixoError="Erro na edicao de compra";
        Validador.validaPreco(novoPreco);

        this.preco = novoPreco;
    }

    @Override
    public String toString(){
        return this.idProduto.getNome() + " - " + this.getData();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra)) return false;
        Compra compra = (Compra) o;
        return Objects.equals(getData(), compra.getData()) &&
                Objects.equals(idProduto, compra.idProduto) &&
                Objects.equals(cliente, compra.cliente) &&
                Objects.equals(fornecedor, compra.fornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), idProduto, cliente, fornecedor);
    }
}
