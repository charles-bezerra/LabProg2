package lab5;

public class Facade {
	private Controller controller;
	
    public Facade(){
    	this.controller = new Controller();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao){
        return this.controller.adicionaCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf){
        return this.controller.exibeCliente(cpf);
    }

    public String exibeClientes(){
        return this.controller.exibeClientes();
    }

    public String listaCliente(){
        return this.controller.listaClientes();
    }

    public void editaCliente(String cpf, String atributo, String novoValor){
        this.controller.editaCliente(cpf, atributo, novoValor);
    }

    public void removeCliente(String cpf){
        this.controller.removeCliente(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone){
        return this.controller.adicionaFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome){
        return this.controller.exibeFornecedor(nome);
    }

    public String exibeFornecedores(){
        return this.controller.exibeFornecedores();
    }

    public String listaFornecedores(){
        return  this.controller.listaFornecedores();
    }

    public void editaFornecedor(String nome, String atributo, String novoValor){
        this.controller.editaFornecedor(nome,atributo,novoValor);
    }

    public void removeFornecedor(String nome){
        this.controller.removeFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco){
        this.controller.adicionaProduto(fornecedor, nome, descricao, preco);
    }

    public String exibeProduto(String nome, String descricao, String fornecedor){
        return this.controller.exibeProduto(nome, descricao, fornecedor);
    }

    public String exibeProdutos(){
        return this.controller.exibeProdutos();
    }

    public String exibeProdutosFornecedor(String fornecedor){
        return this.controller.exibeProdutosFornecedor(fornecedor);
    }

    public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco){
        this.controller.editaProduto(nome, descricao, fornecedor, novoPreco);
    }

    public void removeProduto(String nome, String descricao, String fornecedor){
        this.controller.removeProduto(nome, descricao, fornecedor);
    }
}
