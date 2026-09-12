package lab03;

import Atividades.ClassesTeste.Contato;
import Atividades.Vetor.Vetor;

public class AgendaHibrida {

    private static final int TAMANHO_ALFABETO = 26;
    private static final int CAPACIDADE_INICIAL_POR_LETRA = 5;

    // Array principal: uma posição para cada letra de A a Z.
    // Cada posição guarda um Vetor com os contatos daquela letra.
    private Vetor<Contato>[] tabela;

    @SuppressWarnings("unchecked")
    public AgendaHibrida() {
        tabela = new Vetor[TAMANHO_ALFABETO];

        for (int i = 0; i < TAMANHO_ALFABETO; i++) {
            tabela[i] = new Vetor<>(CAPACIDADE_INICIAL_POR_LETRA);
        }
    }

    // Recebe o nome do contato e devolve o índice (0 a 25) correspondente
    // à primeira letra.
    private int obterIndice(String nome) {
        char primeiraLetra = Character.toUpperCase(nome.charAt(0));

        if (primeiraLetra < 'A' || primeiraLetra > 'Z') {
            return -1;
        }

        return primeiraLetra - 'A';
    }

    private char letraDoIndice(int indice) {
        return (char) ('A' + indice);
    }

    public void adicionarContato(Contato contato) {
        int indice = obterIndice(contato.getNome());

        if (indice == -1) {
            System.out.println("Nome inválido! O nome deve começar com uma letra de A a Z.");
            return;
        }

        Vetor<Contato> listaDaLetra = tabela[indice];

        // Percorre a lista daquela letra até achar a posição certa
        // para manter tudo em ordem alfabética.
        int posicao = 0;
        while (posicao < listaDaLetra.tamanho()
                && listaDaLetra.get(posicao).getNome().compareToIgnoreCase(contato.getNome()) < 0) {
            posicao++;
        }

        listaDaLetra.inserir(posicao, contato);

        System.out.println("Contato '" + contato.getNome() + "' adicionado com sucesso na letra '"
                + letraDoIndice(indice) + "' (Indice " + indice + ")!");
    }

    public void removerContato(String nome) {
        int indice = obterIndice(nome);

        if (indice == -1) {
            System.out.println("Nome inválido!");
            return;
        }

        Vetor<Contato> listaDaLetra = tabela[indice];

        for (int i = 0; i < listaDaLetra.tamanho(); i++) {
            if (listaDaLetra.get(i).getNome().equalsIgnoreCase(nome)) {
                listaDaLetra.remover(i);
                System.out.println("Contato '" + nome + "' removido com sucesso do Vetor '"
                        + letraDoIndice(indice) + "'!");
                return;
            }
        }

        System.out.println("Contato '" + nome + "' não encontrado na letra '" + letraDoIndice(indice) + "'.");
    }

    public Contato buscarContato(String nome) {
        int indice = obterIndice(nome);

        if (indice == -1) {
            return null;
        }

        Vetor<Contato> listaDaLetra = tabela[indice];

        for (int i = 0; i < listaDaLetra.tamanho(); i++) {
            if (listaDaLetra.get(i).getNome().equalsIgnoreCase(nome)) {
                return listaDaLetra.get(i);
            }
        }

        return null;
    }

    public void atualizarContato(String nome, String novoTelefone) {
        Contato contato = buscarContato(nome);

        if (contato == null) {
            System.out.println("Contato '" + nome + "' não encontrado.");
            return;
        }

        contato.setTelefone(novoTelefone);
        System.out.println("Contato '" + nome + "' atualizado com sucesso!");
    }

    // Usado pelo menu na opção "Buscar", só pra mostrar em qual letra achou.
    public char letraDoNome(String nome) {
        int indice = obterIndice(nome);
        return indice == -1 ? '?' : letraDoIndice(indice);
    }
}