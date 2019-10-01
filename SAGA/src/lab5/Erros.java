package lab5;

public class Erros{
    public static String verificaCadastro(String valor, String variavel, String entidade) {
        if (valor == null || valor.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro do " + entidade + ": " + variavel + " nao pode ser vazio ou nulo.");
        return valor;
    }
}
