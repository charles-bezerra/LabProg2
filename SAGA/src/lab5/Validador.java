package lab5;

public class Validador {
    public static String prefixoError;

    public static String validaString(String msg, String valor){
        if (valor == null || valor.trim().equals(""))
            throw new IllegalArgumentException(prefixoError + ": " + msg);
        return valor;
    }
    
    public static Double validaDouble(String msg, Double valor) {
    	if (valor == null)
            throw new IllegalArgumentException(prefixoError + ": " + msg);
    	return valor;
    }
}
