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

    public static void alocarAlunoImprimirGrupo(){
        System.out.print("(A)locar Aluno ou (I)mprimir Grupo? "); op = sc.nextLine();
        switch(op) {
            case "A":{
                System.out.print("Matricula: "); matricula = sc.nextLine();
                System.out.print("Grupo: "); grupo = sc.nextLine();

                MensagensAlocarAluno msg = controleDeAluno.alocarAlunoEmGrupo(matricula, grupo);

                switch (msg){
                    case AlunoNaoEncontrado:{ System.out.println("Aluno não cadastrado." + LS); break; }
                    case GrupoNaoEncontrado:{ System.out.println("Grupo não cadastrado." + LS); break; }
                    case CadastradoComSucesso:{ System.out.println("ALUNO ALOCADO" + LS); break; }
                }
                break;
            }
            case "I":{
                System.out.print("Grupo: "); grupo = sc.nextLine();
                listagem = controleDeAluno.listarGrupo(grupo);
                System.out.println( listagem == null ? "Grupo não cadastrado." + LS : listagem );
                break;
            }
        }
    }


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
