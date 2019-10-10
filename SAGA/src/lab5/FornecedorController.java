package lab5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Classe que representa o CRUD do fornecedor
 *
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class FornecedorController {
    /**
     * Coleção que guarda os vários fornecedores
     */
    private Map<String, Fornecedor> fornecedores;
    /**
     * Construtor que atribui valor a fornecedores
     */
    FornecedorController(){
        this.fornecedores = new LinkedHashMap<>();
    }
    /**
     * Adiciona um fornecedor ao CRUD
     * @param nome atribui valor ao nome do fornecedor
     * @param email atribui valor ao email do fornecedor
     * @param telefone atribui valor ao telefone do fornecedor
     * @return retorna o nome
     */
    public String adiciona(String nome, String email, String telefone){
        if (this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        return nome;
    }

    /**
     * Exibe um fornecedor
     * @param nome nome que identifica o fornecedor
     * @return retorna respresentação textual de fornecedor
     */
    public String exibe(String nome){
        Validador.prefixoError = "Erro na exibicao do fornecedor";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        return this.fornecedores.get(nome).toString();
    }

    /**
     * Lista todos os fornecedores
     * @return retorna respresentação textual de todos os fornecedores
     */
    public String lista(){
        StringBuilder lista = new StringBuilder("");
        Iterator<String> fornercedores = this.fornecedores.keySet().iterator();
        while (fornercedores.hasNext()){
            lista.append( this.exibe(fornercedores.next()) );
            if (fornercedores.hasNext()) lista.append(" | ");
        }
        return lista.toString();
    }

    /**
     * Edita um atributo de fornecedor
     * @param nome nome que identifica o fornecedor
     * @param atributo o atributo a ser alterado
     * @param novoValor novo valor
     */
    public void edita(String nome, String atributo, String novoValor){
    	Validador.prefixoError="Erro na edicao do fornecedor";
    	Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        this.fornecedores.get(nome).edita(atributo, novoValor);
    }

    /**
     * Remove um fornecedor
     * @param nome nome que identifica o fornecedor
     */
    public void remove(String nome){
    	Validador.prefixoError="Erro na remocao do fornecedor";
    	Validador.validaString("nome do fornecedor nao pode ser vazio ou nulo.", nome);
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        this.fornecedores.remove(nome);
    }

    /**
     * Adiciona um produto a fornecedor
     * @param fornecedor
     * @param nome
     * @param descricao
     * @param preco
     */
    public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco){
    	Validador.prefixoError="Erro no cadastro de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        this.fornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
    }

    /**
     * Exibe um produto de um fornecedor
     * @param fornecedor nome que identifica um fornecedor
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @return retorna a representação textual de um produto
     */
    public String exibeProduto(String nome, String descricao, String fornecedor){
        Validador.prefixoError="Erro na exibicao de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        return this.fornecedores.get(fornecedor).exibeProduto(nome,descricao);
    }

    /**
     * Lista todos os produtos de um fornecedor
     * @param fornecedor nome que identifica o fornecedor
     * @return retorna todos as representações textuais dos produtos de fornecedor
     */
    public String listaProdutos(String fornecedor){
        Validador.prefixoError="Erro na listagem dos produtos";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na listagem dos produtos: fornecedor nao existe.");;
        return this.fornecedores.get(fornecedor).listaProdutos();
    }

    /**
     * Edita um produto de um fornecedor 
     * @param fornecedor nome que identifica um fornecedor
     * @param nome nome do produto
     * @param descricao descrição de um produto
     * @param novoPreco novo preço
     */
    public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco){
        Validador.prefixoError="Erro na edicao de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        this.fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
    }

    /**
     * Remove um produto de um fornecedor
     * @param fornecedor nome que identifica um fornecedor
     * @param nome nome do produto
     * @param descricao descrição de um produto
     */
    public void removeProduto(String nome, String descricao, String fornecedor){
        Validador.prefixoError="Erro na remocao de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
    }
}
