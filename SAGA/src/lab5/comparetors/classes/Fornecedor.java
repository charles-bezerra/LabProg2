package lab5.comparetors.classes;

import lab5.abstracts.Produto;
import lab5.util.Validador;
import lab5.controllers.ProdutoController;

import java.util.List;
import java.util.Objects;

/**
  * Classe que representa um fornecedor
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {
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
    public Fornecedor(String nome, String email, String telefone) {
        Validador.prefixoError = "Erro no cadastro do fornecedor";
        this.nome = Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        this.email = Validador.validaString("email nao pode ser vazio ou nulo.", email);
        this.telefone = Validador.validaString("telefone nao pode ser vazio ou nulo.", telefone);
        this.produtos = new ProdutoController();
    }

    /**
     * Recupera o nome do fornededor
     * @return String
     */
    public String getNome() {
    	return this.nome;
    }

    /**
     * Recupera o email do fornecedor
     * @return String
     */
    public String getEmail() {
    	return this.email;
    }

    /**
     * Recupera o telefone do fornecedor
     * @return String
     */
    public String getTelefone() {
    	return this.telefone;
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

        else
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
    }

    /**
     * Procura se existe um determinado produto
     * @param nome identificador de produto
     * @param descricao identificador de produto
     * @return boolean
     */
    public boolean encontraProduto(String nome, String descricao){
        return this.produtos.encontraProduto(nome, descricao);
    }

    /**
     * Recupera um determinado produto
     * @param nome identificador de produto
     * @param descricao identificador de produto
     * @return Produto
     */
    public Produto getProduto(String nome, String descricao){
        return this.produtos.getProduto(nome, descricao);
    }

    /**
    * Adiciona um produto em fornecedor
    * @param nome o nome do produto
    * @param descricao descrição do produto
    * @param preco valor do preço do produto
    */
    public void adicionaProduto(String nome, String descricao, double preco){
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
    public void editaProduto(String nome, String descricao, double novoPreco){
        this.produtos.editaProduto(nome,descricao,novoPreco);
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
     * Lista todos o produtos de um fornecedor por ordem Alfabética
     * @return representação de todos o produtos em uma Lista de Stringss
     */
    public List<String> exibeProdutos(){
        return this.produtos.exibeProdutos();
    }

    /**
     * Adiciona um combo no controller de produto
     * @param nome identificador do combo
     * @param descricao identificador do combo
     * @param fator porcentagem de desconto do preço total do combo
     * @param produtos produto
     */
    public void adicionaCombo(String nome, String descricao, double fator, String produtos) {
        this.produtos.adicionaCombo(nome, descricao, fator, produtos);
    }

    public void editaCombo(String nome, String descricao, double novoFator){
        this.produtos.editaCombo(nome, descricao, novoFator);
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
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Fornecedor outroFornecedor = (Fornecedor) obj;
        return outroFornecedor.hashCode() == this.hashCode();
    }
    
    @Override
    public int compareTo(Fornecedor f) {
    	return this.getNome().compareTo(f.getNome());
    }
}
