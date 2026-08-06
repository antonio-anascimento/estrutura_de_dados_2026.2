package Atividades.Contatos;

public class Agenda {

    private Contato[] contatos;
    private int tamanho;

    public Agenda(int capacidade) {
        contatos = new Contato[capacidade];
        this.tamanho = 0;
    }

    public void Adicionar(Contato c) {
        if (tamanho < contatos.length) {
            contatos[tamanho] = c;
            tamanho++;
        } else {
            System.out.println("Vetor cheio!");
        }
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Posição inválida");
            return;
        }

        for (int i = indice; i < tamanho - 1; i++) {
            contatos[i] = contatos[i + 1];
        }

        contatos[tamanho - 1] = null;
        tamanho--;
    }

    public void removerPorNome(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nome)) {
                remover(i);
                return;
            }
        }
    }

    public void removerPorTelefone(String telefone) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getTelefone().equals(telefone)) {
                remover(i);
                return;
            }
        }
    }

    public void removerPorContato(Contato contato) {
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].equals(contato)) {
                remover(i);
                return;
            }
        }
    }

    public Contato pesquisar(String valor) {

        if (ehTelefone(valor)) {

            for (int i = 0; i < tamanho; i++) {
                if (contatos[i].getTelefone().equals(valor)) {
                    return contatos[i];
                }
            }

        } else {

            for (int i = 0; i < tamanho; i++) {
                if (contatos[i].getNome().contains(valor)) {
                    return contatos[i];
                }
            }

        }

        return null;
    }

    public Contato pesquisarPorPrefixo(String nome) {

        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().startsWith(nome)) {
                return contatos[i];
            }
        }

        return null;
    }

    public void inserirEmLista(Contato[] contatosLista) {

        for (Contato c : contatosLista) {

            if (tamanho >= contatos.length) {
                System.out.println("Não foi possível inserir todos os contatos. Vetor cheio!");
                break;
            }

            Adicionar(c);
        }
    }

    @Override
    public String toString() {

        if (tamanho == 0) {
            return "Agenda vazia.";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            sb.append(contatos[i]).append("\n");
        }

        return sb.toString();
    }

    private boolean ehTelefone(String valor) {
        return valor.matches("[0-9()\\-\\s+]+");
    }
}