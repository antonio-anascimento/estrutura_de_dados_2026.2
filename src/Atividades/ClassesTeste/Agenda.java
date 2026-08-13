package Atividades.ClassesTeste;

import Atividades.Vetor.Vetor;

public class Agenda {

    private Vetor<Contato> contatos;

    public Agenda(int capacidade) {
        contatos = new Vetor<>(capacidade);
    }

    public void Adicionar(Contato c) {
        contatos.inserir(c);
    }

    public void remover(int indice) {
        contatos.remover(indice);
    }

    public void removerPorNome(String nome) {

        for (int i = 0; i < contatos.tamanho(); i++) {

            if (contatos.get(i).getNome().equals(nome)) {
                contatos.remover(i);
                return;
            }
        }
    }

    public void removerPorTelefone(String telefone) {

        for (int i = 0; i < contatos.tamanho(); i++) {

            if (contatos.get(i).getTelefone().equals(telefone)) {
                contatos.remover(i);
                return;
            }
        }
    }

    public void removerPorContato(Contato contato) {

        for (int i = 0; i < contatos.tamanho(); i++) {

            if (contatos.get(i).equals(contato)) {
                contatos.remover(i);
                return;
            }
        }
    }

    public Contato pesquisar(String valor) {

        if (ehTelefone(valor)) {

            for (int i = 0; i < contatos.tamanho(); i++) {

                if (contatos.get(i).getTelefone().equals(valor)) {
                    return contatos.get(i);
                }
            }

        } else {

            for (int i = 0; i < contatos.tamanho(); i++) {

                if (contatos.get(i).getNome().contains(valor)) {
                    return contatos.get(i);
                }
            }
        }

        return null;
    }

    public Contato pesquisarPorPrefixo(String nome) {

        for (int i = 0; i < contatos.tamanho(); i++) {

            if (contatos.get(i).getNome().startsWith(nome)) {
                return contatos.get(i);
            }
        }

        return null;
    }

    public void inserirEmLista(Contato[] contatosLista) {

        for (Contato c : contatosLista) {
            contatos.inserir(c);
        }
    }

    @Override
    public String toString() {

        if (contatos.tamanho() == 0) {
            return "Agenda vazia.";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < contatos.tamanho(); i++) {
            sb.append(contatos.get(i)).append("\n");
        }

        return sb.toString();
    }

    private boolean ehTelefone(String valor) {
        return valor.matches("[0-9()\\-\\s+]+");
    }
}
