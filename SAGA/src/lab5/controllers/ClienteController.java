package lab5.controllers;

import lab5.classes.*;
import lab5.util.Validador;

import java.util.*;

/**
 * Classe CRUD de Cliente
 *
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class ClienteController {
    /**
     * Coleção contendo <cpf, Cliente>
     */
	private Map<String, Cliente> clientes;

	/**
	 * Construtor que inicializa this.clientes
	 */
    public ClienteController(){
        this.clientes = new HashMap<>();
    }

    private List<Cliente> getClientesOrdenados(){
        if ( this.clientes.isEmpty() )
            return null;

        List<Cliente> clientes = new ArrayList<>( this.clientes.values() );
        Collections.sort(clientes);

        return clientes;
    }

    /**
     * Verifica se existe um cliente pelo seu cpf
     * @param cpf identificador de cliente
     * @return boolean
     */
    public boolean encontraCliente(String cpf){
        return this.clientes.containsKey(cpf);
    }

    /**
     * Encontra e retorna um cliente
     * @param cpf identificador de cliente
     * @return Cliente
     */
    public Cliente getCliente(String cpf){
        return this.clientes.get(cpf);
    }

    /**
     * Retorna uma lista contendo todos os clientes cadastrados
     * @return List de clientes
     */
    public List<Cliente> getClientes(){
        return new ArrayList<>( this.clientes.values() );
    }

    /**
     * Método que adiciona um cliente na coleção clientes
     * @param cpf identificador único de um cliente
     * @param nome nome do cliente
     * @param email email do cliente
     * @param localizacao local do cliente
     * @return cpf se a execução for bem sucedida
     */
    public String adiciona(String cpf, String nome, String email, String localizacao){
        if ( this.clientes.containsKey(cpf) )
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        this.clientes.put(cpf, new Cliente(cpf,nome,email,localizacao) );
        return cpf;
    }

    /**
     * Método que retorna a representação de um aluno
     * @param cpf identificador único de um cliente
     * @return repesentação de cliente <nome - email - local>
     */
    public String exibe(String cpf){
        Validador.prefixoError = "Erro na exibicao do cliente";
        cpf = Validador.validaString("cpf nao pode ser vazio ou nulo.", cpf);
        if (!this.clientes.containsKey(cpf))
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        return this.clientes.get(cpf).toString();
    }


    /**
     * Lista todos clientes cadastrados em ordem alfabética
     * @return  repesentação de cliente de todos os clientes separados com < | >
     */
    public String exibeClientes(){
        if (this.getClientesOrdenados() == null)
            return null;

        StringBuilder resultado = new StringBuilder("");
        Iterator<Cliente> clientes = this.getClientesOrdenados().iterator();

        while (clientes.hasNext()){
            resultado.append( this.exibe( clientes.next().getCPF() ) );

            if (clientes.hasNext())
                resultado.append(" | ");
        }

        return resultado.toString();
    }

    /**
     * Lista todos clientes cadastrados
     * @return  repesentação de cliente de todos os clientes separados com < | >
     */
    public String lista(){
        StringBuilder exibir = new StringBuilder();
        Iterator<String> clientes = this.clientes.keySet().iterator();
        while (clientes.hasNext()){
            exibir.append(this.exibe(clientes.next()));
            if (clientes.hasNext())
                exibir.append(" | ");
        }
        return exibir.toString();
    }

    /**
     * Edita um cliente, menos o cpf
     * @param cpf  identificador único de um cliente
     * @param atributo atributo a ser alterado
     * @param novoValor novo valor do atributo
     */
    public void edita(String cpf, String atributo, String novoValor){
        Validador.prefixoError = "Erro na edicao do cliente";
        cpf = Validador.validaString("cpf nao pode ser vazio ou nulo.", cpf);
        if (!this.clientes.containsKey(cpf))
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        this.clientes.get(cpf).edita(atributo, novoValor);
    }


    /**
     * Método que remove um cliente
     * @param cpf  identificador único de um cliente
     * @return boolean true se foi removido com sucesso
     */
    public boolean remove(String cpf){
        Validador.prefixoError = "Erro na remocao do cliente";
        Validador.validaString("cpf nao pode ser vazio ou nulo", cpf);

        if ( !this.clientes.containsKey(cpf) )
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");

        this.clientes.remove(cpf);
        return true;
    }
}
