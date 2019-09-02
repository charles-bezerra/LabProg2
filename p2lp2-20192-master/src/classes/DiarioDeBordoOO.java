package classes;

/* Comecando com objetos: como transformar esse codigo procedural
 * em um codigo Orientado a Objetos?
 * 
 * Por: Lívia Sampaio Campos
 * Observacao: Esse codigo é uma prova de conceito,
 * portanto, pode estar incompleto ou com algumas 
 * simplificações.
 */
import java.util.Scanner;

public class DiarioDeBordoOO {
	public static void main(String[] args) {
		//Nao estamos fazendo nenhum tratamento de erros neste codigo!
		if(args.length != 1){
			System.out.println("Uso correto: DiarioDeBordoP2 <tam_diario>");
			System.exit(1);
		}
		int entrada = Integer.parseInt(args[0]);
		DiarioDeBordo diario = new DiarioDeBordo(entrada);
		Scanner sc = new Scanner(System.in);
		final String MENU = "1- adicionar anotacao;\n"+
							"2- pesquisar i-esima anotacao;\n"+
							"3- listar anotacoes;\n"+
							"4- sair";
		final int ANOTAR = 1;
		final int PESQUISAR = 2;
		final int LISTAR = 3;
		final int SAIR = 4;
		
		int op;
		//manipular diario
		do{
			op = leInt(MENU, sc);
			switch(op){
			case ANOTAR:
				anotar(sc, diario);
				break;
			case PESQUISAR:
				pesquisar(sc, diario);
				break;
			case LISTAR:
				listar(diario);
				break;
			case SAIR:
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		}while(diario.temEspaco() && op != SAIR);
		sc.close();	
	}//main

	private static void pesquisar(Scanner sc, DiarioDeBordo diario) {
		int i = leInt("Qual anotacao quer ver: ", sc);
		System.out.println(diario.pesquisar(i));
	}

	private static void anotar(Scanner sc, DiarioDeBordo diario) {
		System.out.println("Data: ");
		String data = sc.nextLine();
		System.out.println("Texto: ");
		String texto = sc.nextLine();
		diario.anotar(texto, data);
	}

	private static void listar(DiarioDeBordo diario) {
		System.out.println(diario.listar());
	}
	private static int leInt(String msg, Scanner input){
		System.out.println(msg);
		int op = input.nextInt();
		input.nextLine();
		return op;
	}


}
