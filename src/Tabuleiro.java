import java.util.ArrayList;

public class Tabuleiro {

    private final int tamanho;
    private ArrayList<Integer> tabuleiro;
    private int jogador_atual;
    private int n_jogadas;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;

        initTabuleiro();
        jogador_atual = 1;
        n_jogadas = 0;
    }

    public void initTabuleiro(){
        this.tabuleiro = new ArrayList<>();
        for(int i=0; i < tamanho; i++){
            for(int j=0; j < tamanho; j++){
                this.tabuleiro.add(1);
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
            System.out.println("O jogador " + vencedor + " ganhou o jogo");
            return vencedor;
        }

        // mudança jogador
        if(jogador_atual == 1) jogador_atual = 2;
        else jogador_atual = 1;

        // verificar se é empate
        if(tamanho*tamanho == n_jogadas) return 3;

        this.n_jogadas++;
        return 0;
    }

    public void printTabuleiro(){
        // TODO linhas do tabuleiro
        for(int i = 0; i < this.tamanho; i++){
            for(int j = 0; j < this.tamanho; j++){
                int casa = this.tabuleiro.get(i*this.tamanho+j);
                if(casa == 1) System.out.print("  X  ");   //trocar o jogador
                else if(casa == 2) System.out.print("  O  ");
                else System.out.print("     ");
            }
            System.out.print("\n");
        }
    }

    /*
    0 - nng ganhou
    1 - jogador 1 ganhou
    2 - jogador 2 ganhou
     */
    public int win(){
        // TODO detetar vitoria
        return 0;
    }
}
