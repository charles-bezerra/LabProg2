/**
* Laboratório de Programação 2 - Lab 1
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/

import java.util.Scanner;
public class PassTrueFalse {
  public static void main(String[] args) {
    Scanner sc =  new Scanner(System.in);
    float x = sc.nextFloat();
    float y = sc.nextFloat();

    float media = (x + y)/2;
    if (media>=7) {
      System.out.println("pass: True!");
    }else{
      System.out.println("pass: False!");            
    }
  }
}
