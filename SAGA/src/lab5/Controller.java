package lab5;

import java.util.Iterator;

public class Controller {
    private ClienteController clientes;
    private FornecedorController fornecedores;
    private ContaController contas;

    public Controller() {
        this.clientes = new ClienteController();
        this.fornecedores = new FornecedorController();
        this.contas = new ContaController();
    }

    //Clientes
    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.clientes.adiciona(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf) {
        return this.clientes.exibe(cpf);
    }

    public String exibeClientes() {
        return this.clientes.exibeClientes();
    }

    public String listaClientes() {
        return this.clientes.lista();
    }

    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.clientes.edita(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf) {
        this.clientes.remove(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.fornecedores.adiciona(nome, email, telefone);
    }

    //Fornecedores
    public String exibeFornecedor(String nome) {
        return this.fornecedores.exibe(nome);
    }

    public String exibeFornecedores() {
        return this.fornecedores.exibeFornecedores();
    }

    public String listaFornecedores() {
        return this.fornecedores.lista();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor) {
        this.fornecedores.edita(nome, atributo, novoValor);
    }

    public void removeFornecedor(String nome) {
        this.fornecedores.remove(nome);
    }

    //Produtos
    public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco) {
        this.fornecedores.adicionaProduto(fornecedor, nome, descricao, preco);
    }

    public String exibeProduto(String nome, String descricao, String fornecedor) {
        return this.fornecedores.exibeProduto(nome, descricao, fornecedor);
    }

    public String exibeProdutos() {
        return this.fornecedores.exibeProdutos();
    }

    public String exibeProdutosFornecedor(String fornecedor) {
        return this.fornecedores.exibeProdutosFornecedor(fornecedor);
    }

    public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco) {
        this.fornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
    }

    public void removeProduto(String nome, String descricao, String fornecedor) {
        this.fornecedores.removeProduto(nome, descricao, fornecedor);
    }

    //Compras
    public String adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto) {
        Validador.prefixoError = "Erro ao cadastrar compra";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        Validador.validaString("nome do produto nao pode ser vazio ou nulo.", nomeProduto);
        Validador.validaString("descricao do produto nao pode ser vazia ou nula.", descricaoProduto);

        if (!this.clientes.encontraCliente(cpf))
            throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");

        if (!this.fornecedores.encontraFornecedor(fornecedor))
            throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe");

        if (!this.fornecedores.encontraProdutoFornecedor(fornecedor, nomeProduto, descricaoProduto))
            throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");

        if (!this.contas.encontraConta(cpf, fornecedor)) {
            Cliente cliente = this.clientes.getCliente(cpf);
            Fornecedor fornecedorObj = this.fornecedores.getFornecedor(fornecedor);
            this.contas.adicionaConta(cliente, fornecedorObj);
        }

        Double preco = this.fornecedores.getProdutoFornecedor(fornecedor, nomeProduto, descricaoProduto).getPreco();
        return this.contas.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto, preco);
    }

    public String exibeContaCliente(String cpf, String fornecedor) {
        Validador.prefixoError = "Erro ao exibir conta do cliente";
        Validador.validaCPF(cpf);
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        if (!this.clientes.encontraCliente(cpf))
            throw new IllegalArgumentException(Validador.prefixoError + ": cliente nao existe.");

        if (!this.fornecedores.encontraFornecedor(fornecedor))
            throw new IllegalArgumentException(Validador.prefixoError + ": fornecedor nao existe");

        return this.contas.exibeContaCliente(cpf, fornecedor);
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

            contasIterator = this.contas.getContas().iterator();

            while (contasIterator.hasNext()) {
                conta = contasIterator.next();
                if (conta.getCliente().equals(cliente)) {
                    resultado.append(" | ");
                    resultado.append(conta.exibe());
                }
            }

            if (clientesIterator.hasNext())
                resultado.append(" | ");
        }

        return resultado.toString();
    }

    public Double getDebito(String cpf, String fornecedor) {
        return this.getDebito(cpf, fornecedor);
    }

    public void adicionaCombo(String fornecedor, String nome, String descricao, Double fator, String produtos) {
        this.fornecedores.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
    }
}