package lab5;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * 
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 * Classe que representa um fornecedor
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
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        if (email == null || email.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        if (telefone == null || telefone.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

        this.nome = nome;
        this.email = email;
        this.telefone = email;
        this.produtos = new ProdutoController();
    }

    /**
    * Edita um atributo do fornecedor
    * @param atributo o atributo a ser alterado
    * @param novoValor novo valor do atributo
    */
    public void edita(String atributo, String novoValor){
        if (atributo == null || atributo.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        if (atributo.equals("nome"))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        if (novoValor == null || novoValor.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

        switch (atributo) {
            case "email": this.email = novoValor;
            case "telefone": this.telefone = novoValor;
            default: throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }
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

    public void editaProduto(String nome, String descricao, Double novoPreco){
        this.produtos.edita(nome,descricao,novoPreco);
    }

    public String exibeProduto(String nome, String descricao){
        return this.produtos.exibe(nome, descricao);
    }

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
