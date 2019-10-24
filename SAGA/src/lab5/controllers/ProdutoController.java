package lab5.controllers;

import lab5.ids.ProdutoID;
import lab5.abstracts.*;
import lab5.classes.*;
import lab5.util.Validador;

import java.util.*;


/**
 * Classe CRUD de produto
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class ProdutoController{
    /**
     * Coleção que contem todos os produtos
     */
    private Map<ProdutoID, Produto> produtos;

    /**
     * Coleção que contem os produtos simples
     */
    private Map<ProdutoID, ProdutoSimples> produtosSimples;

    /**
     * Coleção que contem os produtos combo
     */
    private Map<ProdutoID, ProdutoCombo> combos;

    /**
     * Construtor do ProdutoController
     */
    public ProdutoController(){
        this.produtos = new HashMap<>();
        this.produtosSimples = new HashMap<>();
        this.combos = new HashMap<>();
    }
    
    /**
     * Verifica se existe um determinado produto, simples ou combo
     * @param nome identificado do produto
     * @param descricao identificador do produto
     * @return boolean
     */
    public boolean encontraProduto(String nome, String descricao) {
    	return this.produtos.containsKey(new ProdutoID(nome, descricao));
    }

    /** Verifica se existe um determinado produto simples
     * @param nome identificado do produto
     * @param descricao identificador do produto
     * @return boolean
     */
    public boolean encontraProdutoSimples(String nome, String descricao) {
        return this.produtosSimples.containsKey(new ProdutoID(nome, descricao));
    }

    /** Verifica se existe um determinado produto combo
     * @param nome identificado do produto
     * @param descricao identificador do produto
     * @return boolean
     */
    public boolean encontraCombo(String nome, String descricao) {
        return this.combos.containsKey(new ProdutoID(nome, descricao));
    }

    /**
     * Retorna um produto
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @return Produto
     */
    public Produto getProduto(String nome, String descricao){
        return this.produtos.get(new ProdutoID(nome, descricao));
    }
    
    /**
     * Retorna todos os produtos ordenados
     * @return List
     */
    private List<Produto> getProdutosOrdenados(){
    	if (this.produtos.isEmpty())
    		return null;
    	List<Produto> produtosOrdenados = new ArrayList<>( this.produtos.values() );
		Collections.sort(produtosOrdenados);
		return produtosOrdenados;
    }
    
    /**
     * Adiciona e cadastra um produto simples
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @param preco preço do produto
     */
    public void adiciona(String nome, String descricao, double preco){
        if( encontraProdutoSimples(nome, descricao) )
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
      
        ProdutoSimples produto = new ProdutoSimples(nome, descricao, preco);
        ProdutoID id = new ProdutoID(nome, descricao);
      
        this.produtos.put(id, produto);
        this.produtosSimples.put(id, produto);
    }

    /**
     * Adiciona e cadastra um produto combo
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @param fator porcentagem de desconto
     * @param produtos produto no formatos em String de seus produtos
     */
    public void adicionaCombo(String nome, String descricao, double fator, String produtos){
        Validador.prefixoError="Erro no cadastro de combo";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        Validador.validaString("combo deve ter produtos.", produtos);
        Validador.validaFator(fator);

        if ( this.encontraCombo(nome, descricao))
            throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");

        String nomeProduto, descricaoProduto;
        String[] listaDeProdutos = produtos.split(", ");
        ProdutoSimples[] produtosObj = new ProdutoSimples[listaDeProdutos.length];

        int i = 0;

        for (String item: listaDeProdutos) {
            nomeProduto = item.split(" - ")[0];
            descricaoProduto = item.split(" - ")[1];

            if ( this.encontraCombo(nomeProduto, descricaoProduto) )
                throw new IllegalArgumentException(Validador.prefixoError + ": um combo nao pode possuir combos na lista de produtos.");

            if ( !this.encontraProdutoSimples(nomeProduto, descricaoProduto) )
                throw new IllegalArgumentException(Validador.prefixoError + ": produto nao existe.");

            produtosObj[i] = this.produtosSimples.get( new ProdutoID(nomeProduto, descricaoProduto) );
            i++;
        }

        ProdutoID id = new ProdutoID(nome, descricao);
        ProdutoCombo combo = new ProdutoCombo(nome, descricao, fator, produtosObj);

        this.produtos.put(id, combo);
        this.combos.put(id, combo);
    }
    
    
    /**
     * Exibe um produto simples ou combo
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @return String
     */
    public String exibe(String nome, String descricao){
    	Validador.prefixoError="Erro na exibicao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        
        if ( !encontraProduto(nome, descricao) )
        	throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        
        return this.getProduto(nome, descricao).toString();
    }

    /**
     * Exibe todos os produto
     * @return String
     */
    public List<String> exibeProdutos(){
        List<String> resultado = new ArrayList<>();        
        Iterator<Produto> produtos;
        
        if (this.getProdutosOrdenados() == null)
        	return null;
    	
        produtos = this.getProdutosOrdenados().iterator();
        Produto produto;

        while (produtos.hasNext()){
            produto = produtos.next();
            resultado.add(
            	this.exibe( 	
            		produto.getNome(),
            		produto.getDescricao()
            	) 
            );
        }
        
        return resultado;
    }

    /**
     * Edita um produto simples
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @param novoPreco novo valor do preço do produto simples
     */
    public void editaProduto(String nome, String descricao, double novoPreco){
    	Validador.prefixoError = "Erro na edicao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        Validador.validaPreco(novoPreco);

        if ( !this.encontraProdutoSimples(nome, descricao) )
        	throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");

        ProdutoID id = new ProdutoID(nome, descricao);
        this.produtosSimples.get(id).setPreco(novoPreco);
    }

    /**
     * Edita um produto combo
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @param novoFator novo valor do fator de desconto do combo
     */
    public void editaCombo(String nome, String descricao, double novoFator){
        Validador.prefixoError = "Erro na edicao de combo";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        Validador.validaFator(novoFator);

        if ( !this.encontraCombo(nome, descricao) )
            throw new IllegalArgumentException(Validador.prefixoError + ": produto nao existe.");

        this.combos.get( new ProdutoID(nome, descricao) ).setFator(novoFator);
    }

    /**
     * Remove um produto do sistema, simples ou combo
     * @param nome nome do produto
     * @param descricao descrição do produto
     */
    public void remove(String nome, String descricao){
    	Validador.prefixoError="Erro na remocao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
                
        if ( !this.encontraProduto(nome, descricao) )
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        
        this.produtos.remove(new ProdutoID(nome, descricao));
    }
}
