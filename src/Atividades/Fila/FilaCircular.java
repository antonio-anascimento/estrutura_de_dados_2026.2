package Atividades.Fila;

public class FilaCircular<T extends Comparable<T>> {

    private T[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaCircular(int capacidade) {
        elementos = (T[]) new Comparable[capacidade];
        tamanho = 0;
        fim = -1;
        inicio = 0;
    }

    public void enfileirar(T elemento) {
        if(tamanho == elementos.length) {
            throw new RuntimeException("cheio");
        }

        fim = (fim + 1) % elementos.length;
        elementos[fim] = elemento;
        tamanho++;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public T desenfileirar() {
        if (isEmpty()) {
            throw new RuntimeException("cheio");
        }

        T valor = elementos[inicio];
        elementos[inicio] = null;

        //NA PRECISO DESLOCAR
        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return valor;
    }

    public void imprimir() {
        System.out.println("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            int indice = (inicio + i) % elementos.length;
            System.out.print(elementos[indice] + " ");
        }
        System.out.println();
    }
}