/**
* Laboratório de Programação 2 - Lab 1
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/

import java.util.Scanner;

public class Calculadora{
    private static String calcular(float n1, float n2, String operacao){
        if(operacao.equals("+")){
            return "RESULTADO: " + (n1+n2);
        }  
        else if(operacao.equals("-")){
            return "RESULTADO: " + (n1-n2);
        } 
        else if( operacao.equals("*") ){
            return "RESULTADO: " + (n1*n2);
        } 
        else{
            if(n2 == 0){
                return "ERRO";
            }else{
                return "RESULTADO: " + (n1/n2);  
            } 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacao = sc.nextLine();
        
        if(operacao.equals("+") | operacao.equals("-") | operacao.equals("*") | operacao.equals("/")){ 
            float n1 = sc.nextFloat();
            float n2 = sc.nextFloat();
            
            System.out.println( calcular(n1,n2,operacao) );
        }
        else System.out.println("ENTRADA INVALIDA");
    }
}