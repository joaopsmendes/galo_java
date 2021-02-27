import java.util.Scanner;

public class Galo {

    // TODO Bot

    public static void main(String args[]){
        Tabuleiro tabuleiro = new Tabuleiro(3);
        while(!tabuleiro.isGameFinished()){
            tabuleiro.printTabuleiro();
            Scanner scanner = new Scanner(System.in);
            String input;
            System.out.println("Joga!");
            input = scanner.nextLine();
            int x, y;
            try {
                x = input.toLowerCase().charAt(0) - 97;
                y = Integer.parseInt(input.substring(1))-1;
                if((0 <= x && x <= (tabuleiro.getTamanho() - 1)) && (0 <= y && y <= (tabuleiro.getTamanho() - 1))){
                    tabuleiro.jogar(x*tabuleiro.getTamanho()+y);
                }else{
                    System.out.println("Posição invalida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Posição invalida.");
            }
        }
    }
}
