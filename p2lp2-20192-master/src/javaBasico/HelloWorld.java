package javaBasico;

public class HelloWorld {
	public static void main(String[] args) {
		String s = "A Sutil Arte De Ligar O F*da-Se, Mark Manson- Intrinseca";
		System.out.println(s);
		System.out.println(s.toUpperCase());
		System.out.println(s.replace("*", "@"));
		System.out.println(s.substring(0,31));
		int tam = s.length();
		System.out.println(tam + " caracteres");
		System.out.println(s.startsWith("b"));
		
	}

}
