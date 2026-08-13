package Atividades.Vetor;

public class VetorEstatico {

    private String[] elementos;
    private int tamanho;

    public VetorEstatico(int quantidade){
        elementos = new String[quantidade];
        this.tamanho = 0;
    }

    public void inserir(String elemento){
        if(tamanho< elementos.length){
            elementos[tamanho] = elemento;
            tamanho++;
        } else{
            System.out.println("Vetor cheio!");
        }
    }

    public void inserir (int indice, String elemento){
        if(tamanho >= elementos.length){
            System.out.println("Vetor cheio!");
            return;
        }
        if(indice<0 || indice >= tamanho){
            System.out.println("Posição inválida");
            return;
        }
        for(int i = tamanho; i>indice; i--){
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }

    public void remover(int indice){
        if(indice<0 || indice >= tamanho){
            System.out.println("Posição inválida");
            return;
        }

        for(int i = indice; i < tamanho; i++){
            elementos[i] = elementos[i+1];
        }

        elementos[tamanho-1] = null;
        tamanho--;
    }

    public void remover(String elemento){
        for(int i = 0; i < tamanho; i++){
            if(elementos[i].equals(elemento)){
                remover(i);
                return;
            }
        }
    }

    public int obterTamanho(){
        System.out.println(tamanho);
        return tamanho;
    }

    public String ler(int indice){
        if(indice >= 0 && indice<tamanho){
            return elementos[indice];
        } else {
            throw new IndexOutOfBoundsException("Indice inválido");
        }
    }

    public void removerUltimo(){
        if(tamanho>0){
            elementos[tamanho -1] = null;
            tamanho--;
        } else {
            System.out.println("Vetor vazio");
        }
    }

//    public void inserir(String elemento){
//        for(int i = 0; i < elemento.length(); i++){
//            if(elementos[i] == null){
//                elementos[i] = elemento;
//                return;
//            }
//        }
//        System.out.println("Não existe posição disponivel");
//    }

    public void imprimir(){
        System.out.print("[");
        for(int i = 0; i < tamanho; i++){
            System.out.print(elementos[i]);
            if(i < tamanho - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

