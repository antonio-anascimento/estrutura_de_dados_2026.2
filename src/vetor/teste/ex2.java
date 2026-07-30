package vetor.teste;

import vetor.VetorEstatico;

public class ex2 {

    static void main(){
        VetorEstatico vetorEstatico = new VetorEstatico(10);

        vetorEstatico.inserir("A");
        vetorEstatico.inserir("B");
        vetorEstatico.inserir("C");
        vetorEstatico.inserir("F");
        vetorEstatico.inserir(2,"W");


        vetorEstatico.imprimir();
    }
}
