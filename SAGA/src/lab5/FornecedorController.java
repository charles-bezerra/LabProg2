package lab5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 * Classe que representa o CRUD do fornecedor
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
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no exibicao de fornecedor: nome nao pode ser vazio ou nulo.");
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro no exibicao de fornecedor: fornecedor nao existe.");
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
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");

        this.fornecedores.get(nome).edita(atributo, novoValor);
    }

    /**
     * Remove um fornecedor
     * @param nome nome que identifica o fornecedor
     */
    public void remove(String nome){
        if (nome==null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
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
    public void adicionarProduto(String fornecedor, String nome, String descricao, Double preco){
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        if (fornecedor == null || fornecedor.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        this.fornecedores.get(nome).adicionaProduto(nome, descricao, preco);
    }

    /**
     * Exibe um produto de fornecedor
     * @param fornecedor
     * @param nome
     * @param descricao
     * @return
     */
    public String exibeProduto(String fornecedor, String nome, String descricao){
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        if (fornecedor == null || fornecedor.trim().equals(""))
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        return this.fornecedores.get(fornecedor).exibeProduto(nome,descricao);
    }

    public String listaProdutos(String fornecedor){
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na listagem de produto: fornecedor nao existe.");
        if (fornecedor == null || fornecedor.trim().equals(""))
            throw new IllegalArgumentException("Erro na listagem de produto: fornecedor nao pode ser vazio ou nulo.");
        return this.fornecedores.get(fornecedor).listaProdutos();
    }

    public void editaProduto(String fornecedor, String nome, String descricao, Double novoPreco){
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        if (fornecedor == null || fornecedor.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.fornecedores.get(fornecedor).editaProduto(nome,descricao,novoPreco);
    }

    public void removeProduto(String fornecedor, String nome, String descricao){
        if (fornecedor == null || fornecedor.trim().equals(""))
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
    }
}
