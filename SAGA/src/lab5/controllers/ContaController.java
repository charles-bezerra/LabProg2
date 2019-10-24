package lab5.controllers;

import java.util.*;

import lab5.comparetors.ComparetorCompraPorCliente;
import lab5.comparetors.ComparetorCompraPorData;
import lab5.comparetors.ComparetorCompraPorFornecedor;
import lab5.enums.CriterioOrdenacao;
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

    /**
     * Enumerador que contem os critérios de ordenação de compras (CLIENTE, FORNECEDOR, DATA)
     */
    private CriterioOrdenacao criterioOrdenacao;

    /**
     * Construtor do controlador das contas
     * @param clientes referencia dos clientes do sistema
     * @param fornecedores referencia dos fornecedores do sistema
     */
    public ContaController(ClienteController clientes, FornecedorController fornecedores) {
        this.contas = new HashMap<>();
        this.clientes = clientes;
        this.fornecedores = fornecedores;
    }

    /**
     * Verifica se existe determinada conta cadastrada no sistema
     * @param cpf identificador de um usuário que compõem ContaID
     * @param fornecedor identificador de um fornecedor que compõem ContaID
     * @return boolean
     */
    private boolean encontraConta(String cpf, String fornecedor) {
        return this.contas.containsKey(new ContaID(cpf, fornecedor));
    }

    /**
     * Retorna uma determinada conta
     * @param cpf identificador de um usuário que compõem ContaID
     * @param fornecedor identificador de um fornecedor que compõem ContaID
     * @return Conta
     */
    public Conta getConta(String cpf, String fornecedor) {
        return this.contas.get( new ContaID(cpf, fornecedor) );
    }

    /**
     * Retorna todas as contas
     * @return List
     */
    public List<Conta> getContas() {
        List<Conta> contas = new ArrayList<>( this.contas.values() );
        Collections.sort(contas);
        return contas;
    }

    /**
     * Retorna todas as contas de um determinado cliente
     * @param cpf identificador de cliente
     * @return List
     */
    private List<Conta> getContasCliente(String cpf){
        List<Conta> contasCliente = new ArrayList<>();
        for ( Conta conta: this.getContas() ) {
            if ( conta.getCliente().getCPF().equals(cpf) )
                contasCliente.add(conta);
        }
        return contasCliente;
    }

    /**
     * Adiciona uma nova conta
     * @param cliente referencia do cliente da conta
     * @param fornecedor referencia do fornecedor da conta
     */
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

    /**
     * Retorna o montante do débito devido por um cliente em uma determinada conta
     * @param cpf identificador do cliente
     * @param fornecedor identificador do fornecedor
     * @return double
     */
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

    /**
     * Adiciona uma nova compra em uma conta
     * @param cpf identificador do cliente
     * @param fornecedor identificador do fornecedor
     * @param data data da compra do produto
     * @param nomeProduto nome do produto comprado
     * @param descricaoProduto descrição do produto comprado
     * @return String
     */
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

    /**
     * Exibe uma conta de um cliente com um fornecedor
     * @param cpf identificador do cliente
     * @param fornecedor identificador do fornecedor
     * @return String
     */
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
        resultado.append("Cliente: ")
                .append(conta.getCliente().getNome())
                .append(" | ")
                .append(conta.toString());
        return resultado.toString();
    }

    /**
     * Exibe todas contas de um cliente
     * @param cpf idetificador de cliente
     * @return String
     */
    public String exibeContasClientes(String cpf){
        Validador.prefixoError="Erro ao exibir contas do cliente";
        Validador.validaCPF(cpf);
        if ( !this.clientes.encontraCliente(cpf) )
            throw new IllegalArgumentException(Validador.prefixoError + ": cliente nao existe.");

        StringBuilder resultado = new StringBuilder("");

        resultado.append("Cliente: ")
                .append( this.clientes.getCliente(cpf).getNome() )
                .append(" | ");

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

    /**
     * Remove uma conta e suas compras de um cliente com algum fornecedor
     * @param cpf identificador do cliente
     * @param fornecedor identificador do fornecedor
     */
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

    /**
     * Determina o critério de ordenação da listagem das compras do sistema
     * @param criterio valor do critério
     */
    public void ordenaPor(String criterio){
        Validador.prefixoError="Erro na listagem de compras";
        Validador.validaString("criterio nao pode ser vazio ou nulo.", criterio);
        criterio = criterio.toLowerCase();

        if (criterio.equals("cliente")) this.criterioOrdenacao = CriterioOrdenacao.CLIENTE;
        else if (criterio.equals("fornecedor")) this.criterioOrdenacao = CriterioOrdenacao.FORNECEDOR;
        else if (criterio.equals("data")) this.criterioOrdenacao = CriterioOrdenacao.DATA;
        else throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
    }

    /**
     * Retorna todas as compras do sistema
     * @return List
     */
    private List<Compra> getCompras(){
        List<Compra> compras = new ArrayList<>();
        for (Conta conta: this.getContas())
            compras.addAll( conta.getCompras() );
        return compras;
    }

    /**
     * Lista as compras por cliente
     * @return String
     */
    private String listarOrdernadoPorCliente(){
        List<Compra> compras = getCompras();
        compras.sort(new ComparetorCompraPorCliente());

        StringBuilder resultado = new StringBuilder("");
        Iterator<Compra> compraIterator = compras.iterator();
        Compra compra;

        while (compraIterator.hasNext()){
            compra = compraIterator.next();
            resultado.append( compra.getCliente().getNome() )
                    .append(", ")
                    .append( compra.exibePorCliente() );
            if (compraIterator.hasNext()) resultado.append(" | ");
        }
        return resultado.toString();
    }

    /**
     * Lista as compras por fornecedor
     * @return String
     */
    private String listarOrdernadoPorFornecedor(){
        List<Compra> compras = getCompras();
        compras.sort(new ComparetorCompraPorFornecedor());

        StringBuilder resultado = new StringBuilder("");
        Iterator<Compra> compraIterator = compras.iterator();
        Compra compra;

        while (compraIterator.hasNext()){
            compra = compraIterator.next();
            resultado.append( compra.getFornecedor().getNome() )
                    .append(", ")
                    .append( compra.exibePorFornecedor() );
            if (compraIterator.hasNext()) resultado.append(" | ");
        }
        return resultado.toString();
    }

    /**
     * Lista as compras por data
     * @return String
     */
    private String listarOrdernadoPorData(){
        List<Compra> compras = getCompras();
        compras.sort(new ComparetorCompraPorData());

        StringBuilder resultado = new StringBuilder("");
        Iterator<Compra> compraIterator = compras.iterator();
        Compra compra;

        while (compraIterator.hasNext()){
            compra = compraIterator.next();
            resultado.append( compra.exibeData().replace("-", "/") )
                    .append(", ")
                    .append( compra.exibePorData() );
            if (compraIterator.hasNext()) resultado.append(" | ");
        }
        return resultado.toString();
    }

    /**
     * Lista as compras de acordo com o critério definedo no sistema pelo usuário
     * @return String
     */
    public String listarCompras(){
        if (this.criterioOrdenacao == null)
            throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");

        switch (this.criterioOrdenacao){
            case CLIENTE: return this.listarOrdernadoPorCliente();
            case FORNECEDOR: return this.listarOrdernadoPorFornecedor();
            case DATA: return this.listarOrdernadoPorData();
            default: return null;
        }
    }
}
