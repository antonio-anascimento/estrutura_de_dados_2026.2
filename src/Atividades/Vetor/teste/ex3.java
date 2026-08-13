package Atividades.Vetor.teste;
import Atividades.Vetor.VetorEstatico;


public class ex3 {

    static void main(){

        VetorEstatico vetorEstatico = new VetorEstatico(10);

        vetorEstatico.inserir("A");
        vetorEstatico.inserir("B");
        vetorEstatico.inserir("C");
        vetorEstatico.inserir("D");
        vetorEstatico.inserir("F");

        vetorEstatico.imprimir();

        System.out.println("Removendo na posição 2");
        vetorEstatico.remover(2);

        System.out.println("Arranjo apos a remoção");
        vetorEstatico.imprimir();

    }
}
