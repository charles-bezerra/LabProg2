package lab5;

import java.util.*;

public class ContaController {
    private Map<ContaID, Conta> contas;

    ContaController(){
        this.contas = new HashMap<>();
    }

    public boolean encontraConta(String cpf, String fornecedor){
        return this.contas.containsKey(new ContaID(cpf, fornecedor));
    }

    public List<Conta> getContas(){
        return new ArrayList<>( this.contas.values() );
    }

    public void adicionaConta(Cliente cliente, Fornecedor fornecedor){
        if (cliente == null)
            throw new IllegalArgumentException("Erro ao cadastrar conta: cliente nao pode vazio ou nulo.");

        if (fornecedor == null)
            throw new IllegalArgumentException("Erro ao cadastrar conta: fornecedor nao pode vazio ou nulo.");

        if ( this.contas.containsKey( new ContaID( cliente.getCPF(), fornecedor.getNome() ) ) )
            throw new IllegalArgumentException("Erro ao cadastrar conta: conta ja existe.");

        ContaID id = new ContaID(cliente.getCPF(), fornecedor.getNome());
        Conta conta = new Conta(id, cliente, fornecedor);

        this.contas.put(id, conta);
    }

    public String adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto, Double preco){
        Validador.prefixoError="Erro na adicao de compra";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode vazio ou nulo.", fornecedor);

        ContaID conta = new ContaID(cpf, fornecedor);

        if ( !this.contas.containsKey(conta) )
            throw new IllegalArgumentException("Erro na adicao de compra: cliente nao tem nenhuma conta com o fornecedor.");

        return this.contas.get( conta ).adicionaCompra(data, nomeProduto, descricaoProduto, preco);
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

    public String exibeContaCliente(String cpf, String fornecedor){
        Validador.prefixoError="Erro ao exibir compras";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode vazio ou nulo.", fornecedor);

        ContaID contaID = new ContaID(cpf, fornecedor);
        Conta conta = this.contas.get(contaID);

        if ( !this.contas.containsKey( contaID ) )
            throw new IllegalArgumentException("Erro ao exibir conta: cliente nao tem nenhuma conta com o fornecedor.");

        StringBuilder resultado = new StringBuilder("");

        resultado.append("Cliente: ");
        resultado.append( conta.getCliente().getNome() );
        resultado.append(" | ");
        resultado.append( conta.exibe() );

        return resultado.toString();
    }
}
