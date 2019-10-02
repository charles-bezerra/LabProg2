package lab5;

import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

public class ClienteController {
    private Map<String, Cliente> clientes;

    ClienteController(){
        this.clientes = new LinkedHashMap<>();
    }

    public String adiciona(String cpf, String nome, String email, String localizacao){
        if ( this.clientes.containsKey(cpf) )
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        this.clientes.put(cpf, new Cliente(cpf,nome,email,localizacao) );
        return cpf;
    }

    public String exibe(String cpf){
        if (cpf == null || cpf.trim().equals(""))
            throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo");
        if (!this.clientes.containsKey(cpf))
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        return this.clientes.get(cpf).toString();
    }


    public String lista(){
        StringBuilder exibir = new StringBuilder();
        Iterator<String> clientes = this.clientes.keySet().iterator();
        while (clientes.hasNext()){
            exibir.append(this.exibe(clientes.next()));
            if (clientes.hasNext())
                exibir.append(" | ");
        }
        return exibir.toString();
    }

    public void edita(String cpf, String atributo, String novoValor){
        if (cpf == null || cpf.trim().equals(""))
             throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        if (!this.clientes.containsKey(cpf))
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");

        this.clientes.get(cpf).edita(atributo, novoValor);
    }


    public boolean remove(String cpf){
        if (cpf == null || cpf.trim().equals(""))
            throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
        if ( !this.clientes.containsKey(cpf) )
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe");
        this.clientes.remove(cpf);
        return true;
    }
}
