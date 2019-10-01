package lab5;

import java.util.HashSet;
import java.util.Map;

public class ClienteController {
    private Map<String, Cliente> clientes;

    ClienteController(){
        this.clientes = new HashSet<String, Cliente>();
    }

    public boolean adicionarCliente(String cpf, String nome, String email, String localizacao){
        if ( !this.clientes.put( cpf, new Cliente(cpf, nome, email, localizacao) ) ) {
            throw new Exception("Erro no cadastro do cliente: cliente ja existe.");
        }
        return true;
    }
}
