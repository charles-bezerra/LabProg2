package lab2;

/**

* Representação de um Aluno no sistema
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/

public class Saude {
	/**
	 * String que guarda o estado da saúde física
	 * */
	private String saudeFisica;
	/**
	 * String que guarda o estado da saúde mental
	 * */
	private String saudeMental;
	/**
	 * String que guarda um emoji que opcional
	 * */
	private String emoji;
	
	/**
	* Constrói a Saude do Aluno.
	* Atribui por padrão this.saudeFisica this.saudeMental como boa.
	*
	*/
	Saude(){
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}
	
	/**
	*
	* Define a saúde mental do Aluno alterando a variavel this.saudeMental,
	* também reseta a variavel this.emoji
	*
	* @param valor contendo o estado da saude mental (boa/fraca)
	*/
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		this.definirEmoji("");
	}
	
	/**
	*
	* Define a saúde física do Aluno alterando a variavel this.saudeMental,
	* também reseta a variavel this.emoji
	*
	* @param valor contendo o estado da saude física (boa/fraca)
	*/
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		this.definirEmoji("");
	}
	
	/**
	*
	* Define ou altera a variavel this.emoji
	*
	* @param valor atribuida á this.emoji
	*/
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	/**
	* Retorna o String contendo o estado geral da Saúde do Aluno.
	*
	* @return "boa/fraca/ok (emoji)".
	*/
	public String getStatusGeral() {
		if( this.saudeFisica.equals("boa") && this.saudeMental.equals("boa") ) 
			return "boa " + this.emoji;
		else if( this.saudeFisica.equals("fraca") && this.saudeMental.equals("fraca") ) 
			return "fraca " + this.emoji;
		else 
			return "ok " + this.emoji;
	}
}
