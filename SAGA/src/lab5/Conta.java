package lab5;

import java.util.Objects;

/**
 * Classe que representa uma conta de um cliente em um fornecedor
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 */
public class Conta {
    /**
     * Identificador da conta
     */
    private ContaID id;

    /**
     * Controller de compras
     */
    private CompraController compras;

    /**
     * Inicializa o controlador de compras
     */
    Conta(ContaID id){
        this.id = id;
        this.compras = new CompraController();
    }

    /**
     * Adiciona uma compra na atual conta
     * @param data String que atribui a data da compra
     * @param nomeProduto String que atribui o nome do produto
     * @param descricaoProduto String que atribui a descricao do produto
     * @param preco Double que atribui o preco
     * @return String com a representação textual da compra
     */
    public String adicionaCompra(String data, String nomeProduto, String descricaoProduto, Double preco){
        return this.compras.adiciona(data, nomeProduto, descricaoProduto, preco);
    }

    /**
     * Retorna o valor total do debito da conta
     * @return Double
     */
    public Double getDebito(){
        return this.compras.getDebito();
    }

    public String exibeProdutos(){
        return this.exibeProdutos();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Conta outraConta = (Conta) obj;
        return outraConta.hashCode() == this.hashCode();
    }
}
