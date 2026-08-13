package Atividades.Vetor.teste;

import Atividades.ClassesTeste.Caixa;

public class ex9 {

    static void main(){

        Caixa<String> caixaTexto = new Caixa<>();
        caixaTexto.guardar("Olá mundo!");
        IO.println(caixaTexto.abrir());

        Caixa<Integer> caixaNumero = new Caixa<>();
        caixaNumero.guardar(50);
        IO.println(caixaTexto.abrir());
    }
}
