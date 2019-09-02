package classes;

import java.time.LocalDate;
/* Comecando com objetos: unidade básica de composição
 * 
 * Por: Lívia Sampaio Campos
 * Observacao: Esse codigo é uma prova de conceito,
 * portanto, pode estar incompleto ou com algumas 
 * simplificações.
 */
public class Aluno {
	private String nome, periodoDeIngresso;
	private double cra;
	private int creditosAcumulados;
	private LocalDate dataDeIngresso;//composição
	private int HORA_AULA = 15;
	
	public Aluno(String nome, String periodoDeIngresso) {
		this(nome, periodoDeIngresso, LocalDate.now());
	}
	
	public Aluno(String nome, String periodoDeIngresso, LocalDate data) {
		this.nome = nome;
		this.periodoDeIngresso = periodoDeIngresso;
		dataDeIngresso = data;
	}
	
	public String getDataIngresso() {
		return dataDeIngresso.toString();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getPeriodoDeIngresso() {
		return periodoDeIngresso;
	}
	public double getCra() {
		return cra;
	}
	public int getCreditosAcumulados() {
		return creditosAcumulados;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCra(double cra) {
		this.cra = cra;
	}
	public void acumulaCreditos(int creditos) {
		this.creditosAcumulados += creditos;
	}
	
	public int calculaCargaHoraria() {
		return creditosAcumulados * HORA_AULA;
	}
	@Override
	public String toString() {
		return "Nome: " + getNome() + " cra: " + getCra();
	}
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Pedro", "2018.2");
		Aluno a2 = new Aluno("Matheus", "2019.1");
		Aluno a3 = new Aluno("Joicy", "2019.1");
		
		a3.setCra(7);
		a2.setCra(7.1);
		a1.setCra(7.2);
		a2.acumulaCreditos(16);
		System.out.println(a1.getNome() + " dataIngresso: " + a1.getDataIngresso());
		System.out.println(a1.getNome() + " creditos: " + a1.getCreditosAcumulados());
		System.out.println(a2.getNome() + " creditos: " + a2.getCreditosAcumulados());
		System.out.println(a1.toString());
		System.out.println(a2);
		System.out.println(a3);
		
	}

}
