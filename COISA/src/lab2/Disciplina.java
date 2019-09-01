package lab2;

/**
* Representação de uma disciplina de Aluno
* para manter o registro de notas e as horas
* de estudos, podendo confirmar a situação da
* aprovação do aluno.
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/


public class Disciplina {
	
	/**
	 * Guarda o nome da disciplina.
	 * */
	private String nomeDisciplina;
	
	/**
	 * Guarda quantidade das horas de estudos.
	 * */
	private int horasEstudo = 0;
	
	/**
	 * Array double que guarda as notas na disciplina.
	 * */
	private double[] notas;
	
	/**
	 * Array inteiro que guarda os pesos das notas da disciplina.
	 * */
	private int[] pesosNotas;
	
	/** 
	 * Constroi a disciplina com o nome da disciplina.
	 * 
	 * @param nomeDisciplina nome da disciplina
	*/
	Disciplina (String nomeDisciplina){
		this(nomeDisciplina, 4, null);
	}
	
	/** 
	 * Constroi a disciplina com o nome da disciplina e o numero de notas.
	 * 
	 * @param nomeDisciplina nome da disciplina
	 * @param numeroNotas numero de notas que o aluno vai ter
	*/
	Disciplina (String nomeDisciplina, int numeroNotas){
		this(nomeDisciplina, numeroNotas, null);
	}
	
	/** 
	 * Constroi a disciplina com o nome da disciplina e o numero de notas e seus respectivos pesos.
	 * 
	 * @param nomeDisciplina nome da disciplina
	 * @param numeroNotas numero de notas que o aluno vai ter
	 * @param pesosNotas array com os pesos das respectivas notas
	*/
	Disciplina (String nomeDisciplina, int numeroNotas, int[] pesosNotas){
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[numeroNotas];
		if(pesosNotas == null) 
			this.pesosNotas = this.preencherNotasComPesos1(numeroNotas);
		else 
			this.pesosNotas = pesosNotas;
		this.preencherNotasComZero();
	}

	/**
	 * Preenche o array pesosNotas com o litaral 1.
	 * */
	private int[] preencherNotasComPesos1(int numeroNotas) {
		int[] pesos = new int[numeroNotas];
		for(int i = 0; i < numeroNotas; i++)
			pesos[i] = 1;
		return pesos;
	}
	
	/**
	 * Preenche o array notas com literal 0.
	 * */
	private void preencherNotasComZero() {
		for(int i = 0; i < this.notas.length; i++) 
			this.notas[i] = 0;
	}
	
	
	/**
	 * Cadastra as horas de estudos de Aluno na variavel this.horasEstudo .
	 * 
	 * @param horas valor adicionado a horasEstudos
	 * */
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}

	
	/**
	 * Cadastra uma respectiva nota no array this.notas .
	 * 
	 * @param nota a nota a ser adicionada ou alterada
	 * @param valorNota valor da nota 
	 * */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	
	/**
	 * Retorna a media do aluno com base em suas notas e seus pesos de cada nota
	 *
	* @return media o valor do calculo da media das notas com o pesos respectivos pesos.
	*/
	public double mediaDisciplina() {
		int media = 0, acumulaValorPesos = 0;
		for(int i = 0; i < this.notas.length; i++) {			
			media += this.notas[i]*this.pesosNotas[i];
			acumulaValorPesos += this.pesosNotas[i];
		}
		media /= acumulaValorPesos;
		return media;
	}
	
	
	/**
	* Retorna o boolean a respeito da condição de aprovação.
	*
	* @return se Aluno está aprovado nessa disciplina.
	*/
	public boolean aprovado() {
		if(this.mediaDisciplina() >= 7) return true;
		else return false;
	}
	
	
	/**
	* Retorna o String contendo o nome da Disciplina.
	*
	* @return String contendo o nomeDisciplina.
	*/
	public String getNomeDisciplina() {
		return this.nomeDisciplina;
	}
	
	
	/**
	* Retorna o String contendo a representação da displina.
	*
	* @return String contendo formato "|horas de estudo| |media| |[nota1, nota2 ... notasN]|".
	*/
	public String toString() {
		return this.nomeDisciplina + " " 
			   + this.horasEstudo + " " 
			   + this.mediaDisciplina() + 
			   " [" + this.notas[0] + ", " 
			   + this.notas[1] + ", " 
			   + this.notas[2] + ", " 
			   + this.notas[3] + "]";
	}
	
}
