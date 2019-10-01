package lab5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FornecedorController {
    private Map<String, Fornecedor> fornecedores;

    FornecedorController(){
        this.fornecedores = new LinkedHashMap<>();
    }



    public String adicionarFornecedor(String nome, String email, String telefone){
        if (this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        return nome;
    }



    public String exibeFornecedor(String nome){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no exibicao de fornecedor: nome nao pode ser vazio ou nulo.");
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro no exibicao de fornecedor: fornecedor nao existe.");
        return this.fornecedores.get(nome).toString();
    }



    public String listaFornecedores(){
        StringBuilder lista = new StringBuilder("");
        Iterator<String> fornercedores = this.fornecedores.keySet().iterator();
        while (fornercedores.hasNext()){
            lista.append(fornercedores.next());
            if (fornercedores.hasNext()) lista.append(" | ");
        }
        return lista.toString();
    }



    public void editaFornecedor(String nome, String atributo, String novoValor){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");

        this.fornecedores.get(nome).edita(atributo, novoValor);
    }



    public void removeFornecedor(String nome){
        if (nome==null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        this.fornecedores.remove(nome);
    }



    public void adicionarProduto(String fornecedor, String nome, String descricao, double preco){
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        if (fornecedor == null || fornecedor.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");

        this.fornecedores.get(nome).adicionarProduto(nome, descricao, preco);
    }
}
