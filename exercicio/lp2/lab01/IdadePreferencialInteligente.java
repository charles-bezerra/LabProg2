package lp2.lab01;
/**
* Laboratório de Programação 2 - Lab 1
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/


public class IdadePreferencialInteligente {
    public static void main(String[] args) {
        int idade = 20;
        if (idade >= 60) {
           System.out.println("Voce tem " + idade + " anos. Voce pode usar o atendimento especial.");
        }else{
           System.out.println("Voce tem " + idade + " anos. Voce ainda nao pode usar o atendimento especial.");
        }
    }
}
