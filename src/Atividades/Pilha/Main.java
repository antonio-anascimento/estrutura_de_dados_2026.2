//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Pilha<Integer> pilha = new Pilha<>(10);
    System.out.println("A pilha esta vazia " + pilha.isEmpty());
    // inserindo dados
    pilha.push(10);
    pilha.push(11);
    pilha.push(12);
    pilha.push(13);
    pilha.push(14);
    System.out.println("A pilha esta vazia " + pilha.isEmpty());
    // Removendo dados
    pilha.pop();
    int valor = pilha.pop();
    System.out.println("Segundo valor desempilhado: " + valor);
    pilha.pop();
    pilha.pop();
    pilha.pop();
    pilha.pop();




}
