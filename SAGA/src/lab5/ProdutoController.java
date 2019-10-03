package lab5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 * Classe CRUD de produto
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
        this.produtos.put(new ProdutoID(nome, descricao), new Produto(nome, descricao, preco));
    }

    public String exibe(String nome, String descricao){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo");
        if (descricao == null || descricao.trim().equals(""))
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
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
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo");
        if (descricao == null || descricao.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        this.produtos.get(new ProdutoID(nome,descricao)).setPreco(novoPreco);
    }

    public void remove(String nome, String descricao){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo");
        if (descricao == null || descricao.trim().equals(""))
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        ProdutoID produto = new ProdutoID(nome, descricao);
        if (!this.produtos.containsKey(produto))
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        this.produtos.remove(produto);
    }
}
