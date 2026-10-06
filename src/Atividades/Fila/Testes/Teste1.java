package Atividades.Fila.Testes;

public class Teste1 {

    static void main(){
        Atividades.FIla.Fila<String> fila = new Atividades.FIla.Fila<>(10);

        fila.enfileirar("A");
        fila.enfileirar("B");
        fila.enfileirar("C");
        fila.imprimir();
        fila.enfileirar("D");
        fila.enfileirar("E");
        fila.desenfileirar();
        fila.imprimir();
    }
}
