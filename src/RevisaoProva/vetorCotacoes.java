package RevisaoProva;

/*
 * TAD vetorCotacoes
 * - Guarda cotações (double) de 0.01 a 100, SEMPRE em ordem crescente.
 * - Posição vaga = -1 (valor impossível, funciona como "sentinela").
 * - Permite cotações repetidas.
 *
 * IDEIA CENTRAL: o vetor fica sempre COMPACTO (sem buracos no meio).
 * Os valores válidos ficam de 0 até tamanho - 1; depois disso só tem -1.
 */
public class vetorCotacoes {

    private double precos[];   // a "caixa". A capacidade é precos.length (nunca muda)
    private int tamanho;       // quantas cotações VÁLIDAS existem (muda a cada inserir/remover)
    // obs.: o atributo "capacidade" que você tinha foi tirado: precos.length já é a capacidade

    // ------------------------------------------------------------------
    // CONSTRUTOR: sem ele o array nunca existe → NullPointerException.
    // new double[...] nasce cheio de 0.0, por isso chamamos Limpar()
    // para marcar tudo como vaga (-1) e zerar o tamanho.
    // ------------------------------------------------------------------
    public vetorCotacoes(int capacidade) {
        precos = new double[capacidade];
        Limpar();
    }

    // ------------------------------------------------------------------
    // (a) INSERIR ORDENADO — O(n)
    // Ideia: abrir um buraco no lugar certo, empurrando os MAIORES
    // uma casa para a direita, andando de TRÁS para FRENTE.
    // ------------------------------------------------------------------
    public void InserirOrdenado(double preco) {
        // 1. Checagens ANTES de mexer no vetor
        if (preco < 0.01 || preco > 100) return;   // fora do intervalo permitido
        if (tamanho == precos.length) return;      // vetor cheio: não cabe mais nada

        // 2. Começa no ÚLTIMO elemento válido
        int i = tamanho - 1;

        // 3. Enquanto o elemento for MAIOR que o novo, empurra ele para a direita.
        //    i >= 0 vem PRIMEIRO no && para nunca acessar precos[-1].
        while (i >= 0 && precos[i] > preco) {
            precos[i + 1] = precos[i];   // o loop SÓ desloca
            i--;
        }

        // 4. FORA do loop: o while parou com i no primeiro elemento <= preco
        //    (ou em -1, se todos eram maiores). O buraco livre é i + 1.
        //    Isso também resolve sozinho: vetor vazio (i = -1 → grava na posição 0)
        //    e valor maior que todos (o while nem roda → grava em tamanho).
        precos[i + 1] = preco;

        // 5. FORA do loop: soma 1 UMA única vez
        tamanho++;
    }

    // ------------------------------------------------------------------
    // (b) REMOVER — O(n)
    // Ideia: achar a posição e FECHAR o buraco puxando os da direita
    // uma casa para a esquerda, andando da FRENTE para TRÁS.
    // ------------------------------------------------------------------
    public boolean RemoverPorId(double preco) {
        // 1. Achar a posição (aqui com busca linear: O(n), funciona sempre).
        //    Poderia ser: int pos = buscaBinaria(preco);
        int pos = -1;
        for (int i = 0; i < tamanho; i++) {        // só até tamanho (nunca olha as vagas)
            if (precos[i] == preco) {
                pos = i;
                break;                             // achou: para de procurar
            }
        }
        if (pos == -1) return false;               // não existe: NÃO mexe em nada

        // 2. Puxa todo mundo da direita uma casa para a esquerda.
        //    i < tamanho - 1 porque lemos precos[i + 1]: se fosse i < tamanho,
        //    na última volta leria uma vaga (ou sairia do vetor se estivesse cheio).
        for (int i = pos; i < tamanho - 1; i++) {
            precos[i] = precos[i + 1];
        }

        // 3. FORA do loop: a última posição que era usada vira vaga
        precos[tamanho - 1] = -1;

        // 4. FORA do loop: diminui 1 UMA única vez
        tamanho--;
        return true;
        // Complexidade: achar O(n) + deslocar O(n) = O(n).
        // Mesmo com busca binária seria O(log n) + O(n) = O(n): o deslocamento domina.
    }

    // ------------------------------------------------------------------
    // (c) LER DE UMA POSIÇÃO — O(1)
    // Recebe um ÍNDICE e devolve o VALOR guardado ali. Sem laço:
    // acesso direto é a grande vantagem do array.
    // ------------------------------------------------------------------
    public double LerPosicao(int posicao) {
        // CORRIGIDO: faltava validar. Sem isso, posicao = 10 num vetor de 5
        // daria exceção, e uma posição vaga devolveria -1 como se fosse válida.
        if (posicao < 0 || posicao >= tamanho) return -1;
        return precos[posicao];
    }

    // ------------------------------------------------------------------
    // (d) BUSCA BINÁRIA — O(log n)
    // Só funciona porque o vetor está ORDENADO.
    // A cada volta olha o meio e descarta metade do vetor.
    // Devolve a POSIÇÃO (int), mesmo o vetor sendo de double.
    // ------------------------------------------------------------------
    public int buscaBinaria(double preco) {
        int inicio = 0;
        int fim = tamanho - 1;            // tamanho - 1, NUNCA precos.length - 1
        // (as vagas -1 quebrariam a ordenação)
        while (inicio <= fim) {           // <= porque quando inicio == fim ainda sobra 1 elemento
            int meio = (inicio + fim) / 2;    // DENTRO do loop: recalcula a cada volta

            if (precos[meio] == preco) {      // compara com o VALOR (precos[meio]),
                return meio;                  // mas devolve a POSIÇÃO (meio)
            } else if (precos[meio] < preco) {
                inicio = meio + 1;            // o meio é menor: o valor só pode estar à DIREITA
            } else {
                fim = meio - 1;               // o meio é maior: o valor só pode estar à ESQUERDA
            }
            // o +1 e o -1 tiram o meio (já testado) do intervalo; sem eles pode virar loop infinito
        }
        return -1;                        // inicio passou de fim: não está no vetor
    }

    // ------------------------------------------------------------------
    // (e) MENOR E MAIOR — O(1)
    // Como o vetor está sempre ordenado (crescente), não precisa de laço:
    // menor = primeiro, maior = último VÁLIDO.
    // ------------------------------------------------------------------
    public String MenorMaior() {
        if (tamanho != 0) {               // sem esse if, vazio daria precos[-1] → exceção
            double Menor = precos[0];
            double Maior = precos[tamanho - 1];   // tamanho - 1, não precos.length - 1
            return "Menor = " + Menor + " Maior = " + Maior;
        }
        return "Vazio!";
    }

    // ------------------------------------------------------------------
    // (f) IMPRIMIR — O(n)
    // ------------------------------------------------------------------
    public void ImprimirNaTela() {
        // CORRIGIDO: era i < precos.length, que imprimia também as vagas (-1).
        // Até tamanho, só aparecem as cotações válidas.
        for (int i = 0; i < tamanho; i++) {
            System.out.printf("%.2f ", precos[i]);   // 2 casas decimais, como no gabarito
        }
        System.out.println();
        // obs.: IO.println só existe no Java 25. System.out funciona em qualquer versão.
    }

    // ------------------------------------------------------------------
    // (g) LIMPAR — O(n)
    // Único método que percorre TODAS as posições (precos.length),
    // porque precisa marcar até as vagas.
    // ------------------------------------------------------------------
    public void Limpar() {
        for (int i = 0; i < precos.length; i++) {
            precos[i] = -1;
        }
        tamanho = 0;                      // FORA do loop
    }
}

/*
 * RESUMO DOS LIMITES DE LAÇO (decore):
 *   ler / imprimir / buscar ............ i < tamanho
 *   limpar ............................. i < precos.length
 *   último válido ...................... precos[tamanho - 1]
 *   próxima vaga ....................... precos[tamanho]
 *
 * REGRA DE OURO: o loop só desloca. Gravar o valor e mexer no tamanho
 * acontece DEPOIS do loop, uma vez só.
 */