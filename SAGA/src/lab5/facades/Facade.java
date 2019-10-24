package lab5.facades;

import lab5.controllers.ClienteController;
import lab5.controllers.ContaController;
import lab5.controllers.FornecedorController;

public class Facade {
    private ClienteController clientes;
    private FornecedorController fornecedores;
    private ContaController contas;

    public Facade() {
        this.clientes = new ClienteController();
        this.fornecedores = new FornecedorController();
        this.contas = new ContaController(this.clientes, this.fornecedores);
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.clientes.adiciona(cpf, nome, email, localizacao); }

    public String exibeCliente(String cpf) { return this.clientes.exibe(cpf); }

    public String exibeClientes() { return this.clientes.exibeClientes(); }

    public String listaCliente() { return this.clientes.lista(); }

    public void editaCliente(String cpf, String atributo, String novoValor) {
        this.clientes.edita(cpf, atributo, novoValor); }

    public void removeCliente(String cpf) { this.clientes.remove(cpf); }

    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.fornecedores.adiciona(nome, email, telefone); }

    public String exibeFornecedor(String nome) { return this.fornecedores.exibe(nome); }

    public String exibeFornecedores() { return this.fornecedores.exibeFornecedores(); }

    public String listaFornecedores() { return this.fornecedores.lista(); }

    public void editaFornecedor(String nome, String atributo, String novoValor) { this.fornecedores.edita(nome, atributo, novoValor); }

    public void removeFornecedor(String nome) { this.fornecedores.remove(nome); }

    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
        this.fornecedores.adicionaProduto(fornecedor, nome, descricao, preco); }

    public String exibeProduto(String nome, String descricao, String fornecedor) {
        return this.fornecedores.exibeProduto(nome, descricao, fornecedor); }

    public String exibeProdutos() {
        return this.fornecedores.exibeProdutos(); }

    public String exibeProdutosFornecedor(String fornecedor) {
        return this.fornecedores.exibeProdutosFornecedor(fornecedor); }

    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
        this.fornecedores.editaProduto(nome, descricao, fornecedor, novoPreco); }

    public void removeProduto(String nome, String descricao, String fornecedor) {
        this.fornecedores.removeProduto(nome, descricao, fornecedor); }


    public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
        this.fornecedores.adicionaCombo(fornecedor, nome, descricao, fator, produtos); }

    public void editaCombo(String fornecedor, String nome, String descricao, double novoFator) {
        this.fornecedores.editaCombo(fornecedor, nome, descricao, novoFator); }

    public String adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto) {
        return this.contas.adicionaCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto); }

    public String exibeContas(String cpf, String fornecedor) { return this.contas.exibeContas(cpf, fornecedor); }

    public String exibeContasClientes(String cpf) { return this.contas.exibeContasClientes(cpf); }

    public String getDebito(String cpf, String fornecedor) { return this.contas.getDebito(cpf, fornecedor); }

    public void realizaPagamento(String cpf, String fornecedor) { this.contas.realizaPagamento(cpf, fornecedor); }

    public void ordenaPor(String criterio) { this.contas.ordenaPor(criterio); }

    public String listarCompras(){ return this.contas.listarCompras(); }
}