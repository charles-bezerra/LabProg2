package lab5.enums;

/**
 * Enumerador que contem as opções de listagem por criterio
 */
public enum CriterioOrdenacao {
    CLIENTE("cliente"), FORNECEDOR("fornecedor"), DATA("data");

    /**
     * criterio de ordenação
     */
    String criterio;

    CriterioOrdenacao(String criterio){
        this.criterio = criterio;
    }

    /**
     * Retorna o criterio
     * @return String
     */
    public String getCriterio(){ return this.criterio; }
}
