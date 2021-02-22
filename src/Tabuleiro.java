import java.util.ArrayList;

public class Tabuleiro {

    private final int tamanho;
    private ArrayList<Integer> tabuleiro;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;

        initTabuleiro();
        jogar();
        win();
    }

    public void initTabuleiro(){
        tabuleiro = new ArrayList<>();
        for(int i=0; i < tamanho; i++){
            for(int j=0; j < tamanho; j++){
                tabuleiro.add(0);
            }
        }
    }
    public void jogar (int casa){
        int jogador;
        jogador=1;
        if (jogador==1) jogador=2;
        else jogador=1;
        
    }

    public void printTabuleiro(){
        for(int i = 0; i < this.tamanho; i++){
            for(int j = 0; j < this.tamanho; j++){
                int casa = this.tabuleiro.get(i*this.tamanho+j);
                if(casa == 1) System.out.println("  X  ");   //trocar o jogador
                else if(casa == 2) System.out.println("  O  ");
                else System.out.println("     ");
            }
            System.out.println("\n");
        }
    }
    //para vencer quando a soma das posiçoes seguidas  é o tamanho no caso do X é 3(1*tamanho)
    //para vencer quando a somma das posiçoes seguidas é o tamanho no caso de O é 6(2*tamanho)
    public void win(){
        int sum;
        int sum1;
        sum=0;
        sum1=0;
        for(int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                sum=sum+tabuleiro[i][j];//somar linhas
                sum1=sum1+tabuleiro[j][i];//somar colunas
                if(sum==1 * this.tamanho || sum1==1*this.tamanho) System.out.println("win ");
                else if (sum==2 * this.tamanho || sum1==2*this.tamanho) System.out.println("win ");
            }
        }
    }

    public ArrayList<Integer> getTabuleiro() {
        return tabuleiro;
    }
}
