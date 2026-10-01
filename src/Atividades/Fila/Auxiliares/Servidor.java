package Atividades.Fila.Auxiliares;

import java.util.Random;

public class Servidor {

    private int totalReq = 0;
    private int totalReqAtendidas = 0;
    private int totalReqPerdidas = 0;

    private Random aleatorio;
    private Fila<String> fila;
    private int qtdeProcessadores;
    private int N;

    public Servidor(int capacidadeFila, int qtdeProcessadores, int maxReqPorCiclo) {
        this.fila = new Fila<>(capacidadeFila);
        //deixando seed fixa para conseguir reproduzir depois.
        this.aleatorio = new Random();
        this.qtdeProcessadores = qtdeProcessadores;
        this.N = maxReqPorCiclo;
    }

    public void executar(int ciclos) {

        for (int ciclo = 1; ciclo <= ciclos; ciclo++) {

            // cada processador atende 1 requisição do começo da fila
            for (int p = 0; p < qtdeProcessadores; p++) {
                //so atende se a fila nao tiver vazia.
                if(!fila.isEmpty()){
                    fila.desenfileirar();
                    totalReqAtendidas++;
                }
            }

//            sorteia de 0 a N novas requisições neste ciclo
            int novasReq = aleatorio.nextInt(0, N);

            //gerando requisições
            for (int i = 0; i < novasReq; i++) {
                totalReq++; //toda requisição é contada
                if(fila.isFull()){
                    totalReqPerdidas++; // se tiver cheia descarta
                } else{
                    fila.enfileirar("Req" + totalReq); // senão contabiliza
                }
            }
        }
    }

    public double porcentagemDePerda() {
        if(totalReq == 0){
            return 0;
        }
        double perda = ((double)totalReqPerdidas/totalReq) * 100;
        return perda;
    }
}