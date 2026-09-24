package Atividades.Fila;

public class Teste2 {

    static void main() {
        Fila<Pacote> fila = new Fila<Pacote>(10);

        Produtor pr1 = new Produtor("Produto 1", "PC-A");
        Produtor pr2 = new Produtor("Produto 2", "PC-B");

        pr1.produzirPacote(fila, 1, "Login", "Servidor 1", "AAAA");
        pr1.produzirPacote(fila, 2, "Imagem", "Servidor 2", "AAAA");


        pr2.produzirPacote(fila, 3, "Imagem", "Servidor 3", "AAAA");

        IO.println("FILA DE PACOTES");
        fila.imprimir();
        fila.desenfileirar();
        fila.imprimir();
    }
}
