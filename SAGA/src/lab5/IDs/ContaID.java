package lab5.IDs;

import lab5.classes.Validador;

/**
 * Classe que identifica uma conta de um cliente em um fornecedor
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 */
public class ContaID {
    /**
     * Identificador de um Cliente
     */
    private String cpf;
    /**
     * Identificador de um Fornecedor
     */
    private String fornecedor;

    /**
     * Constroi e inicia o identificador de uma conta
     * @param cpf identificador do cliente
     * @param fornecedor identificador do fornecedor
     */
    ContaID(String cpf, String fornecedor){
        Validador.prefixoError="Erro ao cadastrar compra";
        this.cpf = Validador.validaString("cpf nao pode ser vazio ou nulo", cpf);
        this.fornecedor = Validador.validaString("fornecedor nao pode ser vazio ou nulo", fornecedor);
    }

    /**
     * Retorna o cpf do cliente
     * @return String com o nome do cliente
     */
    public String getCPF(){
        return this.cpf;
    }

    /**
     * Retorna o nome do fornecedor
     * @return String com o nome do fornecedor
     */
    public String getFornecedor(){
        return this.fornecedor;
    }

    @Override
    public int hashCode(){
        return this.cpf.hashCode()*3 + this.fornecedor.hashCode()*7;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass())
            return false;

        ContaID outraContaID = (ContaID) o;
        return outraContaID.hashCode() == this.hashCode();
    }
}
