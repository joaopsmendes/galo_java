import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro {

    private final int tamanho;
    private ArrayList<Integer> tabuleiro;
    private int jogador_atual;
    private int n_jogadas;
    private boolean gameFinished;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;
        this.gameFinished = false;

        Random random = new Random();

        initTabuleiro();
        jogador_atual = random.nextBoolean() ? 1 : 2;
        n_jogadas = 0;
    }

    public void initTabuleiro(){
        this.tabuleiro = new ArrayList<>();
        for(int i=0; i < tamanho; i++){
            for(int j=0; j < tamanho; j++){
                this.tabuleiro.add(0);
            }
        }
    }

    /*
    @param casa - indice do quadrado selecionado
    -1 - Jogado invalida
    0 - Continua o jogo
    1/2 - Caso haja vencedor
    3 - Caso haja empate
     */
    public int jogar(int casa){
        // verificar se a jogada é valida
        if(this.tabuleiro.get(casa) != 0){
            System.out.println("Jogada inválida.");
            return -1;
        }

        // efetuar jogada (mudar o tabuleiro)
        this.tabuleiro.set(casa, jogador_atual);

        // Detetar se o jogador venceu
        int vencedor = win();
        if(vencedor != 0){
            printTabuleiro();
            System.out.println("O jogador " + vencedor + " ganhou o jogo");
            this.gameFinished = true;
            return vencedor;
        }

        // mudança jogador
        if(jogador_atual == 1) jogador_atual = 2;
        else jogador_atual = 1;

        this.n_jogadas++;

        // verificar se é empate
        if(tamanho*tamanho == n_jogadas){
            System.out.println("Empate! BURROS");
            this.gameFinished = true;
            return 3;
        }

        return 0;
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void printTabuleiro(){
        int linha = 0, coluna = 0;
        for(int i = 0; i < this.tamanho; i++){
            for(int j = 0; j < this.tamanho; j++){
                int casa = this.tabuleiro.get(i*this.tamanho+j);
                if(casa == 1) System.out.print(coluna < (this.tamanho-1) ? ANSI_RED+"  X  "+ANSI_RESET+ANSI_BLUE+"|"+ANSI_RESET : ANSI_RED+"  X  "+ANSI_RESET);   //trocar o jogador
                else if(casa == 2) System.out.print(coluna < (this.tamanho-1) ? ANSI_GREEN+"  O  "+ANSI_RESET +ANSI_BLUE+"|" +ANSI_RESET: ANSI_GREEN+"  O  "+ANSI_RESET);
                else System.out.print(coluna < (this.tamanho-1) ? "     "+ANSI_BLUE+"|"+ANSI_RESET : "     ");
                coluna++;
            }
            coluna = 0;
            if(linha < this.tamanho-1){
                System.out.print(ANSI_BLUE+"\n-----------------\n"+ANSI_RESET);
            }else{
                System.out.print("\n");
            }
            linha++;
        }
    }

    /*
    0 - nng ganhou
    1 - jogador 1 ganhou
    2 - jogador 2 ganhou
     */
    public int win(){
        if(this.tabuleiro.get(0)==this.tabuleiro.get(1) && this.tabuleiro.get(1)==this.tabuleiro.get(2)) return this.tabuleiro.get(0);
        else if(this.tabuleiro.get(3)==this.tabuleiro.get(4) && this.tabuleiro.get(4)==this.tabuleiro.get(5)) return this.tabuleiro.get(3);
        else if(this.tabuleiro.get(6)==this.tabuleiro.get(7) && this.tabuleiro.get(7)==this.tabuleiro.get(8)) return this.tabuleiro.get(6);
        else if(this.tabuleiro.get(0)==this.tabuleiro.get(3) && this.tabuleiro.get(3)==this.tabuleiro.get(6)) return this.tabuleiro.get(0);
        else if(this.tabuleiro.get(1)==this.tabuleiro.get(4) && this.tabuleiro.get(4)==this.tabuleiro.get(7)) return this.tabuleiro.get(1);
        else if(this.tabuleiro.get(2)==this.tabuleiro.get(5) && this.tabuleiro.get(5)==this.tabuleiro.get(8)) return this.tabuleiro.get(2);
        else if(this.tabuleiro.get(0)==this.tabuleiro.get(4) && this.tabuleiro.get(4)==this.tabuleiro.get(8)) return this.tabuleiro.get(0);
        else if(this.tabuleiro.get(2)==this.tabuleiro.get(4) && this.tabuleiro.get(4)==this.tabuleiro.get(6)) return this.tabuleiro.get(2);
        return 0;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public int getTamanho() {
        return tamanho;
    }
}
