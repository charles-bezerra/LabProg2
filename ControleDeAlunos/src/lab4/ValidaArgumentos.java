package lab4;

/**
 * Classe responsável por validar parametros de todo o sistema
 */
public class ValidaArgumentos {
    /**
     * Função que verifica as entradas Strings do sistema
     *
     * @param argumento valor a ser verificado para ser considerado válido ou não
     * @param variavel o nome da variável que está sendo verificada
     * @return retorna o argumento se ele for válido
     */
    public static String verificarString(String argumento, String variavel){
        if (argumento == null)
            throw new NullPointerException();
        String subArgumento = argumento.trim();
        if (subArgumento.equals(""))
            throw new IllegalArgumentException("O ARGUMENTO <" + variavel + "> DEVE CONTER VALORES DIFERENTES DE VAZIO");
        return subArgumento;
    }

    /**
     * Função que verifica as entradas com tipo Aluno no sistema
     *
     * @param argumento valor a ser verificado para ser considerado válido ou não
     * @return retorna o argumento se ele for válido
     */
    public static  Aluno verificarAluno(Aluno argumento){
        if (argumento == null)
            throw new NullPointerException();
        if (argumento.getClass() != Aluno.class)
            throw new IllegalArgumentException("O ARGUMENTO DEVE CONTER UM OBJETO DO TIPO: Aluno");
        return argumento;
    }
}
