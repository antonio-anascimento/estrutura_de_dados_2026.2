public class MainEditor {

    static void main() {

        EditorTexto editor = new EditorTexto();

        editor.escrever("Olá ");
        editor.escrever("Mundo!");

        System.out.println("Conteudo atual: " + editor.getConteudo());

        editor.desfazer();
        System.out.println("Conteudo após DESFAZER " + editor.getConteudo());

        editor.refazer();
        System.out.println("Conteudo após REFAZER " + editor.getConteudo());

        editor.escrever("\n  --VÃO ESTUDAR!--");
        System.out.println("Conteudo final: " + editor.getConteudo());




    }
}
