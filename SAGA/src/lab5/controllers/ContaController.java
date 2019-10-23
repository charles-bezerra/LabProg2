package lab5.controllers;

import java.util.*;

import lab5.ids.ContaID;
import lab5.abstracts.*;
import lab5.classes.*;
import lab5.util.Validador;

/**
 * Classe que controla as contas do sistema (CRUD)
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 */
public class ContaController {
    /**
     * Mapa que guarda as várias contas do sistema
     * @ContaID objeto que representa o endereço de uma determinada Conta
     */
    private Map<ContaID, Conta> contas;
    /**
     * Referencia ao controller de clientes
     */
    private ClienteController clientes;
    /**
     * Referencia ao controller de fornecedor
     */
    private FornecedorController fornecedores;


    public ContaController(ClienteController clientes, FornecedorController fornecedores) {
        this.contas = new HashMap<>();
        this.clientes = clientes;
        this.fornecedores = fornecedores;
    }

    private boolean encontraConta(String cpf, String fornecedor) {
        return this.contas.containsKey(new ContaID(cpf, fornecedor));
    }

    public Conta getConta(String cpf, String fornecedor) {
        return this.contas.get( new ContaID(cpf, fornecedor) );
    }

    public List<Conta> getContas() {
        List<Conta> contas = new ArrayList<>( this.contas.values() );
        Collections.sort(contas);
        return contas;
    }

    private List<Conta> getContasCliente(String cpf){
        List<Conta> contasCliente = new ArrayList<>();
        for ( Conta conta: this.getContas() ) {
            if ( conta.getCliente().getCPF().equals(cpf) )
                contasCliente.add(conta);
        }
        return contasCliente;
    }

    public void adicionaConta(Cliente cliente, Fornecedor fornecedor) {
        if (cliente == null)
            throw new IllegalArgumentException("Erro ao cadastrar conta: cliente nao pode vazio ou nulo.");
        if (fornecedor == null)
            throw new IllegalArgumentException("Erro ao cadastrar conta: fornecedor nao pode vazio ou nulo.");
        if ( this.encontraConta(cliente.getCPF(), fornecedor.getNome()) )
            throw new IllegalArgumentException("Erro ao cadastrar conta: conta ja existe.");

        ContaID id = new ContaID(cliente.getCPF(), fornecedor.getNome());
        Conta conta = new Conta(id, cliente, fornecedor);

        this.contas.put(id, conta);
    }

    public String getDebito(String cpf, String fornecedor) {
        Validador.prefixoError = "Erro ao recuperar debito";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        if ( !this.clientes.encontraCliente(cpf) )
            throw new IllegalArgumentException( "Erro ao recuperar debito: cliente nao existe.");
        if ( !this.fornecedores.encontraFornecedor(fornecedor) )
            throw new IllegalArgumentException( "Erro ao recuperar debito: fornecedor nao existe.");
        if ( !this.encontraConta(cpf, fornecedor) )
            throw new IllegalArgumentException( "Erro ao recuperar debito: cliente nao tem debito com fornecedor.");

        return this.contas.get(new ContaID(cpf, fornecedor)).getDebito();
    }


    public String exibeContas(String cpf, String fornecedor) {
        Validador.prefixoError = "Erro ao exibir conta do cliente";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        if (!this.clientes.encontraCliente(cpf))
            throw new IllegalArgumentException(Validador.prefixoError + ": cliente nao existe.");
        if (!this.fornecedores.encontraFornecedor(fornecedor))
            throw new IllegalArgumentException(Validador.prefixoError + ": fornecedor nao existe.");

        ContaID contaID = new ContaID(cpf, fornecedor);
        Conta conta = this.contas.get(contaID);

        if (!this.contas.containsKey(contaID))
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");

        StringBuilder resultado = new StringBuilder("");

        resultado.append("Cliente: ");
        resultado.append(conta.getCliente().getNome());
        resultado.append(" | ");
        resultado.append(conta.toString());

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
            throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
        if ( !this.fornecedores.encontraProdutoFornecedor(fornecedor, nomeProduto, descricaoProduto) )
            throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");

        if ( !this.encontraConta(cpf, fornecedor) ) {
            Cliente cliente = this.clientes.getCliente(cpf);
            Fornecedor fornecedorObj = this.fornecedores.getFornecedor(fornecedor);
            this.adicionaConta(cliente, fornecedorObj);
        }

        Produto produto = this.fornecedores.getProdutoFornecedor(fornecedor, nomeProduto, descricaoProduto);
        double preco = produto.getPreco();

        return this.getConta(cpf, fornecedor).adicionaCompra(data,
                nomeProduto,
                descricaoProduto,
                preco);
    }

    public String exibeContasClientes(String cpf){
        Validador.prefixoError="Erro ao exibir contas do cliente";
        Validador.validaCPF(cpf);

        if ( !this.clientes.encontraCliente(cpf) )
            throw new IllegalArgumentException(Validador.prefixoError + ": cliente nao existe.");

        StringBuilder resultado = new StringBuilder("");
        resultado.append("Cliente: ");
        resultado.append( this.clientes.getCliente(cpf).getNome() );
        resultado.append(" | ");

        List<Conta> contasCliente = this.getContasCliente(cpf);

        if ( contasCliente.size() == 0)
            throw new IllegalArgumentException(Validador.prefixoError + ": cliente nao tem nenhuma conta.");

        Iterator<Conta> contasClienteIterator = contasCliente.iterator();
        Conta conta;

        while ( contasClienteIterator.hasNext() ) {
            conta = contasClienteIterator.next();
            resultado.append( conta.toString() );

            if (contasClienteIterator.hasNext())
                resultado.append(" | ");
        }

        return resultado.toString();
    }

    public String exibeTodasContas(){
        Iterator<Cliente> clientesIterator = this.clientes.getClientes().iterator();
        Iterator<Conta> contasIterator;
        StringBuilder resultado = new StringBuilder("");
        Cliente cliente; Conta conta;

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
            }if (clientesIterator.hasNext()) resultado.append(" | ");
        }
        return resultado.toString();
    }

    public void realizaPagamento(String cpf, String fornecedor){
        Validador.prefixoError="Erro no pagamento de conta";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        if ( !this.clientes.encontraCliente(cpf) )
            throw new IllegalArgumentException(Validador.prefixoError + ": cliente nao existe.");
        if ( !this.fornecedores.encontraFornecedor(fornecedor) )
            throw new IllegalArgumentException(Validador.prefixoError + ": fornecedor nao existe.");
        if ( !this.encontraConta(cpf, fornecedor) )
            throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");

        this.contas.remove(new ContaID(cpf, fornecedor));
    }
}
