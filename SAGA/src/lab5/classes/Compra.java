package lab5.classes;

import lab5.ids.ProdutoID;
import lab5.util.Validador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Classe que representa uma compra no sistema
 * @author Charles Bezerra de Oliveira Junior
 */
public class Compra implements Comparable<Compra> {
    /**
     * Atributo que guarda a data
     */
    private LocalDate data;
    /**
     * Atribuito com id do Produto
     */
    private ProdutoID idProduto;
    /**
     * Atributo que guarda o preco da compra
     */
    private double preco;
    /**
     * Atributo que referencia a um cliente
     */
    private Cliente cliente;
    /**
     * Atributo que referencia a um fornecedor
     */
    private Fornecedor fornecedor;

    /**
     * Construtor de compra
     * @param data
     * @param nomeProduto
     * @param descricaoProduto
     * @param preco
     * @param cliente
     * @param fornecedor
     */
    public Compra(String data,
                  String nomeProduto,
                  String descricaoProduto,
                  double preco,
                  Cliente cliente,
                  Fornecedor fornecedor)
    {
        Validador.prefixoError = "Erro ao cadastrar compra";
        this.data = Validador.validaData(data);
        this.preco = Validador.validaPreco(preco);
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.idProduto = new ProdutoID(
                Validador.validaString("nome do produto nao pode ser vazio ou nulo.", nomeProduto),
                Validador.validaString("nome do produto nao pode ser vazio ou nulo.", descricaoProduto) ); }

    /**
     * Retorna o preço da compra
      * @return double
     */
    public double getPreco(){
        return this.preco;
    }

    /**
     * Retorna o id do produto
     * @return ProdutoID
     */
    public ProdutoID getProdutoID(){
        return this.idProduto;
    }

    /**
     * Retorna a data da comprar
     * @return LocqlDate
     */
    public LocalDate getData(){ return this.data; }

    /**
     * Retorna um Cliente
     * @return Cliente
     */
    public Cliente getCliente(){
        return this.cliente;
    }

    /**
     * Retorna o Forncedor da compra
     * @return Fornecedor
     */
    public Fornecedor getFornecedor(){
        return this.fornecedor;
    }

    /**
     * Exibe a data de compra
     * @return String contendo a data no 'dd-MM-aaaa'
     */
    public String exibeData(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formato.format(this.data);
    }

    /**
     * Aletera o valor do preço da compra
     * @param novoPreco
     */
    public void setPreco(double novoPreco){
        Validador.prefixoError="Erro na edicao de compra";
        Validador.validaPreco(novoPreco);
        this.preco = novoPreco;
    }

    /**
     * Exibe a compra pelo cliente
     * @return String no formato 'fornecedor, descricao produto, data'
     */
    public String exibePorCliente(){
        return this.fornecedor.getNome() + ", " + this.idProduto.getDescricao() + ", " + this.exibeData().replace("-","/");
    }

    /**
     * Exibe a compra pelo fornecedor
     * @return String no formato 'cliente, descricao produto, data'
     */
    public String exibePorFornecedor(){
        return this.cliente.getNome() + ", " + this.idProduto.getDescricao() + ", " + this.exibeData().replace("-","/");
    }

    /**
     * Exibe a compra pela data
     * @return String no formato 'fornecedor, cliente, descricao produto'
     */
    public String exibePorData(){
        return this.cliente.getNome() + ", " + this.fornecedor.getNome() + ", " + this.idProduto.getDescricao();
    }

    @Override
    public String toString(){ return this.idProduto.getNome() + " - " + this.exibeData(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra)) return false;
        Compra compra = (Compra) o;

        return Objects.equals(data, compra.getData()) &&
                Objects.equals(idProduto, compra.idProduto) &&
                Objects.equals(cliente, compra.cliente) &&
                Objects.equals(fornecedor, compra.fornecedor); }

    @Override
    public int hashCode() { return Objects.hash(getData(), idProduto, cliente, fornecedor); }

    @Override
    public int compareTo(Compra o){
        return toString().compareTo(o.toString());
    }
}
