import java.util.ArrayList;

public class Tabuleiro {

    private final int tamanho;
    private ArrayList<Integer> tabuleiro;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;

        initTabuleiro();
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
        
    }

    public void printTabuleiro(){
        for(int i = 0; i < this.tamanho; i++){
            for(int j = 0; j < this.tamanho; j++){
                int casa = this.tabuleiro.get(i*this.tamanho+j);
                if(casa == 1) System.out.println("  X  ");
                else if(casa == 2) System.out.println("  O  ");
                else System.out.println("     ");
            }
            System.out.println("\n");
        }
    }

    public ArrayList<Integer> getTabuleiro() {
        return tabuleiro;
    }
}
