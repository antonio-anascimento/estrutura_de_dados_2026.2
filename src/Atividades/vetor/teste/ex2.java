package Atividades.vetor.teste;
import Atividades.vetor.VetorEstatico;


public class ex2{

    static void main(){

        VetorEstatico vetorEstatico = new VetorEstatico(10);

        vetorEstatico.inserir("A");
        vetorEstatico.inserir("B");
        vetorEstatico.inserir("C");
        vetorEstatico.inserir("D");
        vetorEstatico.inserir(2,".");

        vetorEstatico.imprimir();
        vetorEstatico.obterTamanho();
        vetorEstatico.removerUltimo();
        vetorEstatico.imprimir();
        vetorEstatico.obterTamanho();

    }
}