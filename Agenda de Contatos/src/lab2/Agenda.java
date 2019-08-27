package lab2;

//public class Agenda {
//	private int indexAtual;
//	private String nomeAgenda;
//	private Contato[] contatos;
//	
//	Agenda(String nomeAgenda){
//		this.contatos = new Contato[100];
//		this.nomeAgenda = nomeAgenda;
//		this.indexAtual = 0;
//	}
//	
//	public void listarContatos() {
//		for(Contato contato: this.contatos) {
//			System.out.println("");
//		}
//	}
//	
//	public void cadastrarContato(String nome, String sobrenome, String telefone) {
//		contatos[indexAtual] = new Contato(nome,sobrenome,telefone);
//		this.indexAtual++;
//	}
//}

public class Agenda {

    private Contato contato1;

    private Contato contato2;

 

    public Agenda() {

        contato1 = new Contato("Matheus", "Gaudencio", "9999-9999");

        contato2 = new Contato("Livia", "Sampaio", "8888-8888");

    }

    public boolean verificaSaoIguais() {

        return contato1.equals(contato2);

    }

}