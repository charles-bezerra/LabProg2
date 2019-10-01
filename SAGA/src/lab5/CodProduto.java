package lab5;

import java.util.Objects;

public class CodProduto {
    private String nome;
    private String descricao;

    CodProduto(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public int hashCode(){
        return this.nome.hashCode()*3 + this.descricao.hashCode()*7;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

}
