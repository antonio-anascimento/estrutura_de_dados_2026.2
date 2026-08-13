package Atividades.ClassesTeste;

public class App {

    public static void main(String[] args) {

        Agenda agenda = new Agenda(10);

        Contato c1 = new Contato("João", "(11)99999-1111");
        Contato c2 = new Contato("Maria", "(11)98888-2222", "maria@email.com");
        Contato c3 = new Contato("José", "(21)97777-3333");
        Contato c4 = new Contato("Ana", "(31)96666-4444", "ana@email.com");

        agenda.Adicionar(c1);
        agenda.Adicionar(c2);
        agenda.Adicionar(c3);

        System.out.println("=== Agenda Inicial ===");
        System.out.println(agenda);

        System.out.println("=== Pesquisa por nome ===");
        System.out.println(agenda.pesquisar("Maria"));

        System.out.println("\n=== Pesquisa por telefone ===");
        System.out.println(agenda.pesquisar("(21)97777-3333"));

        System.out.println("\n=== Pesquisa por prefixo ===");
        System.out.println(agenda.pesquisarPorPrefixo("Jo"));

        agenda.removerPorNome("Maria");
        System.out.println("\n=== Após remover Maria ===");
        System.out.println(agenda);

        agenda.removerPorTelefone("(21)97777-3333");
        System.out.println("\n=== Após remover José ===");
        System.out.println(agenda);

        agenda.Adicionar(c2);
        agenda.Adicionar(c3);

        Contato[] novos = {
                c4,
                new Contato("Carlos", "(41)95555-5555", "carlos@email.com"),
                new Contato("Beatriz", "(51)94444-6666"),
                new Contato("Pedro", "(61)93333-7777", "pedro@email.com")
        };

        agenda.inserirEmLista(novos);

        System.out.println("\n=== Após inserir uma lista ===");
        System.out.println(agenda);

        agenda.removerPorContato(c1);

        System.out.println("\n=== Após remover João ===");
        System.out.println(agenda);

        System.out.println("=== Contato com e-mail ===");
        System.out.println(c2);

        System.out.println("\n=== Contato sem e-mail ===");
        System.out.println(c3);
    }
}