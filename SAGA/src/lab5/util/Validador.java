package lab5.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe de validação dos argumentos de entrado do sistema
 * @author Charles Bezerra de Oliveira Júnior - 119110595
 */
public class Validador {
    /**
     * Prefixa de mensagem de erro, sempre deve ser alterado de acorde com a mensagem da exceção
     */
    public static String prefixoError;

    /**
     * Valida argumentos e variáveis do tipo String
     * @param msg mensagem de erro
     * @param valor valor a ser validado
     * @return String valor validador
     */
    public static String validaString(String msg, String valor){
        if (valor == null || valor.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": " + msg);
        return valor;
    }

    /**
     * Valido o preco de artigos do sistema
     * @param valor valor a ser verificado se é válido > 0
     * @return valor validado
     */
    public static double validaPreco(Double valor) {
    	if (valor == null)
    	    throw new IllegalArgumentException(prefixoError + ": preco nao pode ser vazio ou nulo.");
    	if ( valor < 0 )
            throw new IllegalArgumentException(prefixoError + ": preco invalido.");
    	return valor;
    }

    /**
     * Valida fatores de porcentagens no sistema
     * @param valor valor a ser verificado
     * @return valor que foi verificado
     */
    public static double validaFator(Double valor) {
        if (valor == null)
            throw new IllegalArgumentException(prefixoError + ": fator nao pode ser vazio ou nulo.");
        if ( valor <= 0.0 || valor >= 1.0 )
            throw new IllegalArgumentException(prefixoError + ": fator invalido.");
        return valor;
    }

    /**
     * Valida argumentos e parametros do tipo double
     * @param msg sufixo da mensagem de erro da exceção
     * @param valor valor a ser verificado
     * @return retorna o valor verificado
     */
    public static double validaDouble(String msg, Double valor) {
        if (valor == null)
            throw new IllegalArgumentException(prefixoError + ": " + msg);
        return valor;
    }

    /**
     * Valida os CPFs do sistema
     * @param cpf
     * @return valor verificado
     */
    public static String validaCPF(String cpf){
        if (cpf == null || cpf.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": cpf nao pode ser vazio ou nulo.");
        if (cpf.length() != 11)
            throw new IllegalArgumentException(prefixoError + ": cpf invalido.");
        return cpf;
    }

    /**
     * Valida variaveis do tipo LocalDate
     * @param data
     * @return LocalDate
     */
    public static LocalDate validaData(String data) {
        validaDataValida(data);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataOut = LocalDate.parse(data, formato);
        return dataOut;
    }

    /**
     * Valida variaveis do tipo String que representa uma data
     * @param data
     */
    private static void validaDataValida(String data) {
        if (data == null || data.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": data nao pode ser vazia ou nula.");
        String[] listaData = data.split("/|-");
        if ( listaData[0].length() != 2 || listaData[1].length() != 2 || listaData[2].length() != 4)
            throw new IllegalArgumentException(prefixoError + ": data invalida.");
    }
}
