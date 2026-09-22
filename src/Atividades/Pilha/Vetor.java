public class Vetor<T  extends Comparable<T>> {

    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int quantidade){
        elementos = (T[])  new Comparable[quantidade];
        tamanho = 0;
    }

    public T ler(int indice) {
        return elementos[indice];
    }

    public void inserir(T elemento) {
        if (tamanho == elementos.length) {
            expandir();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }

    @SuppressWarnings("unchecked")
    private void expandir() {
        T[] novo = (T[]) new Comparable[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    @SuppressWarnings("unchecked")
    private void reduzir() {
        if (tamanho <= elementos.length/4) {
            T[] novo = (T[]) new Comparable[elementos.length/2];
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




        for (int i = indice; i < tamanho; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho-1] = null;
        tamanho--;
        reduzir();
    }

    public void inserir(int indice, T elemento) {

        if (tamanho == elementos.length) {
            expandir();
        }

        if (indice < 0 || indice > elementos.length) {
            System.out.println("Posição Inválida");
            return;
        }

        for (int i = tamanho ; i > indice; i-- ) {
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }

    public void inserirOrdenado(T valor) {
        if (localizar(valor) != -1) {
            System.out.println("Valor " + valor + " já existe na lista.");
            return;
        }
        if (tamanho == elementos.length) {
            expandir();
        }

        int i;
        for (i = tamanho - 1; i >= 0; i--) {
            if (elementos[i].compareTo(valor) > 0) {
                elementos[i + 1] = elementos[i]; // desloca para a direita
            } else {
                break;
            }
        }
        elementos[i + 1] = valor;
        tamanho++;
    }





    public void inserirOrdenadov2(T valor) {

        if (localizar(valor) != -1) {
            System.out.println("Valor " + valor + " já existe na lista.");
            return;
        }

        if (tamanho == 0) {
            inserir(tamanho,valor);
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            if ((Integer)valor > (Integer) elementos[i]) {
                inserir(i+1,valor);
                break;
            }
        }
    }







    public int obterTamanho() {
        return tamanho;
    }

    public int localizar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return i;
            }
        }
        return -1;
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



}
