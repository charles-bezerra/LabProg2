package lab5;

import java.awt.*;
import java.lang.reflect.Array;

public class Validador {
    public static String prefixoError;

    public static String validaString(String msg, String valor){
        if (valor == null || valor.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": " + msg);
        return valor;
    }
    
    public static Double validaPreco(Double valor) {
    	if (valor == null)
    	    throw new IllegalArgumentException(prefixoError + ": preco nao pode ser vazio ou nulo.");

    	if ( valor < 0 )
            throw new IllegalArgumentException(prefixoError + ": preco invalido.");

    	return valor;
    }

    public static Double validaFator(Double valor) {
        if (valor == null)
            throw new IllegalArgumentException(prefixoError + ": fator nao pode ser vazio ou nulo.");

        if ( valor <= 0.0 || valor >= 1.0 )
            throw new IllegalArgumentException(prefixoError + ": fator invalido.");

        return valor;
    }

    public static Double validaDouble(String msg, Double valor) {
        if (valor == null)
            throw new IllegalArgumentException(prefixoError + ": " + msg);
        return valor;
    }

    public static String validaCPF(String cpf){
        if (cpf == null || cpf.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": cpf nao pode ser vazio ou nulo.");

        if (cpf.length() != 11)
            throw new IllegalArgumentException(prefixoError + ": cpf invalido.");

        return cpf;
    }

    public static String validaData(String data){
        if (data == null || data.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": data nao pode ser vazia ou nula.");

        String[] listaData = data.split("/|-");

        if ( listaData[0].length() != 2 || listaData[1].length() != 2 || listaData[2].length() != 4)
            throw new IllegalArgumentException(prefixoError + ": data invalida.");

        return data;
    }
}
