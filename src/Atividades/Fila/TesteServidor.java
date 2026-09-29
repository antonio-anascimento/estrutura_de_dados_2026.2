package Atividades.Fila;

public class TesteServidor {

    public static void main(String[] args) {

        // Fila de 10, 4 processadores, chegam de 0 a 4 por ciclo (média 2)
        Servidor tranquilo = new Servidor(10, 4, 4);
        tranquilo.executar(10000);
        System.out.println("TRANQUILO (Fila = 10,P=4,N=4)");
        System.out.println("Perda: " + tranquilo.porcentagemDePerda() + "%");
        System.out.println();

        // Fila de 8, 3 processadores, chegam de 0 a 8 por ciclo (média 4)
        Servidor medio = new Servidor(8, 3, 8);
        medio.executar(10000);
        System.out.println("MÉDIO (Fila = 8,P=3, N=8)");
        System.out.println("Perda: " + medio.porcentagemDePerda() + "%");
        System.out.println();

        // Fila de 5, 1 processador, chegam de 0 a 10 por ciclo (média 5)
        Servidor caotico = new Servidor(5, 1, 10000);
        caotico.executar(10000);
        System.out.println("CAÓTICO (Fila = 5,P=1, N=10)");
        System.out.println("Perda: " + caotico.porcentagemDePerda() + "%");
    }
}