package lab4;

import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static ControleDeAluno controleDeAluno;

    public static void exibirMenu(){
        System.out.print("(C)adastrar Aluno\n" +
                "(E)xibir Aluno\n" +
                "(N)ovo Grupo\n" +
                "(A)locar Aluno no Grupo e Imprimir Grupos\n" +
                "(R)egistrar Aluno que Respondeu\n" +
                "(I)mprimir Alunos que Responderam\n" +
                "(O)ra, vamos fechar o programa!\n" +
                "\n" +
                "Opção> ");
    }

    public static void main(String[] args){
        controleDeAluno = new ControleDeAluno();
        sc = new Scanner(System.in);

        exibirMenu();
        String op = sc.nextLine();

        String matricula, nome, curso, grupo;

        while (!op.equals("O")){
            if(op.equals("C")){
                System.out.print("Maticula: "); matricula = sc.nextLine();
                System.out.print("Nome: "); nome = sc.nextLine();
                System.out.print("Curso: "); curso = sc.nextLine();
                System.out.println(controleDeAluno.cadastrarAluno(matricula,nome,curso) ? "CADASTRO REALIZADO! \n" : "MATRÍCULA JÁ CADASTRADA! \n");
            }

            else if(op.equals("E")){
                System.out.print("Matrícula: "); matricula = sc.nextLine();
                System.out.println("\n" + controleDeAluno.exibirAluno(matricula) );
            }

            else if(op.equals("N")){
                System.out.print("Grupo: "); grupo = sc.nextLine();
                System.out.println( controleDeAluno.cadastrarGrupoDeEstudo(grupo) ? "CADASTRO REALIZADO! \n" : "GRUPO JÁ CADASTRADO! \n" );
            }

            else if(op.equals("A")) {
                System.out.print("(A)locar Aluno ou (I)mprimir Grupo? "); op = sc.nextLine();
                if (op.equals("A")) {
                    System.out.print("Matricula: "); matricula = sc.nextLine();
                    System.out.print("Grupo: "); grupo = sc.nextLine();
                    System.out.println( controleDeAluno.alocarAlunoEmGrupo(matricula, grupo) );
                }
                else if(op.equals("I")){
                    System.out.print("Grupo: "); grupo = sc.nextLine();
                    System.out.println( controleDeAluno.listarGrupo(grupo) );
                }
            }

            else if(op.equals("R")){
                System.out.print("Aluno: "); matricula = sc.nextLine();
                System.out.println( controleDeAluno.cadastrarRespostaDeAlunos(matricula) );
            }

            else if(op.equals("I"))
                System.out.println( controleDeAluno.listarRespostasDeAlunos() );

            else if(op.equals("O"))
                System.exit(0);

            else
                System.out.println("OPÇÃO INVÁLIDA!" + "\n");

            exibirMenu();
            op = sc.nextLine();
        }

        System.out.close();
    }
}