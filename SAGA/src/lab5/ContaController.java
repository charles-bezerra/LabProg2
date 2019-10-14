package lab5;

import java.util.Map;
import java.util.HashMap;

public class ContaController {
    private Map<ContaID, Conta> contas;

    ContaController(){
        this.contas = new HashMap<>();
    }

    public Double getDebito(String cpf, String fornecedor){
        Validador.prefixoError="Erro ao recuperar debito";

        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode vazio ou nulo.", fornecedor);

        ContaID conta = new ContaID(cpf, fornecedor);

        if ( !this.contas.containsKey( conta ) )
            throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem nenhuma conta com o fornecedor.");

        return this.contas.get( conta ).getDebito();
    }

    public String exibeProdutos(String cpf, String fornecedor){
        Validador.prefixoError="Erro ao exibir compras";

        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode vazio ou nulo.", fornecedor);

        ContaID conta = new ContaID(cpf, fornecedor);

        if ( !this.contas.containsKey( conta ) )
            throw new IllegalArgumentException("Erro ao exibir compras: cliente nao tem nenhuma conta com o fornecedor.");

        return this.contas.get(conta).exibeProdutos();
    }

}
