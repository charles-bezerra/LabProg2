package lab5.classes;

import lab5.ids.ContaID;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Classe que representa uma conta de um cliente em um fornecedor
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 */
public class Conta implements Comparable<Conta>{
    /**
     * Identificador da conta
     */
    private ContaID id;
    private Cliente cliente;
    private Fornecedor fornecedor;

    /**
     * As compras
     */
    private List<Compra> compras;

    /**
     * Inicializa o controlador de compras
     */
    public Conta(ContaID id, Cliente cliente, Fornecedor fornecedor){
        this.id = id;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.compras = new ArrayList<>();
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
        Compra compra = new Compra(data, nomeProduto, descricaoProduto, preco, this.cliente, this.fornecedor);
        this.compras.add(compra);

        return compra.toString();
    }

    /**
     * Retorna o valor total do debito da conta
     * @return Double
     */
    public String getDebito(){
        Double valor = 0.0;
        for (Compra compra: this.compras)
            valor = valor + compra.getPreco();
        DecimalFormat df = new DecimalFormat(".00");
        return df.format(valor);
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public Fornecedor getFornecedor(){
        return this.fornecedor;
    }

    @Override
    public String toString(){
        StringBuilder resultado = new StringBuilder("");
        Iterator<Compra> comprasIterator = this.compras.iterator();

        resultado.append( this.fornecedor.getNome() );
        resultado.append(" | ");

        while (comprasIterator.hasNext()){
            resultado.append( comprasIterator.next().toString() );
            if (comprasIterator.hasNext()) resultado.append(" | ");
        }

        return resultado.toString();
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

    @Override
    public int compareTo(Conta conta){
        return this.toString().compareTo(conta.toString());
    }
}
