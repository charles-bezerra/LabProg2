package lab5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Classe CRUD de produto
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
        this.produtos = new LinkedHashMap<>();
    }

    public void adiciona(String nome, String descricao, Double preco){
        if( this.produtos.containsKey(new ProdutoID(nome, descricao) ) )
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        Produto produto = new Produto(nome, descricao, preco);
        ProdutoID id = new ProdutoID(nome, descricao);
        this.produtos.put(id, produto);
    }

    public String exibe(String nome, String descricao){
    	Validador.prefixoError="Erro na exibicao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        if (!this.produtos.containsKey(new ProdutoID(nome, descricao)))
        	throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        return this.produtos.get(new ProdutoID(nome, descricao)).toString();
    }

    public String lista(){
        StringBuilder resultado = new StringBuilder("");
        Iterator<ProdutoID> produtos = this.produtos.keySet().iterator();
        while (produtos.hasNext()){
            resultado.append( this.produtos.get(produtos.hasNext()).toString() );
            if (produtos.hasNext()) resultado.append(" | ");
        }
        return resultado.toString();
    }

    public void edita(String nome, String descricao, Double novoPreco){
    	Validador.prefixoError = "Erro na edicao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        if (novoPreco == null)
            throw new IllegalArgumentException("Erro na edicao de produto: preco nao pode ser vazio ou nulo.");
        else if (novoPreco < 0)
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");

        ProdutoID id = new ProdutoID(nome, descricao);
        
        if (!this.produtos.containsKey(id))
        	throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        this.produtos.get(id).setPreco(novoPreco);
    }

    public void remove(String nome, String descricao){
    	Validador.prefixoError="Erro na remocao de produto";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        Validador.validaString("descricao nao pode ser vazia ou nula.", descricao);
        ProdutoID produto = new ProdutoID(nome, descricao);
        if (!this.produtos.containsKey(produto))
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        this.produtos.remove(produto);
    }
}
