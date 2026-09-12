package lab03;

import Atividades.ClassesTeste.Contato;

import java.util.Scanner;

public class TesteAgendaHibrida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaHibrida agenda = new AgendaHibrida();
        int opcao;

        do {
            System.out.println("\n--- MENU DA AGENDA DE CONTATOS ---");
            System.out.println("1 -  Adicionar Contato (Ordenado)");
            System.out.println("2 -  Remover Contato");
            System.out.println("3 -  Buscar Contato");
            System.out.println("4 -  Atualizar Contato");
            System.out.println("5 -  Sair");
            System.out.print("\nEscolha uma opcao: ");
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nomeNovo = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefoneNovo = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nomeNovo, telefoneNovo));
                    break;

                case 2:
                    System.out.print("Digite o nome do contato a remover: ");
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContato(nomeRemover);
                    break;

                case 3:
                    System.out.print("Digite o nome do contato a buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    Contato encontrado = agenda.buscarContato(nomeBuscar);

                    if (encontrado != null) {
                        char letra = agenda.letraDoNome(nomeBuscar);
                        System.out.println("Contato encontrado no Vetor '" + letra + "': " + encontrado);
                    } else {
                        System.out.println("Contato '" + nomeBuscar + "' não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do contato a atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String telefoneAtualizado = scanner.nextLine();
                    agenda.atualizarContato(nomeAtualizar, telefoneAtualizado);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma opção de 1 a 5.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    private static int lerOpcao(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}