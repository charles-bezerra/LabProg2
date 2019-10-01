package lab5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FornecedorController {
    private Map<String, Fornecedor> fornecedores;

    FornecedorController(){
        this.fornecedores = new HashMap<>();
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
            lista.append();
        }
    }
}
