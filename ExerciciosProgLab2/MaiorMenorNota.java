/**
* Laboratório de Programação 2 - Lab 1
*
* @author Charles Bezerra de Oliveira Júnior - 119110595
*/

import java.util.Scanner;
import java.util.ArrayList;

public class MaiorMenorNota {
    private static int maiorNota(ArrayList<Integer> notas){
        int maiorNota = 0;
        for(int i = 0; i<notas.size(); i++){
            if(notas.get(i) > maiorNota) maiorNota = notas.get(i);
        }
        return maiorNota;
    }
    private static int menorNota(ArrayList<Integer>  notas){
        int menorNota = notas.get(0);
        for(int i = 0; i<notas.size(); i++){
            if(notas.get(i) < menorNota) menorNota = notas.get(i);
        }
        return menorNota;
    }
    private static int media(ArrayList<Integer> notas){
        int vmedia = 0;
        for(int i = 0; i < notas.size(); i++){
            vmedia += notas.get(i);
        }
        vmedia /= notas.size();
        return vmedia;
    }
    private static int[] acimaAbaixoMedia(ArrayList<Integer> notas){
        int abaixoMedia = 0;
        int acimaMedia = 0;
        for(int i = 0; i<notas.size(); i++){
            if(notas.get(i) >= 700){
                acimaMedia++;
            }    
            else abaixoMedia++;
        }
        int[] valores = {acimaMedia,abaixoMedia};
        return valores;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Nota;
        ArrayList<Integer> Notas = new ArrayList<Integer>();

        int media = 0;

        while(true){
            Nota = sc.nextLine();
            if(Nota.equals("-")) break;
            Notas.add( Integer.parseInt(Nota.split(" ")[1]) );
         }

        System.out.println("maior: " + maiorNota(Notas) );
        System.out.println("menor: " + menorNota(Notas) );
        System.out.println("media: " + media(Notas));
        System.out.println("acima: " + acimaAbaixoMedia(Notas)[0] );
        System.out.println("abaixo: " + acimaAbaixoMedia(Notas)[1]);
    }
}