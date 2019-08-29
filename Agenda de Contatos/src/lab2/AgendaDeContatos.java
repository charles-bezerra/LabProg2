package lab2;
import java.util.Scanner;


public class AgendaDeContatos {
	
	public static Scanner sc = new Scanner(System.in);
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
		int posicao = sc.nextInt();
		System.out.println( "\n" + agenda.exibirContato(posicao) + "\n" );
	}
	
	public static int cadastrarContato() {
		System.out.print("Posição: ");
		int posicao = sc.nextInt();
		
		if(posicao < 1 && posicao > 100)
			return 0;
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Sobrenome: ");
		String sobrenome = sc.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		
		agenda.cadastrarContato(posicao, nome, sobrenome, telefone);
		System.out.println("CADASTRO REALIZADO!");
		
		return 1;
	}
	
	public static void main(String[] args) {
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
	}
}


