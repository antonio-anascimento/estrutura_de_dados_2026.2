package lab05;

public class Processo implements Comparable<Processo> {
    private String nome;
    private int instrucoesRestantes;
    private int tempoChegada;
    private Status status;

    public Processo(String nome, int instrucoes, int tempoChegada) {
        this.nome = nome;
        this.instrucoesRestantes = instrucoes;
        this.tempoChegada = tempoChegada;
        this.status = Status.PRONTO;
    }

    @Override
    public int compareTo(Processo outro) {
        if (this.tempoChegada != outro.tempoChegada) {
            return this.tempoChegada - outro.tempoChegada;
        }
        return this.nome.compareTo(outro.nome);
    }

    public void executar(int qtd) {
        instrucoesRestantes -= qtd;
    }

    public String getNome() {
        return nome;
    }
    public int getInstrucoesRestantes() {
        return instrucoesRestantes;
    }
    public int getTempoChegada() {
        return tempoChegada;
    }
    public void setStatus(Status s) {
        status = s;
    }

    @Override
    public String toString() { return nome; }
}
