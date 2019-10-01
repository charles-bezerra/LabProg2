package lab4;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static ControleDeAluno controleDeAluno;
    private static String listagem, matricula, nome, curso, grupo, op;
    private static final String LS = System.lineSeparator();

    public static void exibirMenu(){
        System.out.print("(C)adastrar Aluno" + LS +
                "(E)xibir Aluno" + LS +
                "(N)ovo Grupo" + LS +
                "(A)locar Aluno no Grupo e Imprimir Grupos" + LS +
                "(R)egistrar Aluno que Respondeu" + LS +
                "(I)mprimir Alunos que Responderam" + LS +
                "(O)ra, vamos fechar o programa!" + LS +
                "" + LS +
                "Opção> ");
    }    
    
    public static enum MensagemAlocarAluno{
    	NullMatricula(1), NullGrupo(2), Sucesso(3);

    	private int mensagem;

    	MensagemAlocarAluno(int mensagem){ 
    		this.mensagem = mensagem; 
    	}
    	
    	public MensagemAlocarAluno getMensagem() {
    		switch(mensagem) {
    			case 1:{ return NullMatricula; }
    			case 2:{ return NullGrupo; }
    			default: return Sucesso;
    		} 
    	}
    	
    }
    
    public static void alocarAlunoImprimirGrupo(){
<<<<<<< HEAD
        System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
        op = sc.nextLine();   
=======
        System.out.print("(A)locar Aluno ou (I)mprimir Grupo? "); op = sc.nextLine();
>>>>>>> d2675f048eb3a935a1bee6e9e2a93d4e10f2316b
        switch(op) {
            case "A":{
                System.out.print("Matricula: "); matricula = sc.nextLine();
                System.out.print("Grupo: "); grupo = sc.nextLine();

<<<<<<< HEAD
                System.out.print("Grupo: ");
                grupo = sc.nextLine();                
                
                MensagemAlocarAluno msg = Main.MensagemAlocarAluno( controleDeAluno.alocarAlunoEmGrupo(matricula, grupo) ).getMensagem();
                
                switch(msg) {
                	case MensagemAlocarAluno.NullMatricula:{
                		
                	}
                }
               
                System.out.println();
=======
                MensagensAlocarAluno msg = controleDeAluno.alocarAlunoEmGrupo(matricula, grupo);

                switch (msg){
                    case AlunoNaoEncontrado:{ System.out.println("Aluno não cadastrado." + LS); break; }
                    case GrupoNaoEncontrado:{ System.out.println("Grupo não cadastrado." + LS); break; }
                    case CadastradoComSucesso:{ System.out.println("ALUNO ALOCADO" + LS); break; }
                }
                break;
>>>>>>> d2675f048eb3a935a1bee6e9e2a93d4e10f2316b
            }
            case "I":{
                System.out.print("Grupo: "); grupo = sc.nextLine();
                listagem = controleDeAluno.listarGrupo(grupo);
                System.out.println( listagem == null ? "Grupo não cadastrado." + LS : listagem );
                break;
            }
        }
    }

<<<<<<< HEAD

	public static void main(String[] args){
        controleDeAluno = new ControleDeAluno();
        sc = new Scanner(System.in);

        exibirMenu();
        op = sc.nextLine();


        while (true){
            switch (op){
                case "C": {
                    System.out.print("Maticula: ");
                    matricula = sc.nextLine();

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Curso: ");
                    curso = sc.nextLine();

                    System.out.println( controleDeAluno.cadastrarAluno(matricula,nome,curso) ? "CADASTRO REALIZADO!" + LS : "MATRÍCULA JÁ CADASTRADA!" + LS);
                }

                case "E": {
                    System.out.print("Matrícula: ");
                    matricula = sc.nextLine();
=======
>>>>>>> d2675f048eb3a935a1bee6e9e2a93d4e10f2316b

    public static void cadastrarAluno(){
        System.out.print("Maticula: "); matricula = sc.nextLine();
        System.out.print("Nome: "); nome = sc.nextLine();
        System.out.print("Curso: "); curso = sc.nextLine();
        System.out.println( controleDeAluno.cadastrarAluno(matricula, nome, curso) ? "CADASTRO REALIZADO!" + LS : "MATRÍCULA JÁ CADASTRADA!" + LS);
    }


    public static void exibirAluno(){
        System.out.print("Matrícula: "); matricula = sc.nextLine();
        listagem = controleDeAluno.exibirAluno(matricula);
        System.out.println(LS + (listagem != null ? listagem + LS: "Aluno não cadastrado." + LS) );
    }

    public static void novoGrupo(){
        System.out.print("Grupo: ");
        grupo = sc.nextLine();
        System.out.println( controleDeAluno.cadastrarGrupoDeEstudo(grupo) ? "CADASTRO REALIZADO!" + LS : "GRUPO JÁ CADASTRADO!" + LS );
    }

    public static void registrarRespostaAluno(){
        System.out.print("Aluno: ");
        matricula = sc.nextLine();
        System.out.println( controleDeAluno.cadastrarRespostaDeAlunos(matricula) ? "ALUNO REGISTRADO!" + LS : "Aluno não cadastrado." + LS );
    }

    public static void imprimirAlunoQueResponderam() {
        listagem = controleDeAluno.listarRespostasDeAlunos();
        System.out.println( listagem + LS != null ? listagem : "ALUNO REGISTRADO!" + LS );
    }

    public static void iniciarObjetos(){
        controleDeAluno = new ControleDeAluno();
        sc = new Scanner(System.in);
        listagem = new String("");
        matricula = new String("");
        nome = new String("");
        curso = new String("");
        grupo = new String("");
        op = new String("");
    }

    public static void main(String[] args){
        iniciarObjetos();
        exibirMenu(); op = sc.nextLine();

        while (true){
            switch (op){
                case "C":{ cadastrarAluno(); break;}
                case "E":{ exibirAluno(); break; }
                case "N":{ novoGrupo(); break; }
                case "A":{ alocarAlunoImprimirGrupo(); break; }
                case "R":{ registrarRespostaAluno(); break; }
                case "I":{ imprimirAlunoQueResponderam(); break; }
                case "O":{ System.exit(0); }
                default:{ System.out.println("OPÇÃO INVÁLIDA!" + LS); break; }
            }
            exibirMenu(); op = sc.nextLine();
        }
    }
}
