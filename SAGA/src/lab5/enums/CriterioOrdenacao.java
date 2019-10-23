package lab5.enums;

public enum CriterioOrdenacao {
    CLIENTE("cliente"), FORNECEDOR("fornecedor"), DATA("data");

    String criterio;

    CriterioOrdenacao(String criterio){
        this.criterio = criterio;
    }

    public String getCriterio(){ return this.criterio; }
}
