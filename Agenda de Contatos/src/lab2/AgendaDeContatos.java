package lab2;
import java.util.Scanner;

public class AgendaDeContatos {
	public static void menu() {
		System.out.println("" + 
			"(C)adastrar Contato\n" + 
			"(L)istar Contatos\n" + 
			"(E)xibir Contato\n" + 
			"(S)air\n");
		
		System.out.print("Opção> ");
	}
	
	
	public static void main(String[] args) {
/*		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda("Agenda 1");
		
		String resposta = "";
		
		do{
			menu();
			resposta = sc.nextLine();
			
			if(resposta.equals("C"));
			
		}while(!resposta.equals("S"));
		*/
		
		Agenda a = new Agenda();
		System.out.println(a.verificaSaoIguais());
	}
}


