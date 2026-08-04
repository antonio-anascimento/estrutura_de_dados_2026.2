package Atividades.vetor.teste;

import Atividades.vetor.VetorEstatico;

public class ex1 {

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
