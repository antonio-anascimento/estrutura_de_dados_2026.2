package Atividades.Vetor.teste;

import Atividades.Vetor.Vetor;

import java.util.Arrays;
import java.util.Random;

public class TesteBusca {

    public static void main(String[] args) {

        int[] tamanhos = {1000, 10000, 100000};

        for (int tamanho : tamanhos) {

            System.out.println("\n====================================");
            System.out.println("Vetor com " + tamanho + " elementos");
            System.out.println("====================================");

            Vetor<Integer> vetor = criarVetorOrdenado(tamanho);

            int valorInicio = vetor.get(0);
            int valorMeio = vetor.get(vetor.tamanho() / 2);
            int valorFim = vetor.get(vetor.tamanho() - 1);

            testar(vetor, valorInicio, "Início");
            testar(vetor, valorMeio, "Meio");
            testar(vetor, valorFim, "Fim");
        }
    }

    // Cria o vetor aleatório já ordenado
    public static Vetor<Integer> criarVetorOrdenado(int tamanho) {

        Vetor<Integer> vetor = new Vetor<>(tamanho);
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {

            int valor = random.nextInt(1_000_000);

            int posicao = 0;

            while (posicao < vetor.tamanho()
                    && vetor.get(posicao) < valor) {

                posicao++;
            }

            vetor.inserir(posicao, valor);
        }

        return vetor;
    }

    public static void testar(
            Vetor<Integer> vetor,
            int valor,
            String posicao) {

        System.out.println("\n--- " + posicao + " ---");
        System.out.println("Valor: " + valor);

        buscaLinear(vetor, valor);
        buscaBinaria(vetor, valor);
        arraysBinarySearch(vetor, valor);
    }

    public static void buscaLinear(
            Vetor<Integer> vetor,
            int valor) {

        int comparacoes = 0;
        int resultado = -1;

        long inicio = System.nanoTime();

        for (int i = 0; i < vetor.tamanho(); i++) {

            comparacoes++;

            if (vetor.get(i) == valor) {
                resultado = i;
                break;
            }
        }

        long fim = System.nanoTime();

        System.out.println(
                "Busca Linear  -> posição: " + resultado
                + " | comparações: " + comparacoes
                + " | tempo: " + (fim - inicio) + " ns"
        );
    }

    public static void buscaBinaria(
            Vetor<Integer> vetor,
            int valor) {

        int inicio = 0;
        int fim = vetor.tamanho() - 1;
        int comparacoes = 0;
        int resultado = -1;

        long inicioTempo = System.nanoTime();

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;

            comparacoes++;

            if (vetor.get(meio) == valor) {
                resultado = meio;
                break;
            }

            comparacoes++;

            if (vetor.get(meio) < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        long fimTempo = System.nanoTime();

        System.out.println(
                "Busca Binária -> posição: " + resultado
                + " | comparações: " + comparacoes
                + " | tempo: " + (fimTempo - inicioTempo) + " ns"
        );
    }

    public static void arraysBinarySearch(
            Vetor<Integer> vetor,
            int valor) {

        int[] array = new int[vetor.tamanho()];

        for (int i = 0; i < vetor.tamanho(); i++) {
            array[i] = vetor.get(i);
        }

        long inicio = System.nanoTime();

        int resultado = Arrays.binarySearch(array, valor);

        long fim = System.nanoTime();

        System.out.println(
                "Arrays.binarySearch -> posição: " + resultado
                + " | tempo: " + (fim - inicio) + " ns"
        );
    }
}