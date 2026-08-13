package Atividades.Vetor.teste;

import Atividades.ClassesTeste.Agenda;
import Atividades.ClassesTeste.Contato;

public class ex12 {

    public static void main(String[] args) {

        // Criando uma agenda com capacidade inicial 2
        Agenda agenda = new Agenda(2);

        // Criando contatos
        Contato c1 = new Contato("João", "99999-1111");
        Contato c2 = new Contato("Maria", "99999-2222");
        Contato c3 = new Contato("Pedro", "99999-3333");

        // Adicionando contatos
        agenda.Adicionar(c1);
        agenda.Adicionar(c2);
        agenda.Adicionar(c3);

        System.out.println("=== CONTATOS DA AGENDA ===");
        System.out.println(agenda);

        // Pesquisar por nome
        System.out.println("=== PESQUISA POR NOME ===");
        System.out.println(agenda.pesquisar("Maria"));

        // Pesquisar por telefone
        System.out.println("=== PESQUISA POR TELEFONE ===");
        System.out.println(agenda.pesquisar("99999-3333"));

        // Pesquisar por prefixo
        System.out.println("=== PESQUISA POR PREFIXO ===");
        System.out.println(agenda.pesquisarPorPrefixo("Jo"));

        // Remover pelo nome
        agenda.removerPorNome("Maria");

        System.out.println("=== APÓS REMOVER MARIA ===");
        System.out.println(agenda);

        // Remover pelo telefone
        agenda.removerPorTelefone("99999-3333");

        System.out.println("=== APÓS REMOVER PEDRO ===");
        System.out.println(agenda);

        // Adicionando novamente
        Contato c4 = new Contato("Ana", "99999-4444");
        agenda.Adicionar(c4);

        System.out.println("=== APÓS ADICIONAR ANA ===");
        System.out.println(agenda);

        // Remover pelo objeto Contato
        agenda.removerPorContato(c1);

        System.out.println("=== APÓS REMOVER JOÃO ===");
        System.out.println(agenda);
    }
}
