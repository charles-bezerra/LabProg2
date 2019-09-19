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
        System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
        op = sc.nextLine();

        switch(op) {
            case "A":{
                System.out.print("Matricula: ");
                matricula = sc.nextLine();

                System.out.print("Grupo: ");
                grupo = sc.nextLine();

                System.out.println(controleDeAluno.alocarAlunoEmGrupo(matricula, grupo));
            }
            case "I":{
                System.out.print("Grupo: ");
                grupo = sc.nextLine();

                listagem = controleDeAluno.listarGrupo(grupo);
                System.out.println( listagem != null ? "Grupo não cadastrado." + LS : listagem );
            }
        }
    }

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

                    listagem = controleDeAluno.exibirAluno(matricula);
                    System.out.println(LS + (listagem != null ? listagem : "Aluno não cadastrado." + LS) );
                }

                case "N": {
                    System.out.print("Grupo: ");
                    grupo = sc.nextLine();

                    System.out.println( controleDeAluno.cadastrarGrupoDeEstudo(grupo) ? "CADASTRO REALIZADO!" + LS : "GRUPO JÁ CADASTRADO!" + LS );
                }

                case "A":{
                    alocarAlunoImprimirGrupo();
                }

                case "R":{
                    System.out.print("Aluno: ");
                    matricula = sc.nextLine();

                    System.out.println( controleDeAluno.cadastrarRespostaDeAlunos(matricula) ? "ALUNO REGISTRADO!" + LS : "Aluno não cadastrado." + LS );
                }

                case "I": {
                    listagem = controleDeAluno.listarRespostasDeAlunos();
                    System.out.println( listagem != null ? listagem : "ALUNO REGISTRADO!" + LS );
                }

                case "O": { break; }

                default: System.out.println("OPÇÃO INVÁLIDA!" + LS);
            }

            exibirMenu();
            op = sc.nextLine();
        }
    }
}
