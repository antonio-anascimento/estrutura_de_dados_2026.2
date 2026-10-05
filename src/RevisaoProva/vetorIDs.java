package RevisaoProva;

public class vetorIDs {

    private int elementos[];
    private int min = 1000;
    private int max = 9999;
    private boolean permiteRepetidos;
    private int tamanho;


    public vetorIDs(boolean permiteRepetidos, int capacidade){
        this.permiteRepetidos = permiteRepetidos;
        this.elementos = new int[capacidade];
        limparVetor();
    }

    public void inserirOrdenado(int valor){
        if(valor < min || valor > max){
            throw new RuntimeException("Valores inválidos!");
        }
        if(tamanho == elementos.length){
            throw new RuntimeException("Vetor cheio!");
        }

        if (!permiteRepetidos) {
            for (int k = 0; k < tamanho; k++) {
                if (elementos[k] == valor) {
                    throw new RuntimeException("ID repetido!");
                }
            }
        }

        int i = tamanho -1;

        while (i>=0 && elementos[i] > valor){
            elementos[i + 1] = elementos[i];
            i--;
        }
        elementos[i +1] = valor;
        tamanho++;

    }

    public void removerId(int id){
        int pos = buscaBinaria(id);
        if(pos == -1){
            throw new RuntimeException("posição inválida!");
        }

        for (int i = 0; i < tamanho -1 ; i++) {
            elementos[i] = elementos [i +1];
        }

        elementos[tamanho - 1] = 999;
        tamanho--;
    }

    public int lerID(int posicao){
        if(tamanho == 0){
            throw new RuntimeException("Array Vazio!");
        }
        if(posicao < 0 || posicao >= tamanho) {
            return -999;
        }
        return elementos[posicao];
    }

    public int buscaBinaria(int valor){
        int inicio = 0;
        int fim = tamanho -1;

        while (inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(elementos[meio] == valor){
                return meio;
            } else if(elementos[meio] < valor){
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public String maiorMenor(){
        int maior = elementos[tamanho - 1];
        int menor = elementos[0];

        return "Maior: " + maior+ ",Menor: " + menor;
    }

    public void imprimir(){
        for (int i = 0; i <= tamanho ; i++) {
            IO.println(elementos[i]);
        }
    }

    public void limparVetor(){
        for (int i = 0; i <elementos.length ; i++) {
            elementos[i] = -999;
        }
        tamanho = 0;
    }
}
