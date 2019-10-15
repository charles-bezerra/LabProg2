package lab5;

import java.util.*;


/**
 * Classe CRUD de produto
 * 
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class ProdutoController {
    /**
     * Coleção que contem todos os produtos
     */
    private Map<ProdutoID, Produto> produtos;

    /**
     * Construtor do ProdutoController
     */
    ProdutoController(){
        this.produtos = new HashMap<>();
    }
    
    /**
     * Verifica se existe um determinado produto
     * @param nome identificado do produto
     * @param descricao identificador do produto
     * @return boolean
     */
    public boolean encontraProduto(String nome, String descricao) {
    	return this.produtos.containsKey(new ProdutoID(nome, descricao));
    }

    public Produto getProduto(String nome, String descricao){
        return this.produtos.get(new ProdutoID(nome, descricao));
    }
    
    /**
     * 
     * @return
     */
    private List<Produto> getProdutosOrdenados(){
    	if (this.produtos.isEmpty())
    		return null;
		
    	List<Produto> produtosOrdenados = new ArrayList<>( this.produtos.values() );
		Collections.sort(produtosOrdenados);

		return produtosOrdenados;
    }
    
    /**
     * 
     * @param nome
     * @param descricao
     * @param preco
     */
    public void adiciona(String nome, String descricao, Double preco){
        if( encontraProduto(nome, descricao) )
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
      
        Produto produto = new Produto(nome, descricao, preco);
        ProdutoID id = new ProdutoID(nome, descricao);
      
        this.produtos.put(id, produto);
    }

    public void adicionaCombo(String nome, String descricao, Double fator, String produtos){
        Validador.prefixoError="Erro no cadastro de combo";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);

        Validador.validaString("combo deve ter produtos.", produtos);
        Validador.validaDouble("fator nao pode ser vazio ou nulo.", fator);

        ProdutoID id;
        String nomeProduto, descricaoProduto;

        String[] listaDeProdutos = produtos.split(",");
        Produto[] produtosObj = new Produto[listaDeProdutos.length];

        int i = 0;

        for (String item: listaDeProdutos) {
            nomeProduto = item.split(" - ")[0];
            descricaoProduto = item.split(" - ")[1];

            id = new ProdutoID(nomeProduto, descricaoProduto);

            if ( this.produtos.get(id) instanceof Combo )
                throw new IllegalArgumentException(Validador.prefixoError + ": um combo nao pode possuir combos na lista de produtos.");

            if ( !this.produtos.containsKey(id) )
                throw new IllegalArgumentException(Validador.prefixoError + ": produto nao existe.");

            produtosObj[i] = this.produtos.get(id);
            i++;
        }

        id = new ProdutoID(nome, descricao);
        Combo combo = new Combo(nome, descricao, fator, produtosObj);

        this.produtos.put(id, combo);
    }
    
    
    /**
     * 
     * @param nome
     * @param descricao
     * @return
     */
    public String exibe(String nome, String descricao){
    	Validador.prefixoError="Erro na exibicao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        
        if ( !encontraProduto(nome, descricao) )
        	throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        
        return this.produtos.get(new ProdutoID(nome, descricao)).toString();
    }

    /**
     * o
     * @return
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

    public void edita(String nome, String descricao, Double novoPreco){
    	Validador.prefixoError = "Erro na edicao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        Validador.validaPreco(novoPreco);
        
        if ( !this.encontraProduto(nome, descricao) )
        	throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        
        this.produtos.get(new ProdutoID(nome, descricao)).setPreco(novoPreco);
    }
    

    public void remove(String nome, String descricao){
    	Validador.prefixoError="Erro na remocao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
                
        if ( !this.encontraProduto(nome, descricao) )
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        
        this.produtos.remove(new ProdutoID(nome, descricao));
    }
}
