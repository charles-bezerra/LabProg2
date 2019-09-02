package lab2;
import java.util.ArrayList;


/**
* Representa a conta de laboratório deve ser responsável por manter o registro da 
* quantidade de espaço utilizado,  pelo aluno, em determinado laboratório. 
* Para cada laboratório, seria criado um objeto para controle desse estado (espaço ocupado)
*
* @author Charles Bezerra de Oliveira Júnior  - 119110595
*/
public class ContaCantina {
	/**
	 * Nome da cantina inicializado no construtor
	 * */
	private String nomeCantina;
	
	/**
	 * Valor em centavos que o aluno está devendo na Cantina
	 * */
	private int debitoConta;
	
	/**
	 * Valor quitado pelo o aluno na conta da cantina
	 * */
	private int valorPagoConta = 0;
	
	/**
	 * Quantidade de itens adiquidos pelo aluno
	 * */
	private int qdtItens = 0;
	
	/**
	 * Lista contendo detalhes de compras realizados pelo aluno
	 * */
	private ArrayList<String> detalhesItens = new ArrayList<String>(); 
	
	/**
	* Constrói uma conta na Cantina a partir de seu nome.
	*
	* @param nomeCantina o nome da conta da cantina
	*/
	ContaCantina(String nomeCantina){
		this.nomeCantina = nomeCantina;
	} 
	
	/**
	* Altera os valores dos atributos this.qtdItens, this.debitoConta adicionando os 
	* valores qtdItens e valorCentavos respectivamente
	*
	* @param qtdItens quantidade de itens comprados em um lanche
	* @param valorCentavos valor total em centavos da compŕa 
	*/
	public void cadastraLanche(int qtdItens, int valorCentavos) { 
		this.qdtItens += qtdItens;
		this.debitoConta += valorCentavos;
	}
	
	/**
	 * 
	 * Cadastra e adiciona compras reilizadas pelo aluno, além de adicionar detalhes 
	 * na lista this.detalhesitens
	 * 
	 * @param qtdItens inteiro com o valor da quantidade de itens da compra
	 * @param valorCentavos inteiro com o valor da compra em centavos
	 * @param detalhes string contendo detalhes da compra
	 * */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) { 
		this.detalhesItens.add(detalhes);
		this.cadastraLanche(qtdItens, valorCentavos);
	}

	/**
     *
     * Procedimento que adicionar um valor em centavos ao
     * montante já pago pelo aluno.
     *
     * @param valorCentavos valor em centavos que já foi pago pelo aluno
     * */
	public void pagaConta(int valorCentavos) {
		if( (this.valorPagoConta + valorCentavos) <= this.debitoConta) 
			this.valorPagoConta += valorCentavos;
	}

	/**
	*
     *  Retorna o valor que falta a ser abatido na conta
     *
	* @return valor em centavos que aluno ainda deve a cantina".
	*/	
	public int getFaltaPagar() {
		return this.debitoConta - this.valorPagoConta;
	}
	
	/**
	* Retorna uma lista com os 5 últimos detalhes adicionado
	*
	* @return 5 últimas observações na forma que cada observação fique sepados com \n".
	*/	
	public String listarDetalhes() {
		String valor = "";
		for(int i = this.detalhesItens.size() - 5; i < this.detalhesItens.size();i++) {
			valor += this.detalhesItens.get(i) + "\n"; 
		}
		return valor;
	}
	
	/**
	* Retorna o String contendo o nome da Cantina.
	*
	* @return nomeCantina a String contendo o nomeCantina.
	 *
	*/
	public String getNomeCantina() {
		return this.nomeCantina;
	}
	

	/**
	* Retorna o String que representa a Cantina.
	*
	* @return Representação da cantina com a forma: "<nome da cantina> <quantidade de itens> <debito da conta>".
	*/	
	public String toString() {
		return this.nomeCantina 
				+ " " + this.qdtItens 
				+ " " + this.debitoConta;
	}
}
