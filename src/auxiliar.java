
import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class auxiliar {
    public static void jogar (){
        int tabuleiro[][] ={{1,2,3},{4,5,6},{7,8,9}}; //new int [3][3]

        ler(tabuleiro);
    
    }
    public static void ler(int x[][]){
        for(int i=0; i<x.length; i++){
            for(int j=0;j <x[i].length; j++){
               // x[i][j]="0";
                System.out.print(x[i][j]+ "\t");//imprimir uma linha
               // System.out.println(i + "," + j + "\t" + tabuleiro[i][j]);
            }
            System.out.println("\n");   //imprimir todas as linhas
        }
    }
//validar uma jogada
    

//assocair X ou O ao jogador


// jogadas de acordo com a posiçao e a jogada


// casos para ganhar


}

