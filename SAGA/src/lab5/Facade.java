package lab5;

public class Facade {
    private ClienteController clientes;
    private FornecedorController fornecedores;

    Facade(){
        this.clientes = new ClienteController();
        this.fornecedores = new FornecedorController();
    }

    public void adicionarCliente(String cpf, String nome, String email, String localizacao){
        this.clientes.adiciona(cpf,nome,email,localizacao);
    }

    public String exibeCliente(String cpf){
        return this.clientes.exibe(cpf);
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

    public void adicionaFornecedor(String nome, String email, String telefone){
        this.fornecedores.adiciona(nome, email, telefone);
    }

    public String exibeFornecedor(String nome){
        return this.fornecedores.exibe(nome);
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
        this.fornecedores.adicionarProduto(fornecedor,nome,descricao,preco);
    }

    public String exibeProduto(String fornecedor, String nome, String descricao){
        return this.fornecedores.exibeProduto(fornecedor,nome,descricao);
    }

    public String listaProdutos(String fornecedor){
        return this.fornecedores.listaProdutos(fornecedor);
    }

    public void editaProduto(String fornecedor, String nome, String descricao, Double novoPreco){
        this.fornecedores.editaProduto(fornecedor, nome, descricao, novoPreco);
    }

    public void removeProduto(String fornecedor, String nome, String descricao){
        this.fornecedores.removeProduto(fornecedor, nome, descricao);
    }
}
