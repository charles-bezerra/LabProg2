package lab5;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
  * Classe que representa um fornecedor
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class Fornecedor {
    /**
    * Nome do fornecedor
    */
    private String nome;
    /**
     * Email do fornecedor
     */
    private String email;
    /**
     * Telefone do fornecedor
     */
    private String telefone;
    /**
     * CRUD dos vários produtos do fornecedor
     */
    private ProdutoController produtos;

    /**
    * Construtor de Fornecedor 
    * @param nome atribui valor ao nome do fornecedor
    * @param email atribui valor ao e-mail do fornecedor
    * @param telefone atribui valor ao telefone do fornecedor
    */
    Fornecedor(String nome, String email, String telefone) {
        Validador.prefixoError = "Erro no cadastro do fornecedor";
        this.nome = Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        this.email = Validador.validaString("email nao pode ser vazio ou nulo.", email);
        this.telefone = Validador.validaString("telefone nao pode ser vazio ou nulo.", telefone);
        this.produtos = new ProdutoController();
    }

    /**
    * Edita um atributo do fornecedor
    * @param atributo o atributo a ser alterado
    * @param novoValor novo valor do atributo
    */
    public void edita(String atributo, String novoValor){
        Validador.prefixoError = "Erro na edicao do fornecedor";
        Validador.validaString("atributo nao pode ser vazio ou nulo.", atributo);
        Validador.validaString("novo valor nao pode ser vazio ou nulo.", novoValor);

        if (atributo.equals("nome"))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");

        if (atributo.equals("email"))
        	this.email = novoValor;
        else if(atributo.equals("telefone"))
        	this.telefone = novoValor;
        else throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");

    }

    /**
    * Adiciona um produto em fornecedor
    * @param nome o nome do produto
    * @param descricao descrição do produto
    * @param preco valor do preço do produto
    */
    public void adicionaProduto(String nome, String descricao, Double preco){
        this.produtos.adiciona(nome, descricao, preco);
    }

    /**
    * Remove um produto do fornecedor
    * @param nome nome do produto
    * @param descricao do produto
    */
    public void removeProduto(String nome, String descricao){
        this.produtos.remove(nome,descricao);
    }

    /**
     * Edita um produto do forcenedor
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @param novoPreco novo preço do produto
     */
    public void editaProduto(String nome, String descricao, Double novoPreco){
        this.produtos.edita(nome,descricao,novoPreco);
    }

    /**
     * Exibe um produto do fornecedor
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @return a representação do produto da forma nome - descricao - R$preço
     */
    public String exibeProduto(String nome, String descricao){
        return this.produtos.exibe(nome, descricao);
    }

    /**
     * Lista todos o produtos de um fornecedor
     * @return representação de todos o produtos divido por |
     */
    public String listaProdutos(){
        return this.produtos.lista();
    }

    @Override
    public String toString(){
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.nome);
    }

    @Override
    public boolean equals(Object o){
        return true;
    }
}
