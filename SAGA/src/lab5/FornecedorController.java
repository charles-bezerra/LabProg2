package lab5;

import java.util.*;


/**
 * Classe que representa o CRUD do fornecedor
 *
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class FornecedorController {
    /**
     * Coleção que guarda os vários fornecedores
     */
    private Map<String, Fornecedor> fornecedores;
    /**
     * Construtor que atribui valor a fornecedores
     */
    FornecedorController(){
        this.fornecedores = new HashMap<>();
    }

    /**
     * Ordena e retorna todos os fornecedores em ordem alfabética
     * @return ArrayList -> Fornecedor
     */
    private List<Fornecedor> getFornecedoresOrdenados() {
    	if (this.fornecedores.isEmpty())
    		return null;
    	List<Fornecedor> fornecedores =  new ArrayList<>( this.fornecedores.values() );
		Collections.sort(fornecedores);
		return fornecedores;
    }

    /**
     * Verifica se existe um fornecedor no sistema
     * @param nome identificador de fornecedor
     * @return boolean
     */
    public boolean encontraFornecedor(String nome){
        if (this.fornecedores.containsKey(nome))
            return true;
        return false;
    }

    /**
     * Recupera um fornecedor
     * @param nome identificador de fornecedor
     * @return Fornecedor
     */
    public Fornecedor getFornecedor(String nome){
        return this.fornecedores.get(nome);
    }

    /**
     * Recupera todos os fornecedores
     * @param cpf
     * @return
     */
    public List<Fornecedor> getFornecedores(String cpf){
        return new ArrayList<>( this.fornecedores.values() );
    }

    /**
     * Adiciona um fornecedor ao CRUD
     * @param nome atribui valor ao nome do fornecedor
     * @param email atribui valor ao email do fornecedor
     * @param telefone atribui valor ao telefone do fornecedor
     * @return retorna o nome
     */
    public String adiciona(String nome, String email, String telefone){
        if (this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        return nome;
    }

    /**
     * Exibe um fornecedor
     * @param nome nome que identifica o fornecedor
     * @return retorna respresentação textual de fornecedor
     */
    public String exibe(String nome){
        Validador.prefixoError = "Erro na exibicao do fornecedor";
        Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        return this.fornecedores.get(nome).toString();
    }


    /**
     * Exisbe todos os fornecedores em ordem alfabética alfabética
     * @return String
     */
    public String exibeFornecedores(){
        if (this.getFornecedoresOrdenados() == null)
            return null;

        StringBuilder resultado = new StringBuilder("");
        Iterator<Fornecedor> fornecedores = this.getFornecedoresOrdenados().iterator();

        while (fornecedores.hasNext()){
            resultado.append( this.exibe( fornecedores.next().getNome() ) );

            if (fornecedores.hasNext())
                resultado.append(" | ");
        }

        return resultado.toString();
    }

    /**
     * Lista todos os fornecedores
     * @return retorna respresentação textual de todos os fornecedores
     */
    public String lista(){
        StringBuilder lista = new StringBuilder("");
        Iterator<String> fornercedores = this.fornecedores.keySet().iterator();
        while (fornercedores.hasNext()){
            lista.append( this.exibe(fornercedores.next()) );
            if (fornercedores.hasNext()) lista.append(" | ");
        }
        return lista.toString();
    }

    /**
     * Edita um atributo de fornecedor
     * @param nome nome que identifica o fornecedor
     * @param atributo o atributo a ser alterado
     * @param novoValor novo valor
     */
    public void edita(String nome, String atributo, String novoValor){
    	Validador.prefixoError="Erro na edicao do fornecedor";
    	Validador.validaString("nome nao pode ser vazio ou nulo.", nome);
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        this.fornecedores.get(nome).edita(atributo, novoValor);
    }

    /**
     * Remove um fornecedor
     * @param nome nome que identifica o fornecedor
     */
    public void remove(String nome){
    	Validador.prefixoError="Erro na remocao do fornecedor";
    	Validador.validaString("nome do fornecedor nao pode ser vazio ou nulo.", nome);
        if (!this.fornecedores.containsKey(nome))
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        this.fornecedores.remove(nome);
    }

    /**
     * Verifica se existe um produto em fornecedor
     * @param fornecedor
     * @param nome identificador do produto
     * @param descricao identificador do produto
     * @return boolean
     */
    public boolean encontraProdutoFornecedor(String fornecedor, String nome, String descricao){
        return this.fornecedores.get(fornecedor).encontraProduto(nome, descricao);
    }

    /**
     * Recupera um determinado produto de um determinado fornecedor
     * @param fornecedor identificador de fornecedor
     * @param nome identificador do produto
     * @param descricao identificador do produto
     * @return Produto
     */
    public Produto getProdutoFornecedor(String fornecedor, String nome, String descricao){
        return this.getFornecedor(fornecedor).getProduto(nome, descricao);
    }

    /**
     * Adiciona um produto a fornecedor
     * @param fornecedor atribui o fornecedor a um produto
     * @param nome atribui o nome do produto
     * @param descricao atribui a descricao de produto
     * @param preco atribui o preco de produto
     */
    public void adicionaProduto(String fornecedor, String nome, String descricao, Double preco){
    	Validador.prefixoError="Erro no cadastro de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        this.getFornecedor(fornecedor).adicionaProduto(nome, descricao, preco);
    }

    /**
     * Exibe um produto de um fornecedor
     * @param fornecedor nome que identifica um fornecedor
     * @param nome nome do produto
     * @param descricao descrição do produto
     * @return retorna a representação textual de um produto
     */
    public String exibeProduto(String nome, String descricao, String fornecedor){
        Validador.prefixoError="Erro na exibicao de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        return this.getFornecedor(fornecedor).exibeProduto(nome,descricao);
    }

    /**
     * Exibe todas as representações dos produtos de todos fornecedores em ordem alfabética
     * @return String com todas as representações dos produtos de todos fornecedores em ordem alfabética
     */
    public String exibeProdutos() {
        if (this.getFornecedoresOrdenados() == null)
            return null;

        Iterator<Fornecedor> fornecedores = this.getFornecedoresOrdenados().iterator();
        Iterator<String> listaDeProdutosDoFornecedor;

        StringBuilder resultado = new StringBuilder("");

        Fornecedor fornecedor;

        while( fornecedores.hasNext() ) {
            fornecedor = fornecedores.next();

            if (fornecedor.exibeProdutos() != null) {
                listaDeProdutosDoFornecedor = fornecedor.exibeProdutos().iterator();

                while (listaDeProdutosDoFornecedor.hasNext()) {
                    resultado.append(fornecedor.getNome());
                    resultado.append(" - ");
                    resultado.append(listaDeProdutosDoFornecedor.next());
                    if (listaDeProdutosDoFornecedor.hasNext()) resultado.append(" | ");
                }
            }
            else{
                resultado.append( fornecedor.getNome() );
                resultado.append( " -" );
            }

            if (fornecedores.hasNext())
                resultado.append(" | ");
        }
    	return resultado.toString();
    }
    
    
    /**
     * Lista todos os produtos de um fornecedor
     * @param fornecedor nome que identifica o fornecedor
     * @return retorna todos as representações textuais dos produtos de fornecedor
     */
    public String exibeProdutosFornecedor(String fornecedor){
        Validador.prefixoError="Erro na exibicao de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.encontraFornecedor(fornecedor))
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");;

        StringBuilder resultado = new StringBuilder("");
        List<String> produtosFornecedor = new ArrayList<>( this.fornecedores.get(fornecedor).exibeProdutos() );

        if (produtosFornecedor.isEmpty())
            return null;

        Iterator<String> produtosIterator = produtosFornecedor.iterator();

        while (produtosIterator.hasNext()){
            resultado.append( fornecedor );
            resultado.append(" - ");
            resultado.append( produtosIterator.next() );
            if ( produtosIterator.hasNext() )
                resultado.append(" | ");
        }

        return resultado.toString();
    }

    /**
     * Edita um produto de um fornecedor 
     * @param fornecedor nome que identifica um fornecedor
     * @param nome nome do produto
     * @param descricao descrição de um produto
     * @param novoPreco novo preço
     */
    public void editaProduto(String nome, String descricao, String fornecedor, Double novoPreco){
        Validador.prefixoError="Erro na edicao de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        this.getFornecedor(fornecedor).editaProduto(nome, descricao, novoPreco);
    }

    /**
     * Remove um produto de um fornecedor
     * @param fornecedor nome que identifica um fornecedor
     * @param nome nome do produto
     * @param descricao descrição de um produto
     */
    public void removeProduto(String nome, String descricao, String fornecedor){
        Validador.prefixoError="Erro na remocao de produto";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);
        if (!this.fornecedores.containsKey(fornecedor))
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        this.getFornecedor(fornecedor).removeProduto(nome, descricao);
    }


    /**
     * Adiciona um combo nos produtos do fornecedor
     * @param fornecedor
     * @param nome
     * @param descricao
     * @param fator
     * @param produtos
     */
    public void adicionaCombo(String fornecedor, String nome, String descricao, Double fator, String produtos) {
        Validador.prefixoError="Erro no cadastro de combo";
        Validador.validaString("fornecedor nao pode ser vazio ou nulo.", fornecedor);

        if ( !this.encontraFornecedor(fornecedor) )
            throw new IllegalArgumentException(Validador.prefixoError + ": fornecedor nao existe.");

        this.getFornecedor(fornecedor).adicionaCombo(nome, descricao, fator, produtos);
    }


    public void editaCombo(String fornecedor, String nome, String descricao, Double novoFator){
        this.getFornecedor(fornecedor).editaCombo(nome, descricao, novoFator);
    }
}
