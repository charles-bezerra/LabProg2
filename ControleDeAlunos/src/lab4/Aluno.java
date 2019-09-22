package lab4;
import java.util.Objects;

/**
 * Respresentação de um aluno
 */
public class Aluno {
	/**
	 * Identificador do aluno no sistema
	 */
	private String matricula;

	/**
	 * Guarda o nome do aluno
	 */
	private String nome;

	/**
	 * Guarda o curso atual do aluno
	 */
	private String curso;

	/**
	 * Construtor de aluno
	 *
	 * @param matricula String que inicializa o identificador de aluno
	 * @param nome String que inicializa o nome de aluno
	 * @param curso String que inicializa o curso de aluno
	 */
	Aluno(String matricula, String nome, String curso){
		this.matricula = ValidaArgumentos.verificarString(matricula, "matricula");
		this.nome = ValidaArgumentos.verificarString(nome, "nome");
		this.curso = ValidaArgumentos.verificarString(curso, "curso");
	}

	/**
	 * Método que retorna a matricula de aluno
	 * @return String matricula
	 */
	public String getMatricula(){ return this.matricula; }

	/**
	 * Método que retorna o nome de aluno
	 * @return String nome
	 */
	public String getNome() { return this.nome; }

	/**
	 * Método que retorna o curso de aluno
	 * @return String curso
	 */
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
		if(object == null) return false;
		if(object == this) return true;
		if(object.getClass() != this.getClass()) return false;

		Aluno outroObjeto = (Aluno) object;
		return outroObjeto.hashCode() == this.hashCode();
	}
}
