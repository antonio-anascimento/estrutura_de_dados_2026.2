package Atividades.Vetor;

public class Vetor <T>{

    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade){
        elementos = (T[]) new Object[quantidade];
        tamanho = 0;
    }

    public void inserir(T elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public void inserir(int indice, T elemento) {
        if (tamanho >= elementos.length) {
            System.out.println("Vetor cheio!");
            return;
        }

        if (indice < 0 || indice > tamanho) {
            System.out.println("Posição inválida");
            return;
        }

        for (int i = tamanho; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }

        elementos[indice] = elemento;
        tamanho++;
    }


    @SuppressWarnings("unchecked")
    private void expandir() {
        T[] novo =(T[]) new Object[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    @SuppressWarnings("unchecked")
    private void reduzir() {
        if (tamanho <= elementos.length/4) {
            T[] novo = (T[]) new Object[elementos.length/2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[i];
            }
            elementos = novo;
        }
    }

    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Indice Inválido");
            return;
        }
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho-1] = null;
        tamanho--;
        reduzir();
    }


    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < tamanho ; i++) {
            System.out.print(elementos[i]);
            if (i < tamanho -1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public T get(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return null;
        }

        return elementos[indice];
    }

    public static int buscaLinear(int[] vetor, int valor) {
        int comparacoes = 0;

        for (int i = 0; i < vetor.length; i++) {
            comparacoes++;

            if (vetor[i] == valor) {
                System.out.println("Comparações: " + comparacoes);
                return i;
            }
        }

        System.out.println("Comparações: " + comparacoes);
        return -1;
    }

    public static int buscaBinaria(int[] vetor, int valor) {
        int inicio = 0;
        int fim = vetor.length - 1;
        int comparacoes = 0;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            comparacoes++;

            if (vetor[meio] == valor) {
                System.out.println("Comparações: " + comparacoes);
                return meio;
            }

            comparacoes++;

            if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        System.out.println("Comparações: " + comparacoes);
        return -1;
    }



    public int tamanho() {
        return tamanho;
    }
}