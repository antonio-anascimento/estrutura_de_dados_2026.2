package Atividades.Vetor.teste;

import Atividades.ClassesTeste.Produto;
import Atividades.Vetor.Vetor;

public class ex10 {


    static void main(){
        Vetor<Produto> estoque =
                new Vetor<>(10);

        estoque.inserir(new Produto(1, "Monitor", 500));
        estoque.inserir(new Produto(1, "Teclado", 100));
        estoque.inserir(new Produto(1, "Mouse", 10));

        estoque.imprimir();
    }

}
