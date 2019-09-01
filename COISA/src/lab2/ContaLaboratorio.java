package lab2;

/**

* Representação de uma conta de laboratório deve ser responsável
*  por manter o registro da quantidade de espaço utilizado,  pelo aluno, 
*  em determinado laboratório. 
*
* @author Charles Bezerra de Oliveira Júnior  - 119110595
*/


public class ContaLaboratorio {
	/**
	 * Nome do Laboratório inicializado no construtor 
	 * */
	private String nomeLaboratorio;
	/**
	 * Valor da quantidade de espaço em MegaBytes ocupado no laboratório de determinada conta 
	 * */
	private int espacoOcupado;
	/**
	 * Valor da quantidade máxima de espaço que a conta pode utilizar
	 * */
	private int cota;
	
	/**
	* Constrói uma conta de laboratório a partir de seu nome.
	* Toda conta inicia com espaço ocupado com 0 e a cota como 2000 mb.
	*
	* @param nome o nome da conta do laboratório
	*/
	ContaLaboratorio(String nome){
		this.nomeLaboratorio = nome;
		this.espacoOcupado = 0;
		this.cota = 2000;
	}
	
	/**
	* Constrói uma conta de laboratório a partir de seu nome e uma cota.
	* Toda conta inicia com espaço ocupado com 0.
	*
	* @param nome o nome da conta do laboratório
	* @param cota a cota da conta do laboratório
	*/	
	ContaLaboratorio(String nome, int cota){
		this.nomeLaboratorio = nome;
		this.espacoOcupado = 0;
		this.cota = cota;
	}

	
	/**
	* Altera o valor do atributo espacoOcupado adicionando o valor de espaco
	*
	* @param espaco o valor que irá somar a o valor de espacoOcupado 
	*/
	public void consomeEspaco(int espaco) {
		this.espacoOcupado += espaco;
	}
	

	/**
	* Altera o valor do atributo espacoOcupado decrementando com o valor de espaco
	*
	* @param espaco o valor que irá decrementar o valor de espacoOcupado 
	*/
	public void liberaEspaco(int espaco) {
		this.espacoOcupado -= espaco;
	}
	
	
	/**
	* Retorna o boolean que verifica se a cota foi atiginda.
	* podendo retorna true ou false
	*
	* @return a true ou false.
	*/
	public boolean atingiuCota() {
		if(this.espacoOcupado >= this.cota) return true;
		else return false;
	}
	
	
	/**
	* Retorna o String contendo o nome do Laboratorio.
	*
	* @return a String contendo o nomeLaboratorio.
	*/
	public String getNomeLaboratorio() {
		return this.nomeLaboratorio;
	}
	
	/**
	
	* Retorna a String que representa a Conta de Laboratório. A representação segue o 
	* formato “Nome da conta Espaço Ocupado/Cota ”.
	*
	* @return a representação em String de uma Conta de Laboratório.
	*/	
	public String toString() {
		return 
			this.nomeLaboratorio 
			+ " " + this.espacoOcupado 
			+ "/" + this.cota;
	}
	
}
