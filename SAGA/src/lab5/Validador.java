package lab5;

/**
 *
 */

public class Validador {
    public static String prefixoError;

    public static String validaString(String atributo, String valor){
        if (valor == null || valor.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": " + atributo  + " nao pode ser vazio ou nulo.");
        return valor;
    }
}
