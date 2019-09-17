package lab4;

import java.util.Objects;

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

	@Override
	public int hashCode(){
		return Objects.hash(this.matricula);
	}

	@Override
	public String toString(){
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	@Override
	public boolean equals(Object object){
		if(object == this) return true;
		if(object == null) return false;
		if(object.getClass() != this.getClass()) return false;

		Aluno outroObjeto = (Aluno) object;
		return outroObjeto.hashCode() == this.hashCode();
	}
}
