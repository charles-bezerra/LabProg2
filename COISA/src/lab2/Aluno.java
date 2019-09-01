package lab2;
import java.util.HashMap;

/**

* Representação de um Aluno no sistema.
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/

public class Aluno {
	private String nomeAluno; 
	private HashMap<String, ContaLaboratorio> laboratoriosAluno = new HashMap<String, ContaLaboratorio>();
	private HashMap<String, ContaCantina> cantinasAluno = new HashMap<String, ContaCantina>();
	private HashMap<String, Disciplina> disciplinasAluno = new HashMap<String, Disciplina>();
	private Saude saudeAluno = new Saude();
	
	Aluno(String nomeAluno){
		this.nomeAluno = nomeAluno;
	}
	
	public String getNomeAluno() {
		return this.nomeAluno;
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.cadastraLaboratorio(nomeLaboratorio, 2000);
	}

	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.laboratoriosAluno.put( nomeLaboratorio, new ContaLaboratorio(nomeLaboratorio, cota));
	}
	
	
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		this.laboratoriosAluno.get(nomeLaboratorio).consomeEspaco(mbytes);		
	}
	
	
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		this.laboratoriosAluno.get(nomeLaboratorio).liberaEspaco(mbytes);	
	}
	
	public boolean atingiuCota(String nomeLaboratorio) {
		return this.laboratoriosAluno.get(nomeLaboratorio).atingiuCota();
	}

	
	public String laboratorioToString(String nomeLaboratorio) {
		return this.laboratoriosAluno.get(nomeLaboratorio).toString();
	}


	public void cadastraDisciplina(String nomeDisciplina){
		this.disciplinasAluno.put(nomeDisciplina, new Disciplina(nomeDisciplina));		
	}

	public void cadastraHoras(String nomeDisciplina, int horas) {
		this.disciplinasAluno.get(nomeDisciplina).cadastraHoras(horas);
	}

	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		this.disciplinasAluno.get(nomeDisciplina).cadastraNota(nota, valorNota);
	}

	public boolean aprovado(String nomeDisciplina) {
		return this.disciplinasAluno.get(nomeDisciplina).aprovado();
	}
	
	public String disciplinaToString(String nomeDisciplina) {
		return this.disciplinaToString(nomeDisciplina).toString();
	}

	public void cadastraCantina(String nomeCantina) {
		this.cantinasAluno.put(nomeCantina, new ContaCantina(nomeCantina));
	}
	
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		this.cantinasAluno.get(nomeCantina).cadastraLanche(qtdItens, valorCentavos);
	}

	public void pagarConta(String nomeCantina, int valorCentavos) {
		this.cantinasAluno.get(nomeCantina).pagaConta(valorCentavos);
	}
	
	public int getFaltaPagar(String nomeCantina) {
		return this.cantinasAluno.get(nomeCantina).getFaltaPagar();
	}
	
	public String cantinaToString(String nomeCantina) {
		return this.cantinasAluno.get(nomeCantina).toString();
	}
	
	public void defineSaudeMental(String valor) {
		this.saudeAluno.defineSaudeMental(valor);
	}
	
	public void defineSaudeFisica(String valor) {
		this.saudeAluno.defineSaudeFisica(valor);
	}
	
	public String getStatusGeral() {
		return this.saudeAluno.getStatusGeral();
	}
}
