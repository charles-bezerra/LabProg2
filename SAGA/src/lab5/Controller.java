package lab5;

public class Controller {
    private ClienteController clientes;
    private FornecedorController fornecedores;

    public Controller(){
        this.clientes = new ClienteController();
        this.fornecedores = new FornecedorController();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao){
        return this.clientes.adiciona(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf){
        return this.clientes.exibe(cpf);
    }

    public String exibeClientes(){
        return this.clientes.exibeClientes();
    }

    public String listaClientes(){
        return this.clientes.lista();
    }

    public void editaCliente(String cpf, String atributo, String novoValor){
        this.clientes.edita(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf){
        this.clientes.remove(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone){
        return this.fornecedores.adiciona(nome, email, telefone);
    }

    public String exibeFornecedor(String nome){
        return this.fornecedores.exibe(nome);
    }

    public String exibeFornecedores(){
        return this.fornecedores.exibeFornecedores();
    }

    public String listaFornecedores(){
        return  this.fornecedores.lista();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor){
        this.fornecedores.edita(nome,atributo,novoValor);
    }

    public void removeFornecedor(String nome){
        this.fornecedores.remove(nome);
    }

    public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco){
        this.fornecedores.adicionaProduto(fornecedor, nome, descricao, preco);
    }

    public String exibeProduto(String nome, String descricao, String fornecedor){
        return this.fornecedores.exibeProduto(nome, descricao, fornecedor);
    }

    public String exibeProdutos(){
        return  this.fornecedores.exibeProdutos();
    }

    public String exibeProdutosFornecedor(String fornecedor){
        return this.fornecedores.exibeProdutosFornecedor(fornecedor);
    }

    public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco){
        this.fornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
    }

    public void removeProduto(String nome, String descricao, String fornecedor){
        this.fornecedores.removeProduto(nome, descricao, fornecedor);
    }
}
