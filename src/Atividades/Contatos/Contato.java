package Atividades.Contatos;

public class Contato {

    private String Nome;
    private String Telefone;
    private String email;

    public Contato(String nome, String telefone) {
        Nome = nome;
        Telefone = telefone;
        this.email = "";
    }

    public Contato(String nome, String telefone, String email) {
        Nome = nome;
        Telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        if(email.isEmpty()){
            return "Nome: " + Nome + ", Telefone: " + Telefone;
        }
        return "Nome: " + Nome + ", Telefone: " + Telefone + ", Email: " + email;
    }
}
