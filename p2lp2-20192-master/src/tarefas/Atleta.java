package tarefas;

public class Atleta {
	private Exercicio[] exercicios;
	private String nome;
	private double altura;
	private int peso;
	
	public Atleta(String nome, double altura, int peso, String sexo) {
		//inicializacao dos atributos de atleta
	}
	
	public boolean adicionaExercicio(String nome, int calorias) {
		return true;
	}
	
	public String calculaIMC() {
		return "INTERMEDIARIO";
	}
	
	public int malha(int horas) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	

}
