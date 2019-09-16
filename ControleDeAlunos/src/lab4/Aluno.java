package lab4;

public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	Aluno(String matricula, String nome, String curso){
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	public String getMatricula(){ return this.matricula; }
	public String getNome() { return this.nome; }
	public String getCurso() { return this.curso; }

	public int hashCode(){ return this.matricula.hashCode(); }
	public String toString(){ return this.matricula + " - " + this.nome + " - " + this.curso; }
}
