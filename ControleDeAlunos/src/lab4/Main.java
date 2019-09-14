package lab4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static Map<String, Aluno> alunos;
    private static Map<String, GrupoEstudo> gruposEstudo;


    public static void exibirMenu(){
        System.out.println("(C)adastrar Aluno\n" +
                "(E)xibir Aluno\n" +
                "(N)ovo Grupo\n" +
                "(A)locar Aluno no Grupo e Imprimir Grupos\n" +
                "(R)egistrar Aluno que Respondeu\n" +
                "(I)mprimir Alunos que Responderam\n" +
                "(O)ra, vamos fechar o programa!\n" +
                "\n" +
                "Opção>\n");
    }

    public static void criarObjetos(){
        sc = new Scanner(System.in);

    }

    public static void main(String[] args){
        criarObjetos();
        exibirMenu();

        String op = sc.next();
        while (!op.equals("O")){
            if(op.equals("E")) ;
            else if(op.equals("N")) ;
            else if(op.equals("A")) ;
            else if(op.equals("R")) ;
            else if(op.equals("I")) ;
            else if(op.equals("O")) ;
            else System.out.println("OPÇÃO INVÁLIDA!");

            exibirMenu();
            op = sc.next();
        }

    }
}
