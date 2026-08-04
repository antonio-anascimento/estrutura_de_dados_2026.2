package Atividades.vetor.teste;
import Atividades.vetor.VetorEstatico;


public class ex4 {

    static void main(){

        VetorEstatico vetorEstatico = new VetorEstatico(10);

        vetorEstatico.inserir("A");
        vetorEstatico.inserir("B");
        vetorEstatico.inserir("C");
        vetorEstatico.inserir("D");
        vetorEstatico.inserir("F");

        vetorEstatico.imprimir();

        System.out.println("Removendo elemento C");
        vetorEstatico.remover("C");

        System.out.println("Arranjo apos a remoção");
        vetorEstatico.imprimir();

    }
}
