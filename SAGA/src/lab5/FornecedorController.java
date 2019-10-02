package lab5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FornecedorController {
    private Map<String, Fornecedor> fornecedores;

    FornecedorController(){
        this.fornecedores = new LinkedHashMap<>();
    }

    public String adiciona(String nome, String email, String telefone){
        if (this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        return nome;
    }

    public String exibe(String nome){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no exibicao de fornecedor: nome nao pode ser vazio ou nulo.");
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro no exibicao de fornecedor: fornecedor nao existe.");
        return this.fornecedores.get(nome).toString();
    }

    public String lista(){
        StringBuilder lista = new StringBuilder("");
        Iterator<String> fornercedores = this.fornecedores.keySet().iterator();
        while (fornercedores.hasNext()){
            lista.append( this.exibe(fornercedores.next()) );
            if (fornercedores.hasNext()) lista.append(" | ");
        }
        return lista.toString();
    }

    public void edita(String nome, String atributo, String novoValor){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");

        this.fornecedores.get(nome).edita(atributo, novoValor);
    }

    public void remove(String nome){
        if (nome==null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        this.fornecedores.remove(nome);
    }

    public void adicionarProduto(String fornecedor, String nome, String descricao, Double preco){
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        if (fornecedor == null || fornecedor.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        this.fornecedores.get(nome).adicionaProduto(nome, descricao, preco);
    }

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
