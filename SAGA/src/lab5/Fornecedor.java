package lab5;

import java.util.HashMap;
import java.util.Map;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private Map<CodProduto, Produto> produtos;

    Fornecedor(String nome, String email, String telefone){
        if (nome == null || nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        if (email == null || email.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        if (telefone == null || telefone.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

        this.nome = nome;
        this.email = email;
        this.telefone = email;
        this.produtos = new HashMap<>();
    }

    public boolean adicionarProduto(){
        return true;
    }

    public String toString(){
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

}
