package lab05;

import Atividades.Fila.FilaCircular;

public class Escalonador {

    public static void main(String[] args) {
        Processo[] processos = {
                new Processo("P1", 7, 0),
                new Processo("P2", 4, 0),
                new Processo("P3", 5, 1),
                new Processo("P4", 6, 2),
                new Processo("P5", 3, 4)
        };

        FilaCircular<Processo> fila = new FilaCircular<>(5);
        boolean[] jaEntrou = new boolean[5];  // começa tudo false
        int tempo = 0;
        int terminados = 0;

        while (terminados < 5) {

            for (int i = 0; i < 5; i++) {
                if (!jaEntrou[i] && processos[i].getTempoChegada() <= tempo) {
                    System.out.println("Tempo " + processos[i].getTempoChegada() + ": "
                            + processos[i].getNome() + " chegou e entrou na fila.");
                    fila.enfileirar(processos[i]);
                    jaEntrou[i] = true;
                }
            }


            if (fila.isEmpty()) {
                System.out.println("Tempo " + tempo + ": fila vazia.");
                continue;
            }

            Processo p = fila.desenfileirar();
            p.setStatus(Status.EXECUTANDO);

            int executar = 2;
            if (p.getInstrucoesRestantes() < 2) {
                executar = p.getInstrucoesRestantes();
            }

            System.out.println(p.getNome() + " executando...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.executar(executar);
            System.out.println(p.getNome() + " executou " + executar
                    + " instruções. Restam: " + p.getInstrucoesRestantes());

            //volta pra fila?
            if (p.getInstrucoesRestantes() == 0) {
                p.setStatus(Status.TERMINADO);
                System.out.println(p.getNome() + " terminou!");
                terminados++;
            } else {
                p.setStatus(Status.PRONTO);
                fila.enfileirar(p);
            }

            System.out.println();
            tempo++;

        }
        System.out.println("ACABOU!");
    }
}
