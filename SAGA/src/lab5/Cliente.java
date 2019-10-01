package lab5;

import java.util.Objects;

public class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    Cliente(String cpf, String nome, String email, String localizacao){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    public void setNome(String nome){ this.nome = nome ; }
    public void setEmail(String email){ this.email = email; }
    public void setLocalizacao(String localizacao){ this.localizacao = localizacao; }

    @Override
    public String toString(){
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    public int hashCode(){
        return Objects.hash(this.cpf);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Cliente outroCliente = (Cliente) obj;
        return outroCliente.hashCode() == this.hashCode();
    }
}
