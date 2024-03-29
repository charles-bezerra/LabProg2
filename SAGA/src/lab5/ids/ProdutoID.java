package lab5.ids;
import java.util.Objects;

/**
  * Classe CRUD de produto
  * 
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 *
 */
public class ProdutoID{
    /**
     * Atributo que referencia o nome de um determinado produto
     */
    private String nome;
    /**
     * Atributo que referencia a descriçao de um determinado produto
     */
    private String descricao;

    /**
     * Construtor que inicializa o ProdutoID
     * @param nome nome que pertence a um determinado produto
     * @param descricao descriçao que pertence a um determinado produto
     */
    public ProdutoID(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * Retorna o nome do produto
     * @return String
     */
    public String getNome() {
    	return this.nome;
    }

    /**
     * Retorna a descrição do produto
     * @return String
     */
    public String getDescricao() {
    	return this.descricao;
    }

    @Override
    public String toString() {
    	return this.nome + " - " + this.descricao;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.nome)*3 + Objects.hash(this.descricao)*7;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;

        ProdutoID cod = (ProdutoID) o;
        return this.hashCode() == cod.hashCode();
    }
}
