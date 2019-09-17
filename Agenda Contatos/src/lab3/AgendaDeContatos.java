package lab3;
import java.util.Scanner;

/**
 *
 * Classe main do projeto.
 *
 * @author Charles Bezerra de Oliveira Júnior-119110595 (Lab3)
 **/
public class AgendaDeContatos {

	public static Agenda agenda = new Agenda("Agenda 1");



	public static void exibirMenu() {
		System.out.println("" + 
			"(C)adastrar Contato\n" + 
			"(L)istar Contatos\n" + 
			"(E)xibir Contato\n" + 
			"(S)air\n");
		
		System.out.print("Opção> ");
	}
	


	public static void exibirContato() {
		Scanner sc = new Scanner(System.in);
		int posicao = sc.nextInt();
		
		System.out.println( "\n" + agenda.exibirContato(posicao) + "\n" );
	}


	

	public static int cadastrarContato() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Posição: ");
		int posicao = sc.nextInt();
		
		if(posicao < 1 && posicao > 100)
			return 0;
		
		System.out.print("Nome: ");
		String nome = sc.next();

		System.out.print("Sobrenome: ");
		String sobrenome = sc.next();

		System.out.print("Telefone: ");
		String telefone = sc.next();

		agenda.cadastrarContato(posicao, nome, sobrenome, telefone);
		
		System.out.println("CADASTRO REALIZADO!\n");
		
		return 1;
	}
	



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String resposta;
		
		do {
			exibirMenu();
			resposta = sc.nextLine();
			
			if(resposta.equals("C"))
				cadastrarContato();
			
			else if(resposta.equals("L"))
				System.out.print("\n" + agenda.listarContatos() + "\n");
			
			else if(resposta.equals("E"))
				exibirContato();
			
			else if(!resposta.equals("S"))
				System.out.println("OPÇÃO INVÁLIDA!\n");
		}while(!resposta.equals("S"));
		
		sc.close();
	}
}
