package lab5;

import java.util.*;

public class ContaController {
    private Map<ContaID, Conta> contas;
    private ClienteController clientes;
    private FornecedorController fornecedores;

    ContaController(ClienteController clientes, FornecedorController fornecedores){
        this.contas = new HashMap<>();
        this.clientes = clientes;
        this.fornecedores = fornecedores;
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
        Validador.prefixoError = "Erro ao exibir conta do cliente";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        if (!this.clientes.encontraCliente(cpf))
            throw new IllegalArgumentException(Validador.prefixoError + ": cliente nao existe.");

        if (!this.fornecedores.encontraFornecedor(fornecedor))
            throw new IllegalArgumentException(Validador.prefixoError + ": fornecedor nao existe");

        ContaID contaID = new ContaID(cpf, fornecedor);
        Conta conta = this.contas.get(contaID);

        if ( !this.contas.containsKey( contaID ) )
            throw new IllegalArgumentException("Erro ao exibir conta: cliente nao tem nenhuma conta com o fornecedor.");

        StringBuilder resultado = new StringBuilder("");

        resultado.append("Cliente: ");
        resultado.append( conta.getCliente().getNome() );
        resultado.append(" | ");
        resultado.append( conta.toString() );

        return resultado.toString();
    }

    //Compras
    public String adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto) {
        Validador.prefixoError = "Erro ao cadastrar compra";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        Validador.validaString("nome do produto nao pode ser vazio ou nulo.", nomeProduto);
        Validador.validaString("descricao do produto nao pode ser vazia ou nula.", descricaoProduto);

        if ( !this.clientes.encontraCliente(cpf) )
            throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");

        if ( !this.fornecedores.encontraFornecedor(fornecedor) )
            throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe");

        if ( !this.fornecedores.encontraProdutoFornecedor(fornecedor, nomeProduto, descricaoProduto) )
            throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");

        if (!this.encontraConta(cpf, fornecedor)) {
            Cliente cliente = this.clientes.getCliente(cpf);
            Fornecedor fornecedorObj = this.fornecedores.getFornecedor(fornecedor);
            this.adicionaConta(cliente, fornecedorObj);
        }

        Produto produto = this.fornecedores.getProdutoFornecedor(fornecedor, nomeProduto, descricaoProduto);
        Double preco = produto.getPreco();

        return this.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto, preco);
    }

    public String exibeContasClientes() {
        Iterator<Cliente> clientesIterator = this.clientes.getClientes().iterator();
        Iterator<Conta> contasIterator;
        StringBuilder resultado = new StringBuilder("");

        Cliente cliente;
        Conta conta;

        while (clientesIterator.hasNext()) {
            cliente = clientesIterator.next();
            resultado.append(cliente.getNome());
            contasIterator = this.getContas().iterator();
            while (contasIterator.hasNext()) {
                conta = contasIterator.next();
                if (conta.getCliente().equals(cliente)) {
                    resultado.append(" | ");
                    resultado.append( conta.toString() );
                }
            }
            if (clientesIterator.hasNext()) resultado.append(" | ");
        }

        return resultado.toString();
    }

}
