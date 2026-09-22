package lab04;

public class Posicao implements Comparable<Posicao> {

    int linha;
    int coluna;
    Posicao pai;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.pai = null;
    }

    public Posicao(int linha, int coluna, Posicao pai) {
        this.linha = linha;
        this.coluna = coluna;
        this.pai = pai;
    }

    @Override
    public int compareTo(Posicao outra) {
        return 0;
    }
}
