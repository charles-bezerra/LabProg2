/**
* Laboratório de Programação 2 - Lab 1
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/

import java.util.Scanner;

public class FuncaoMonotona{
    public static void monotona(int v1,int v2,int v3,int v4){
        if(v1>v2 && v2>v3 && v3>v4){
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        }
        else if(v1<v2 && v2<v3 && v3<v4){
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        }
        else{
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int v3 = sc.nextInt();
        int v4 = sc.nextInt();
		
        monotona(v1,v2,v3,v4);
    }
}